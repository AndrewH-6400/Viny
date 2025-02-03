package com.viny.db.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.viny.db.Models.MyCollection;

//collection repository, uses JpaRepository to handle most of the operations
@Repository
public interface CollectionRepository extends JpaRepository<MyCollection, Integer> {
    //getById method (Jpa handles SQL)
    MyCollection getById(int id);

    //@Query("{'userID'}")
    MyCollection getByUserID(int userID);
}
