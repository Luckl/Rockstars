package com.luckl.rockstar.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Artist {

    @Id
    private int id;
    private String name;

    @OneToMany(mappedBy = "artist")
    private List<Song> songs;
}
