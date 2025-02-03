package com.viny.db.Repositories;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;





@Repository
public class CustomSPRepository {

    private final String AccessToken = "BQA3O4OWfeyCYOHR2vbor0Wra8mOdubNqc2PFr07rXDQkxUehYCDmt0WxWEWHhuczvAK9KDz73KuDu_wI1lDbFLWxfXkdBa3Bn8ufS4Z2Lb_iO60dQivKIPx06A-s6eJFFocWKI9Tu0";
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
}
