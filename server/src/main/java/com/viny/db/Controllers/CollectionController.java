package com.viny.db.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import com.viny.db.Service.CollectionService;

@RestController
@RequestMapping("/sc")
public class CollectionController {
    private final CollectionService collectionService;

    public CollectionController(CollectionService collectionService){
        this.collectionService = collectionService;
    }

    @RequestMapping("/getById")
    public ResponseEntity<String[]> collectionStrings(
        @RequestParam int id
    ){
        return ResponseEntity.ok(collectionService.gCollection(id).getAlbums());
    }
}
