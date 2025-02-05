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
 
    //save user
    public int saveUser(MyUser user){
        if (userRepository.existsById(user.getId())) {
            return 1;
        }
        userRepository.save(user);
        return 0;        
    }

    //get user
    public MyUser getUser(int id){
        if (userRepository.existsById(id)) {
            return userRepository.getById(id);
        }
        return null;
    }

    //update user
    public int updateUser(MyUser user){
        if(userRepository.existsById(user.getId())){
            userRepository.save(user);
            return 0;
        }
        return 1;
    }
    //delete user
    public int delUser(MyUser user){
        if(userRepository.existsById(user.getId())){
            userRepository.delete(user);
            return 0;
        }
        return 1;
    }
}
