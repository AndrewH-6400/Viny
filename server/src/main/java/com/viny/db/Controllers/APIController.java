package com.viny.db.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.viny.db.Service.SPService;

//@CrossOrigin(origins = "/*")
@RestController
@RequestMapping("/search")
public class APIController {
    private final SPService spService;

    public APIController(SPService spService){
        this.spService = spService;
    }    

    @GetMapping("/al")
    public ResponseEntity<String> albumSearch(){
        return ResponseEntity.ok().body(spService.album("Crawler"));
    }

    @GetMapping("/alid")
    public ResponseEntity<String> albumSearchById(
        @RequestParam String id
    ){

        return spService.albumbID(id);
    }
}
