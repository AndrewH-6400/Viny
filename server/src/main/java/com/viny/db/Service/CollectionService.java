package com.viny.db.Service;

import org.springframework.stereotype.Service;

import com.viny.db.Models.MyCollection;
import com.viny.db.Repositories.CollectionRepository;

//service for collections
@Service
public class CollectionService {
    
    //inject repository
    private final CollectionRepository collectionRepository;
    public CollectionService(CollectionRepository collectionRepository){
        this.collectionRepository = collectionRepository;
    }

    //saves collections
    public int saveCollection(MyCollection collection){
        if (collectionRepository.existsById(collection.getId())) {
            return 1;
        }
        collectionRepository.save(collection);
        return 0;
    }

    //update collection
    public int updateCollection(MyCollection collection){
        if (collectionRepository.existsById(collection.getId())) {
            collectionRepository.save(collection);            
            return 0;
        }
        return 1;
    }

    // return MyCollection object after getting by id
    public MyCollection gCollection(int id){
        //if collection does not exist return null
        if(collectionRepository.existsById(id)){
            return collectionRepository.getById(id);
        }
        else{
            return null;
        }
    }

    // return master collection object from userID
    public MyCollection masterCollection(int userID){
        return collectionRepository.getByUserID(userID);
        //return null;
    }    
}
