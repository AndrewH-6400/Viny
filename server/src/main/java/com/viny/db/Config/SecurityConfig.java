// package com.viny.db.Config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.authentication.AuthenticationProvider;
// import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig {
    
//     private final UserDetailsService userDetailsService;

//     public SecurityConfig(UserDetailsService userDetailsService){
//         this.userDetailsService = userDetailsService;
//     }

//     @Bean
//     SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        
//         http.authorizeHttpRequests((authorize) -> authorize
//             .requestMatchers("/**").permitAll()
//             .anyRequest().authenticated()
//         )
//         //where to find the custom login
//         .formLogin(customLogin -> {
//             customLogin.loginPage("/login")
//                 .defaultSuccessUrl("/")
//                 .permitAll();
//         })
//             .logout(l -> l
//                 .logoutUrl("/logout")                
//                 .permitAll());

//         return http.build();
//     }

//     //custom registry
//     @Bean
//     public AuthenticationProvider authenticationProvider(){
//         DaoAuthenticationProvider provider = new DaoAuthenticationProvider();

//         //1) user detail service
//         provider.setUserDetailsService(userDetailsService);

//         //2) password encoder
//         provider.setPasswordEncoder(passwordEncoder());

//         return provider;
//     }

//     // password encoding
//     @Bean
//     public BCryptPasswordEncoder passwordEncoder(){        
//         return new BCryptPasswordEncoder();
//     }

//     // exceptions
//     @Bean
//     public WebSecurityCustomizer ignoreResources(){
//         return(webSecurity) -> webSecurity
//                 .ignoring()
//                 .requestMatchers("/css/**","/h2-console/**");
//     }
// }
