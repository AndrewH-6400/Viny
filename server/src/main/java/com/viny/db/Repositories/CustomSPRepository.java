package com.viny.db.Repositories;

import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.viny.db.Models.MyAlbum;





@Repository
public class CustomSPRepository {

    private String AccessToken;
    
    private final String uri = "https://api.spotify.com/v1/";    

    //for more info ~https://developer.spotify.com/documentation/web-api/reference/search

    //refresh the access token that expires every hour
    //I decided not to run a timer since I won't need 100% uptime so renewing when I need it is enough
    private void refreshAccessToken(){
        //set up restTemplate and url for entity
        RestTemplate restTemplate = new RestTemplate();
        URI url;
        //needed to catch a url error
        try {
            url = new URI("https://accounts.spotify.com/api/token");
        } catch (URISyntaxException e) {
            url = null;
        }
        //create headers with a necessary content type
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type","application/x-www-form-urlencoded");
        //create requestEntity and response for the call to the spotify Api
        RequestEntity<String> request = new RequestEntity<String>("grant_type=client_credentials&client_id=f0fba53b459641429486e3e7f9d1c397&client_secret=2b195b3757dd431887f2a711f1277d93",headers, HttpMethod.POST,url);                    
        ResponseEntity<String> response = restTemplate.exchange(request,String.class);
        //ObjectMapper and jsonNode to read the JSON response from spotify
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode;
        //to catch errors, but this will return nothing if the jsonNode isn't there
        try {
            //initializing the jsonNode
            jsonNode = mapper.readTree(response.getBody().toString());
        } catch (JsonMappingException e) {            
            jsonNode = null;
        } catch (JsonProcessingException e) {            
            jsonNode = null;
        }
        //set the accesstoken
        System.out.println("\n"+"AccessToken Refreshed"+"\n");
        AccessToken = jsonNode.get("access_token").asText();        
    }

    //modularizing the call each method will make having the url and method be variable
    private ResponseEntity<String> makeCallToSpotify(String url,HttpMethod httpMethod){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer "+AccessToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);                
        ResponseEntity<String> response;

        //if there is an error use the refresh method to get a new accessToken and try again
        try {            
            response = restTemplate.exchange(url, httpMethod, entity, String.class);
        } catch (Exception e) {
            refreshAccessToken();
            try {                
                //have to create new headers and entity so that the call is updated
                HttpHeaders header2 = new HttpHeaders();
                header2.add("Authorization", "Bearer "+AccessToken);                 
                HttpEntity<String> entity2 = new HttpEntity<>(header2);   
                response = restTemplate.exchange(url, httpMethod, entity2, String.class);
            } catch (Exception f) {
                //a second failure means it wasn't the AccessToken but we still need to return something
                return null;
            }
        }
        //return the Response unedited, all will be ResponseEntity<String> but some will get processed into other objects
        return response;
    }

    private MyAlbum processResponse(ResponseEntity<String> response){
        //Obj mapper and jsonNode to iterate through the response
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode;
        //catch the errors and stop if they are thrown
        try {
            jsonNode = mapper.readTree(response.getBody().toString());
        } catch (JsonMappingException e) {            
            return null;
        } catch (JsonProcessingException e) {            
            return null;
        }
        //Obj that is used to sort the data uniformly
        MyAlbum album = new MyAlbum();
        //album id
        album.setId(jsonNode.get("id").asText());
        //album title
        album.setTitle(jsonNode.get("name").asText());
        //artists (this may be an issue w/multiple artists)
        album.setArtistName(jsonNode.get("artists").get(0).get("name").asText());
        //genre
        //this was deprecated in the spotify api and will be left for future use
        album.setGenres(null);
        
        //tracks
        //a HUGE amount of track information is saved this might need to be its own object
        album.setTracks(null);

        //length
        //will need to pull information about each tracks length and add them together
        //as such this might not be needed and instead calculated when looking at an album
        //or create a special setter for tracks which calculates the total length and saves it then
        album.setLength(0);

        //imgs
        //creates an iterator to go through all of the elements within the images array
        Iterator<JsonNode> iterator = jsonNode.get("images").elements();     
        //a place to temporarily store the results
        //with an addImages method in the MyAlbum class we can eliminate this   
        ArrayList<String> images = new ArrayList<>();
        //goes to each jsonNode within images and gets the field url as text and adds it to our temp
        iterator.forEachRemaining(e -> images.add(e.get("url").asText()));
        album.setImages(images);

        return album;
    }

    //Searches spotify for an album by name
    public MyAlbum searchSPAlbum(String name){
        //searching by name and type (album) limit and offset will be modified to allow displaying and showing larger amounts of information
        ResponseEntity<String> response = makeCallToSpotify(uri+"search?q="+name+"&type=album&limit=2", HttpMethod.GET);
        
        //return our response as a MyAlbum obj
        return (processResponse(response));        
    }

    //take album id and return the response from spotify
    public MyAlbum searchSPAlbumID(String id){                

        ResponseEntity<String> response = makeCallToSpotify(uri+"albums/"+id, HttpMethod.GET);
        //return our response as a MyAlbum obj
        return (processResponse(response));  
    }    

    public MyAlbum returnAlbumObj(String id){        

        ResponseEntity<String> response = makeCallToSpotify(uri+"albums/"+id, HttpMethod.GET);

        return processResponse(response);
    }

    public List<MyAlbum> returnUserAlbums(String[] albums){

        List<MyAlbum> albumList = new ArrayList<>();
        for (String albumId : albums) {
            
            ResponseEntity<String> response = makeCallToSpotify(uri+"albums/"+albumId, HttpMethod.GET);
            albumList.add(processResponse(response));
        }
    
        return albumList;
    }    
}
