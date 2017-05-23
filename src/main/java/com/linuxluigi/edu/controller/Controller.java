package com.linuxluigi.edu.controller;

import com.linuxluigi.edu.model.Model;
import com.linuxluigi.edu.view.*;

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
        this.view.initGame(model.getPlayerBare(), model.getBoard());
    }

    public void addEventHandler() {
        AddMenuBarEventHandler.addMenuBarEventHandler(this.view.getMenuBar());
        AddWindowChangedSize.addWindowChangedSize(this.view.getScene());
        AddMouseHandler.addMouseMovemntEvent(this.view.getScene());
        AddClickEvent.addClickEvent(this.view.getScene());

    }

    protected static void updateViewObjects() {
        view.updateAllObjects(getModel().getPlayerBare(), getModel().getBoard());
        //todo add stones && ball && points && live
    }

    protected static Model getModel() {
        return model;
    }

    protected static MainFrame getView() {
        return view;
    }
}


