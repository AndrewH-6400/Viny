package com.viny.db.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.viny.db.Repositories.CustomSPRepository;

@Service
public class SPService {
    private final CustomSPRepository customSPRepository;
    
    public SPService(CustomSPRepository customSPRepository){
        this.customSPRepository = customSPRepository;
    }
    
    public String album(String searchterm){
        return customSPRepository.searchSPAlbum(searchterm);
    }

    public ResponseEntity<String> albumbID(String id){
        return customSPRepository.searchSPAlbumID(id);
    }
}
