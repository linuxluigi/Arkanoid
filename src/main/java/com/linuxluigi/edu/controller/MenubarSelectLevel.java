package com.linuxluigi.edu.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

/**
 * Created by fubu on 18.05.17.
 */
public class MenubarSelectLevel implements EventHandler<ActionEvent> {
    public void handle(ActionEvent event) {

        MenuItem menuItem = (MenuItem) event.getSource();

        Controller.getModel().loadLevelFromResources(menuItem.getText());

    }
}
