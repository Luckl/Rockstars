package com.luckl.rockstar.entity;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Song {
    @Id
    @GeneratedValue
    private int id;
    private String name;

}
