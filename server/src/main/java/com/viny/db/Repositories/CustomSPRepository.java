package com.viny.db.Repositories;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Iterator;

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

    private final String AccessToken = "BQC1Gga0giKHC-UREBCp6qHa5yA_Kd3QH4QBirRNBSk6RS_t-lyE0oq5LGpkn-nfmEMv3Wr_JWacQZ_MdrCuWTKAV3FMOQ81qUVuCDfYHqqSN0Q-YRDRqdkH8cID6AGiUN2iFn9Ky24";
    //
    //^^needs to be changed every hour, will need automation eventually//
    
    private final String uri = "https://api.spotify.com/v1/";
    //example of search
    //https://api.spotify.com/v1/search?q=Crawler&type=album

    //q is the query and type is self explanitory for mor info ~https://developer.spotify.com/documentation/web-api/reference/search
    
    //receievs response entity but returns only the body of the spotify response to allow for headers to be added later
    public String searchSPAlbum(String name){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer "+AccessToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        
        //ResponseEntity<String> response = restTemplate.exchange(uri+"q="+name+"&type=album", HttpMethod.GET,entity, String.class);
        ResponseEntity<String> response = restTemplate.exchange(uri+"search?q="+name+"&type=album&limit=2", HttpMethod.GET,entity, String.class);            
        return (response.getBody());        
    }

    public String searchSPAlbumID(String id){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer "+AccessToken);        
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(uri+"albums/"+id, HttpMethod.GET,entity,String.class);
        return response.getBody();
    }    

    public MyAlbum returnAlbumObj(String id){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer "+AccessToken);        
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(uri+"albums/"+id, HttpMethod.GET,entity,String.class);
        //JSONPObject data = new JSONPObject(response.getBody(), JSONPObject.class);
        //JSONPObject data = new JSONPObject("", response.getBody());

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode;
        try {
            jsonNode = mapper.readTree(response.getBody().toString());
        } catch (JsonMappingException e) {            
            jsonNode = null;
        } catch (JsonProcessingException e) {            
            jsonNode = null;
        }

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
}
