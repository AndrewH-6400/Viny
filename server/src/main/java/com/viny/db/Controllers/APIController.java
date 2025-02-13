package com.viny.db.Controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.viny.db.Models.MyAlbum;
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
    public ResponseEntity<MyAlbum> albumSearch(
        @RequestParam String search
    ){        
        return ResponseEntity.ok().body(spService.album("Crawler"));
    }

    //searches spotify api using the apotify album id which will be saved to the database
    @GetMapping("/alid")
    public ResponseEntity<MyAlbum> albumSearchById(
        @RequestParam String id
    ){
        return ResponseEntity.ok().body(spService.albumbID(id));
    }

    //testing spotify processing
    @GetMapping("/alobid")
    public ResponseEntity<MyAlbum> albumObj(
        @RequestParam String id
    ){
        return ResponseEntity.ok().body(spService.albumReturn(id));
    }

    @GetMapping("/umcbuid")
    public ResponseEntity<List<MyAlbum>> albumList(
        @RequestParam int uid
    ){
        return ResponseEntity.ok().body(spService.albumsByUserId(uid));
    }
}
