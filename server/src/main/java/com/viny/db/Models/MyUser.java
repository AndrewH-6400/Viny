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

    @Column(nullable = true, unique = false)
    private String f_name;
    @Column(nullable = true, unique = false)
    private String l_name;

    @Column(nullable = false, unique = true)
    private String email;

    //make sure they make a username and that it is unique
    @Column(nullable = false, unique = true)
    private String username;

    //this will eventually be encrypted once the security is implemented
    @Column(nullable = false, length = 64)
    private String password;

    //necessary for the spring security
    //this may be replaced as string security's SecurityContext has roles there as well
    @Column(nullable = false, length = 64)
    private String role;
    
    //since the id is auto generated we can use a constructor that doesn't require it
    //any unspecified role will be a user
    public MyUser(String f_name, String l_name, String email, String username, String password){
        this.f_name = f_name;
        this.l_name = l_name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = "USER";
    }
    
}
