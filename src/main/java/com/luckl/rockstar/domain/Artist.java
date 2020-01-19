package com.luckl.rockstar.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collections;
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

    protected Artist() {
    }

    public Artist(String name, List<Song> songs) {
        this.name = name;
        this.songs = songs;
    }
    public Artist(String name) {
        this.name = name;
        this.songs = Collections.emptyList();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}
