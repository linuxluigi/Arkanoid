package com.linuxluigi.edu.controller;

import com.linuxluigi.edu.view.MainFrame;

/**
 * Created by fubu on 17.05.17.
 */
public class Controller {

    // Model
    //private Editor editor;

    // View
    private MainFrame view;

    public Controller(MainFrame view) {
        this.view = view;
    }

    public void show() {
        this.view.show();
    }
}
