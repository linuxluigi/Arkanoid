package com.linuxluigi.edu.controller;

import com.linuxluigi.edu.model.Model;
import com.linuxluigi.edu.view.MainFrame;

import com.linuxluigi.edu.view.AddMenuBarEventHandler;
/**
 * Created by fubu on 17.05.17.
 */
public class Controller {

    // Model
    private static Model model;

    // View
    private static MainFrame view;

    public Controller(Model model, MainFrame view) {
        this.model = model;
        this.view = view;
    }

    public void show() {
        this.view.show(model.getPrimaryStage());
        addEventHandler();
    }

    public void addEventHandler() {
        AddMenuBarEventHandler.addMenuBarEventHandler(this.view.getMenuBar());
    }

    protected static Model getModel() {
        return model;
    }

    protected static MainFrame getView() {
        return view;
    }
}


