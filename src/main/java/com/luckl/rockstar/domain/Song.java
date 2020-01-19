package com.luckl.rockstar.domain;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class Song {

    @Id
    @GeneratedValue
    @JsonProperty("Id")
    private int id;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Year")
    private int year;

    @ManyToOne
    private Artist artist;

    @JsonProperty("Artist")
    @Transient
    private String artistName;

    @JsonProperty("Shortname")
    private String shortName;
    @JsonProperty("Bpm")
    private int bpm;
    @JsonProperty("Duration")
    private int duration;
    @JsonProperty("Genre")
    private String genre;
    @JsonProperty("SpotifyId")
    private String spotifyId;
    @JsonProperty("Album")
    private String album;

    public Song(String name, int year, String shortName, int bpm, int duration, String genre, String spotifyId, String album) {
        this.name = name;
        this.year = year;
        this.shortName = shortName;
        this.bpm = bpm;
        this.duration = duration;
        this.genre = genre;
        this.spotifyId = spotifyId;
        this.album = album;
    }

    protected Song() {
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public int getBpm() {
        return bpm;
    }

    public void setBpm(int bpm) {
        this.bpm = bpm;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSpotifyId() {
        return spotifyId;
    }

    public void setSpotifyId(String spotifyId) {
        this.spotifyId = spotifyId;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getArtistName() {
        return artistName;
    }
}
