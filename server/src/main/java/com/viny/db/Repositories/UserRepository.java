package com.viny.db.Repositories;

import com.viny.db.Models.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<MyUser, Integer>{
    //get by id
    MyUser getById(int id);
}
