package com.viny.db.Controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import com.viny.db.Models.MyCollection;
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
    public ResponseEntity<MyCollection> getCollection(
        @RequestParam int id
    ){
        return ResponseEntity.ok(collectionService.gCollection(id));
    }

    //retrieves the master collection of a user which is their "owned"
    @RequestMapping("/getMByUserId")
    public ResponseEntity<MyCollection> mCollection(
        @RequestParam int uid
    ){
        return ResponseEntity.ok(collectionService.masterCollection(uid));
    }    

    //retrieves list of collections based on associated user ID
    //searches a users collecction by name @RequestParam = String userID String searchTerm
    //saves a collection generating a unique ID @RP userID
    @PostMapping("/saveCollection")
    public ResponseEntity<String> saveCollection(
        @RequestBody MyCollection collection
    ){
        int res = collectionService.saveCollection(collection);
        if (res == 1) {
            return ResponseEntity.badRequest().body("Invalid Collection id");
        }
        return ResponseEntity.ok().body("Collection saved successfully"+getCollection(collection.getId()));
    }
    //updates a collection @RP ID and userID
    @PostMapping("/updateCollection")
    public ResponseEntity<String> updateCollection(
        @RequestBody MyCollection collection
    ){
        int res = collectionService.updateCollection(collection);
        if (res == 1) {
            return ResponseEntity.badRequest().body("Invalid Collection id");
        }
        return ResponseEntity.ok().body("Collection updated successfully"+getCollection(collection.getId()));
    }

    //deletes a collection @RP id userID and name (to make sure the right collection is about to be deleted)
}
