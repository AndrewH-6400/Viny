package com.viny.db.Service;

import org.springframework.stereotype.Service;

import com.viny.db.Repositories.CustomSPRepository;

//spotify api service
@Service
public class SPService {

    //inject Custom Spotify Repository
    private final CustomSPRepository customSPRepository;
    public SPService(CustomSPRepository customSPRepository){
        this.customSPRepository = customSPRepository;
    }
    
    //search by album name
    public String album(String searchterm){
        return customSPRepository.searchSPAlbum(searchterm);
    }

    //get by spotify album ID
    public String albumbID(String id){
        return customSPRepository.searchSPAlbumID(id);
    }
}
