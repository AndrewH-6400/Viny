package com.viny.db.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
 

    //importing and using UserDetailsService works in place of MyUserDetailService
    //same thing that is implemented within MyUserDetailsService
    //dependency inversion
    private final UserDetailsService userDetailService;

    public SecurityConfig(UserDetailsService userDetailService){
        this.userDetailService = userDetailService;
    }


    //these are where security chains will exist, this will be how roles and authentications are enforced
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
            .authorizeHttpRequests((authorize) -> authorize
                .requestMatchers("/**").permitAll()                                
                .anyRequest().authenticated()                                  
            )
            //temp as csrf disabling exposes vulnerabilities, but right now it is blocking post requests
            .csrf(csrf -> csrf.disable());                     
        
        return http.build();
    }


    //exceptions to the security
    @Bean
    public WebSecurityCustomizer ignoreResources(){
        return(webSecurity) -> webSecurity
                .ignoring()
                .requestMatchers("/h2-console/**");

    }
    

    //custom authentication manager to not pull from system memory
    @Bean
    public AuthenticationManager authenticationManager() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();

        //set the user details service
        provider.setUserDetailsService(userDetailService);

        //set password encoder to the encoder method
        provider.setPasswordEncoder(encoder());

        return new ProviderManager(provider);
    }

    //encryption of passwords
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }    
}
