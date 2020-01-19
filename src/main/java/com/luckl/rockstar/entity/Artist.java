package com.luckl.rockstar.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Artist {

    @Id
    @GeneratedValue
    @JsonProperty("Id")
    private int id;
    @JsonProperty("Name")
    private String name;

    @OneToMany(mappedBy = "artist")
    private List<Song> songs;
}
