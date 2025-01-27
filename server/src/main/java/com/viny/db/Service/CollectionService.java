package com.viny.db.Service;

import org.springframework.stereotype.Service;

import com.viny.db.Models.MyCollection;
import com.viny.db.Repositories.CollectionRepository;

@Service
public class CollectionService {
    
    private final CollectionRepository collectionRepository;

    public CollectionService(CollectionRepository collectionRepository){
        this.collectionRepository = collectionRepository;
    }

    public void saveCollection(MyCollection collection){
        collectionRepository.save(collection);
    }
}
