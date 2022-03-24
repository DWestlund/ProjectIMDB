package com.group6;

import com.group6.movies.Movies;
import com.group6.movies.MoviesDAO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;


public class Main extends Application {

    private final MoviesDAO moviesDAO = new MoviesDAO();

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Main.fxml")));
        stage.setTitle("HEJ!");
        stage.setScene(new Scene(root));
        stage.show();

        //Hämtar alla filmer från databasen
        moviesDAO.readMovies();

        //Lägger till en film i databasen
        Movies movie = new Movies("Harry Potter", "Fantasy");
        moviesDAO.createMovie(movie);

        //Uppdatera en film
//        moviesDAO.updateMovie(1, "Harry Potter", "Magi");

        //Ta bort en film
//        moviesDAO.deleteMovie("Babblarna", "Thriller");
//        moviesDAO.deleteMovie(3);


        moviesDAO.readMovies();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
