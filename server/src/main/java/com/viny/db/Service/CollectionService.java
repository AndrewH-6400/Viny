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
    public void saveCollection(MyCollection collection){
        collectionRepository.save(collection);
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
}
