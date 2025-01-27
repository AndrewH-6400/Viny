package com.viny.db.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    //Base Request for testing
    @GetMapping("/")
    public String test() {
        return "test";
    }
}