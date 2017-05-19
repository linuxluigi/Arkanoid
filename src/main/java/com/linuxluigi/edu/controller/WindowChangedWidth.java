package com.linuxluigi.edu.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;


/**
 * Created by fubu on 19.05.17.
 */
public class WindowChangedWidth implements ChangeListener {
    @Override
    public void changed(ObservableValue observable, Object oldValue, Object newValue) {
        Controller.getModel().setWindowWidth((double) newValue);
        Controller.updateViewObjects();
    }
}