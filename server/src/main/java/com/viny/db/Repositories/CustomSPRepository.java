package com.viny.db.Repositories;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;



@Repository
public class CustomSPRepository {

    private final String AccessToken = "BQBcsPwlWXO1E309wB6303-hpeIL7Ng0hHslTrl98y2dEzxykRazHpyZkj1vVoG3-K2rptpSJtLB2XMW5Yh4Gs_30YRHMehjFquary0Rm-nRsdrM_wX1Y3v0gl3rQVzH9GXHCvCHZBA";
    //^^needs to be changed every hour, will need automation eventually//
    
    private final String uri = "https://api.spotify.com/v1/search?q=Crawler&type=album";
    //private final String uri = "https://api.spotify.com/v1/search?";

    //q=Crawler&type=album
    //q is the query and type is self explanitory for mor info ~https://developer.spotify.com/documentation/web-api/reference/search
    
    //Object[]
    public String searchSPAlbum(String name){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer "+AccessToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        
        //ResponseEntity<String> response = restTemplate.exchange(uri+"q="+name+"&type=album", HttpMethod.GET,entity, String.class);
        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET,entity, String.class);
        return response.getBody();
        
        //return null;
    }
}
