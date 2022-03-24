package com.group6;

import com.group6.movies.MoviesDAO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application {

    private final MoviesDAO moviesDAO = new MoviesDAO();

    public static void main(String[] args) {
        launch(args);
    }

        @Override
        public void start(Stage stage) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("../../Main.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Titel");
            stage.setScene(scene);
            stage.show();

        //Hämtar alla filmer från databasen
//        moviesDAO.readMovies();

        //Uppdatera en film
//        moviesDAO.updateMovie(1, "Harry Potter", "Magi");

        //Ta bort en film
//        moviesDAO.deleteMovie("Babblarna", "Thriller");
//        moviesDAO.deleteMovie(3);


        moviesDAO.readMovies();
    }

}
