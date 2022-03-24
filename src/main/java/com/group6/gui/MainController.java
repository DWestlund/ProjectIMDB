package com.group6.gui;

import com.group6.movies.Movies;
import com.group6.movies.MoviesDAO;
import com.group6.users.Users;
import com.group6.users.UsersDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class MainController {

    @FXML
    private Button btn_read;

    @FXML
    private ListView<Movies> lw_film;
    private ObservableList<Movies> movieList = FXCollections.observableArrayList();

    private ObservableList<Users> userList = FXCollections.observableArrayList();

    @FXML
    private ComboBox<Users> cb_user;
    @FXML
    private TextField tf;

    public TextField getTf() {
        return tf;
    }

    public ListView<Movies> getLw_film() {
        return lw_film;
    }

    public ObservableList<Movies> getMovieList() {
        return movieList;
    }

    public ObservableList<Users> getUserList() {
        return userList;
    }

    public ComboBox<Users> getCb_user() {
        return cb_user;
    }

    public Button getBtn_read() {
        return btn_read;
    }

    @FXML private void initialize(){
        ActionObserver observer = new ActionObserver(this);
        btn_read.setOnAction(observer);
        MoviesDAO moviesDAO = new MoviesDAO();
        movieList.addAll(moviesDAO.readMovies());
        lw_film.setItems(movieList);

        UsersDAO usersDAO = new UsersDAO();
        userList.addAll(usersDAO.readUsers());
        cb_user.setItems(userList);

    }

}
