package com.group6.gui;

import com.group6.movies.MoviesDAO;
import com.group6.ratings.Ratings;
import com.group6.ratings.RatingsDAO;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ActionObserver implements EventHandler <ActionEvent> {
    private MainController controller;

    public ActionObserver(MainController controller) {
        this.controller = controller;
    }

    @Override
    public void handle(ActionEvent e) {
    if(e.getSource() == controller.getBtn_read()){
    int userId = controller.getCb_user().getSelectionModel().getSelectedItem().getUserId();
    int movieId = controller.getLw_film().getSelectionModel().getSelectedItem().getMovieId();

        Ratings ratings = new Ratings();
        ratings.setRating(Integer.valueOf(controller.getTf().getText()));
        ratings.setMovieId(movieId);
        ratings.setUserId(userId);
        RatingsDAO ratingsDao = new RatingsDAO();
        ratingsDao.createRatin(ratings);
        MoviesDAO moviesDAO = new MoviesDAO();
        controller.getMovieList().setAll(moviesDAO.readMovies());


    }
    }
}
