package com.viny.db.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viny.db.Service.SPService;

@RestController
@RequestMapping("/search")
public class APIController {
    private final SPService spService;

    public APIController(SPService spService){
        this.spService = spService;
    }

    @GetMapping("/home")
    public String home(){
        return("you are home");
    }

    @GetMapping("/al")
    public ResponseEntity<String> albumSearch(){
        return spService.album("Crawler");
    }
}
