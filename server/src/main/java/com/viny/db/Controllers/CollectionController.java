package com.viny.db.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import com.viny.db.Service.CollectionService;

//Controller for CRUD operations pertaining to Collections
@RestController
@RequestMapping("/sc")
public class CollectionController {
    private final CollectionService collectionService;

    public CollectionController(CollectionService collectionService){
        this.collectionService = collectionService;
    }

    //retrieves an entire collection by its unique ID
    @RequestMapping("/getById")
    public ResponseEntity<String[]> collectionStrings(
        @RequestParam int id
    ){
        return ResponseEntity.ok(collectionService.gCollection(id).getAlbums());
    }

    //retrieves list of collections based on associated user ID
    //searches a users collecction by name @RequestParam = String userID String searchTerm
    //saves a collection generating a unique ID @RP userID
    //updates a collection @RP ID and userID
    //deletes a collection @RP id userID and name (to make sure the right collection is about to be deleted)
}
