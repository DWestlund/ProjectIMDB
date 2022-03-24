package com.group6.movies;

import com.group6.ratings.Ratings;
import com.group6.ratings.RatingsDAO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Collection;
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
//
//    @Column(name = "avgRating")
//    private double avgRating = 0;

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

//    public double getAvgRating() {
//        return avgRating;
//    }
//
//    public void setAvgRating(double avgRating) {
//        RatingsDAO ratingsDAO = new RatingsDAO();
//        Collection<Integer> ratings = new ArrayList<>();
//
//        for (Ratings r : ratingsDAO.readRatings(movieId)){
//            ratings.add(r.getRating());
//        }
//
//        avgRating = 0;
//        for (Integer num : ratings) {
//            avgRating += num;
//            System.out.println(num);
//        }
//        avgRating = avgRating / ratings.size();
//
//
//
//        this.avgRating = avgRating;
//    }

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

    private String getAvereg(){
        RatingsDAO ratingsDAO = new RatingsDAO();
        Collection<Integer> ratings = new ArrayList<>();

        for (Ratings r : ratingsDAO.readRatings(movieId)){
            ratings.add(r.getRating());
        }

        double avgRatingX = 0;
        for (Integer num : ratings) {
            avgRatingX += num;
            System.out.println(num);
        }
        avgRatingX = avgRatingX / ratings.size();
    return avgRatingX + "";
    }

    @Override
    public String toString() {
        return "Movies " +
                "   MovieId: " + movieId +
                "   Title: " + title  +
                "   Category: " + category + " Rating: "+ getAvereg();
    }
}
