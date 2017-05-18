package com.linuxluigi.edu.view;

import com.linuxluigi.edu.controller.*;
import com.linuxluigi.edu.controller.MenubarEditLevel;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;

/**
 * Created by fubu on 18.05.17.
 */
public class AddMenuBarEventHandler {

    public static void addMenuBarEventHandler(MenuBar menuBar) {

        //get Level Menu
        Menu levelMenu = menuBar.getMenus().get(0);

        // new Level Item
        levelMenu.getItems().get(0).setOnAction(new MenubarLevelNewLevel());

        // open Level Item
        levelMenu.getItems().get(1).setOnAction(new MenubarLevelOpenLevel());

        // save Level Item
        levelMenu.getItems().get(2).setOnAction(new MenubarLevelSaveLevel());

        // save as Level Item
        levelMenu.getItems().get(3).setOnAction(new MenubarLevelSaveAsLevel());

        // exit Level Item
        levelMenu.getItems().get(5).setOnAction(new MenubarLevelExit());



        //get Edit
        Menu editMenu = menuBar.getMenus().get(1);

        // edit edit Item
        editMenu.getItems().get(0).setOnAction(new MenubarEditLevel());



        //get View
        Menu viewMenu = menuBar.getMenus().get(2);

        // view fullscreen Item
        viewMenu.getItems().get(0).setOnAction(new MenubarViewFullscreen());

        // view toolbar Item
        viewMenu.getItems().get(1).setOnAction(new MenubarViewDisableToolbar());
    }

}
