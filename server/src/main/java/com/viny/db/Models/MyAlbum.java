package com.viny.db.Models;



import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MyAlbum {    
    private @Setter @Getter String id;
    private @Setter @Getter  String title;
    private @Setter @Getter  String artistName;
    //the genre part of the spotify api has been deprecated
    private @Setter @Getter  String[] genres;
    private @Setter @Getter  String[] tracks;
    private @Setter @Getter  int length;
    private @Setter @Getter  ArrayList<String> images;            
    
    
}
