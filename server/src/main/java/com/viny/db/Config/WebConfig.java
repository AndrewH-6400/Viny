package com.viny.db.Config;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
//this is in place for now to handle CORS until that can be handled by Spring security
public class WebConfig {
    //allows the server to communicate with machines on the localnetwork
    //will be replaced when later security is addeed
    
    // public void addCorsMappings(CorsRegistry registry){
    //     //the whole thing breaks if the .addMapping is changed
    //     registry.addMapping("/**")
    //     .allowedOrigins("http://localhost:3000")
    //     .allowedMethods("GET","PUT","DELETE","UPDATE","POST")        
    //     .allowCredentials(false).maxAge(3600);        
    // }
    @Bean
    public FilterRegistrationBean corsFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://localhost:3000");
        config.setAllowedHeaders(Arrays.asList(
            HttpHeaders.AUTHORIZATION,
            HttpHeaders.CONTENT_TYPE,
            HttpHeaders.ACCEPT
        ));
        //methods allowed for the client to specify when building their call
        config.setAllowedMethods(Arrays.asList(
            HttpMethod.GET.name(),
            HttpMethod.POST.name(),
            HttpMethod.PUT.name(),
            HttpMethod.DELETE.name()
        ));


        //30 minutes
        config.setMaxAge(3600L);

        //cors
        source.registerCorsConfiguration("/**", config);

        FilterRegistrationBean bean = new FilterRegistrationBean<>(new CorsFilter(source));
        
        //lowest position to be used before any other spring security feature
        bean.setOrder(-102);
        return bean;
    }
    
}
