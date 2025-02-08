package com.viny.db.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{
    //allows the server to communicate with machines on the localnetwork
    //will be replaced when later security is addeed
    @Override
    public void addCorsMappings(CorsRegistry registry){
        //the whole thing breaks if the .addMapping is changed
        registry.addMapping("/**")
        .allowedOrigins("http://localhost:3000")
        .allowedMethods("GET","PUT","DELETE","UPDATE","POST")        
        .allowCredentials(false).maxAge(3600);        
    }
    
}
