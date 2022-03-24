package com.group6.gui;

import com.group6.movies.Movies;
import com.group6.movies.MoviesDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class MainController {

    @FXML
    private Button btn_read;

    @FXML
    private ListView<Movies> lw_film;
    private ObservableList<Movies> movieList = FXCollections.observableArrayList();


    public Button getBtn_read() {
        return btn_read;
    }

    @FXML private void initialize(){
    ActionObserver observer = new ActionObserver(this);
    btn_read.setOnAction(observer);
    MoviesDAO moviesDAO = new MoviesDAO();
    movieList.addAll(moviesDAO.readMovies());
    lw_film.setItems(movieList);
    }

}
