package com.group6.gui;

import com.group6.movies.Movies;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class MainController {

    @FXML
    private Button btn_read;

    @FXML
    private ListView<Movies> lw_film;

    public Button getBtn_read() {
        return btn_read;
    }

    @FXML private void initialize(){
    ActionObserver observer = new ActionObserver(this);
    btn_read.setOnAction(observer);
    }

}
