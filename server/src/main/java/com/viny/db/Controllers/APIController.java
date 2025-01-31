package com.viny.db.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.viny.db.Service.SPService;

//Controller for spotify API requests
@RestController
@RequestMapping("/search")
public class APIController {

    //inject Spotify Service bean
    private final SPService spService;
    public APIController(SPService spService){
        this.spService = spService;
    }    

    //search the spotify api for an album
    @GetMapping("/al")
    public ResponseEntity<String> albumSearch(){
        //Crawler will be replaced with request param
        return ResponseEntity.ok().body(spService.album("Crawler"));
    }

    //searches spotify api using the apotify album id which will be saved to the database
    @GetMapping("/alid")
    public ResponseEntity<String> albumSearchById(
        @RequestParam String id
    ){
        return ResponseEntity.ok().body(spService.albumbID(id));
    }
}
