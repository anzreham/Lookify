package com.rhm.demo.models;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 5, message="Title must be at least 5 characters")
    private String title;

    @Size(min = 5, message="Artist must be at least  5 characters")
    private String artist;


    @Min(value = 1, message="rating must be between 1 and 10")
    @Max(value = 10, message="rating must be between 1 and 10")
    private int rating;

    public Song() {

    }

    public Song(Long id,  String title,  String artist,int rating) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.rating = rating;
    }


    public Song( String title,  String artist,  int rating) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
