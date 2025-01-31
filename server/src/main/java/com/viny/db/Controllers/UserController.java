package com.viny.db.Controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//controller for user operations
@RestController
public class UserController {

    //Base Request for testing
    @GetMapping("/")
    public String test() {
        return "test";
    }

    //Create user
    //Retrieve user by id
    //Retrieve user by username
    //Update user by id
    //Delete user by name and id
}