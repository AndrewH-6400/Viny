package com.viny.db.Repositories;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.util.JSONPObject;



@Repository
public class CustomSPRepository {

    private final String AccessToken = "BQDFB2DCI3qb1N-dJYbCmKFN4EU8TJAKC3AHaYgd7RvuYX7_ptsHE9go1vhq9zzAZq05oiUwmMSzRjkr08p0uHaashaE_dQTH4mfb-O2CN1_8koTEjwYHle04C0Rfx-xgTZD6lFsAT8";
    //^^needs to be changed every hour, will need automation eventually//
    
    private final String uri = "https://api.spotify.com/v1/search?q=";
    //https://api.spotify.com/v1/search?q=Crawler&type=album

    //q=Crawler&type=album
    //q is the query and type is self explanitory for mor info ~https://developer.spotify.com/documentation/web-api/reference/search
    
    //Object[]
    public ResponseEntity<String> searchSPAlbum(String name){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer "+AccessToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        
        //ResponseEntity<String> response = restTemplate.exchange(uri+"q="+name+"&type=album", HttpMethod.GET,entity, String.class);
        ResponseEntity<String> response = restTemplate.exchange(uri+name+"&type=album&limit=2", HttpMethod.GET,entity, String.class);    
        return response;
        //return response.ok().body(response.getBody());
        
        //return null;
    }
}
