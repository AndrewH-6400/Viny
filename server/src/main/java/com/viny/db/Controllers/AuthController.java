package com.viny.db.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/auth")
public class AuthController {
        
    private final AuthenticationManager authenticationManager;
    private SecurityContextRepository securityContextRepository = new HttpSessionSecurityContextRepository();
    public AuthController(AuthenticationManager authenticationManager){        
        this.authenticationManager = authenticationManager;
    }

    //custom login
    @PostMapping("/login")
    //injecting HttpServlet request and response to be able to save the SecurityContext
    public ResponseEntity<SecurityContext> login(@RequestBody LoginRequest loginRequest, HttpServletRequest request, HttpServletResponse response){
        //login is authenticated with custom authenticator within the security config
        UsernamePasswordAuthenticationToken token = UsernamePasswordAuthenticationToken.unauthenticated(loginRequest.username(), loginRequest.password());
        //creating authentication token
        Authentication authentication = authenticationManager.authenticate(token);
        //security context to save the token
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(authentication);

        //save the security context in the securityContextRepository
        SecurityContextHolder.setContext(context);
        securityContextRepository.saveContext(context, request, response);     
        System.out.println(context.getAuthentication().getName());           
        //this will return an object with the information of the userlogin
        //including username and roles as well as some other information
        //does not contain any sensitive information
        return (ResponseEntity.ok().body(context)); 
    }

    public record LoginRequest(String username, String password) {
    }
}

