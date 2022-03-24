package com.group6.movies;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Movies {
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Id
    @Column(name = "movieId")
    private int movieId;

    @Column(name = "title")
    private String title;

    @Column(name = "category")
    private String category;

    public Movies(String title, String category){
        this.title = title;
        this.category = category;
    }
    public Movies() {}

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movies movies = (Movies) o;
        return movieId == movies.movieId && Objects.equals(title, movies.title) && Objects.equals(category, movies.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieId, title, category);
    }

    @Override
    public String toString() {
        return "Movies{" +
                "movieId=" + movieId +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
