package com.viny.db.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.viny.db.Models.MyAlbum;
import com.viny.db.Repositories.CustomSPRepository;

//spotify api service
@Service
public class SPService {

    //inject Custom Spotify Repository
    private final CustomSPRepository customSPRepository;
    private final CollectionService collectionService;
    public SPService(CustomSPRepository customSPRepository, CollectionService collectionService){
        this.customSPRepository = customSPRepository;
        this.collectionService = collectionService;
    }
    
    //search by album name
    public String album(String searchterm){
        return customSPRepository.searchSPAlbum(searchterm);
    }

    //get by spotify album ID
    public String albumbID(String id){
        return customSPRepository.searchSPAlbumID(id);
    }

    //return album obj by album id
    public MyAlbum albumReturn(String id){
        return customSPRepository.returnAlbumObj(id);
    }

    //return list of album obj by userid (will be master collection for now)
    public List<MyAlbum> albumsByUserId(int userid){
        //I need to get the album id list from the users master collection then send that list to the sp repo
        return(customSPRepository.returnUserAlbums(
            collectionService.masterCollection(userid).getAlbums()
            ));        
    }
}
