package com.group6.gui;

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
        System.out.println("Hej");
    }
    }
}
