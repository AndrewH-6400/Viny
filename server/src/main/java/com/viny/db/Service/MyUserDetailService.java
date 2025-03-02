// package com.viny.db.Service;

// import java.util.Optional;

// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.stereotype.Service;

// import com.viny.db.Models.MyUser;
// import com.viny.db.Repositories.UserRepository;

// @Service
// public class MyUserDetailService implements UserDetailsService {

//     //inject repository
//     private final UserRepository userRepository;
//     public MyUserDetailService(UserRepository userRepository){
//         this.userRepository = userRepository;
//     }

//     /*loadUserByUsername method fetches user details from the data source (user repo)
//     * and transform them into a UserDetails object that spring security can work with
//     * for authentication and authorization
//     * */

//     @Override
//     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{

//         Optional<MyUser> userOp = userRepository.getByUsername(username);

//         if (userOp.isPresent()) {
//             MyUser user = userOp.get();
//             return User.builder()
//                 .username(user.getUsername())
//                 .password(user.getPassword())
//                 .roles("Not Yet Implemented")                
//                 .build();
//         } else {
//             throw new UsernameNotFoundException("User Not Found");
//         }
//     }
// }
