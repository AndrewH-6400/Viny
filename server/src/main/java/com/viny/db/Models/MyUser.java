package com.viny.db.Models;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class MyUser {

    //auto generate a user id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //make sure they make a username and that it is unique
    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, length = 64)
    private String password;
    
    public MyUser(String username, String password){
        this.username = username;
        this.password = password;
    }
    
}
