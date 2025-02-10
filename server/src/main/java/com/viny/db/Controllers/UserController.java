package com.viny.db.Controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.viny.db.Models.MyUser;
import com.viny.db.Service.UserService;

//controller for user operations
@RestController
public class UserController {

    UserService userService;
    
    public UserController(UserService userService){
        this.userService = userService;
    }    
    //Create user
    @PostMapping("/saveUser")
    public ResponseEntity<String> saveUser(
        @RequestBody MyUser user
    ){
        System.out.println(user);
        if(userService.saveUser(user) ==1 ){
            return ResponseEntity.badRequest().body("Invalid user Id");
        }
        return ResponseEntity.ok().body("Successful Save"+userService.getUser(user.getId()));
    }
    //Retrieve user by id
    @GetMapping("/getUser")
    public ResponseEntity<MyUser> getUserById(
        @RequestParam int id
    ){
        MyUser user = userService.getUser(id);
        if (user != null) {
            return ResponseEntity.ok().body(user);
        } else{
            return ResponseEntity.badRequest().body(null);
        }
    }
    //Retrieve user by username
    //Update user
    @PostMapping("updateUser")
    public ResponseEntity<String> updateUser(
        @RequestBody MyUser user
    ){
        if(userService.updateUser(user) == 1){
            return ResponseEntity.badRequest().body("Invalid user Id");
        }
        return ResponseEntity.ok().body("Successful Update"+userService.getUser(user.getId()));
    }
    //Delete user by entity
    @DeleteMapping("delUser")
    public ResponseEntity<String> delUser(
        @RequestBody MyUser user
    ){
        if(userService.delUser(user) == 1){
            return ResponseEntity.badRequest().body("Invalid user Id");
        }
        return ResponseEntity.ok().body("Successful deletion");
    }
}