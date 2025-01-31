package com.viny.db.Repositories;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.RestClient.ResponseSpec;

import com.fasterxml.jackson.databind.util.JSONPObject;



@Repository
public class CustomSPRepository {

    private final String AccessToken = "BQAlDcMljSKX_uuAu3_UWlpQiLiSxpICAgMgFsMS1k2vFiNHEvAT_wu528R15P7396f6zQZGbdo2l-VEHHsMjjtCXlf5fvM5R2NsgWZJxd5ht226F4Oaj6D6FuDL9rEJI-ERABkegi8";
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
