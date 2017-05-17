package com.linuxluigi.edu.controller;

import com.linuxluigi.edu.model.Model;
import com.linuxluigi.edu.view.MainFrame;

/**
 * Created by fubu on 17.05.17.
 */
public class Controller {

    // Model
    private Model model;

    // View
    private MainFrame view;

    public Controller(Model model, MainFrame view) {
        this.model = model;
        this.view = view;
    }

    public void show() {
        this.view.show();
    }
}
