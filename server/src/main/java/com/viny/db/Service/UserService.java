package com.viny.db.Service;

import org.springframework.stereotype.Service;

import com.viny.db.Models.MyUser;
import com.viny.db.Repositories.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
 
    public void saveUser(MyUser user){
        userRepository.save(user);
    }
}
