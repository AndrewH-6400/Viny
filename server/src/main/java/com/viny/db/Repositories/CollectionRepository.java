package com.viny.db.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.viny.db.Models.MyCollection;

@Repository
public interface CollectionRepository extends JpaRepository<MyCollection, Integer> {

}
