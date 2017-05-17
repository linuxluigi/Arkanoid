package com.linuxluigi.edu.view;/**
 * Created by fubu on 17.05.17.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainFrame extends Application {

    private Scene scene;
    private MenuBar menuBar;
    private Stage primaryStage;
    private BorderPane borderPane;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        this.primaryStage = primaryStage;

        primaryStage.setTitle("ArkanoidFx");
        this.borderPane = new BorderPane();
        this.scene = new Scene(this.borderPane, 800, 600);

        // set boarder center

        // set boarder top
        setMenuBar(primaryStage);
        this.borderPane.setTop(this.menuBar);

        primaryStage.setScene(this.scene);
        primaryStage.show();

    }

    private void setMenuBar(Stage primaryStage) {
        // tutorial http://www.java2s.com/Tutorials/Java/JavaFX/0560__JavaFX_Menu.htm
        this.menuBar = new MenuBar();
        this.menuBar.prefWidthProperty().bind(primaryStage.widthProperty());

        // File menu - new, save, exit
        Menu fileMenu = new Menu("Level", new ImageView("/fontAwesome/16/font-awesome_4-7-0_globe_16_0_f39c12_none.png"));

        MenuItem newMenuItem = new MenuItem("New", new ImageView("/fontAwesome/16/font-awesome_4-7-0_file_16_0_f39c12_none.png"));
        newMenuItem.setAccelerator(KeyCombination.keyCombination("shortcut+n"));

        MenuItem openMenuItem = new MenuItem("Open", new ImageView("/fontAwesome/16/font-awesome_4-7-0_folder-open_16_0_f39c12_none.png"));
        openMenuItem.setAccelerator(KeyCombination.keyCombination("shortcut+o"));

        MenuItem saveMenuItem = new MenuItem("Save", new ImageView("/fontAwesome/16/font-awesome_4-7-0_floppy-o_16_0_f39c12_none.png"));
        saveMenuItem.setAccelerator(KeyCombination.keyCombination("shortcut+s"));

        MenuItem saveAsMenuItem = new MenuItem("Save as", new ImageView("/fontAwesome/16/font-awesome_4-7-0_floppy-o_16_0_f39c12_none.png"));
        saveAsMenuItem.setAccelerator(KeyCombination.keyCombination("shortcut+shift+s"));

        MenuItem exitMenuItem = new MenuItem("Exit", new ImageView("/fontAwesome/16/font-awesome_4-7-0_times_16_0_f39c12_none.png"));

        fileMenu.getItems().addAll(newMenuItem, openMenuItem, saveMenuItem, saveAsMenuItem,
                new SeparatorMenuItem(), exitMenuItem);

        // Edit Menu
        Menu editMenu = new Menu("Edit", new ImageView("/fontAwesome/16/font-awesome_4-7-0_edit_16_0_f39c12_none.png"));

        MenuItem levelEditMenuItem = new MenuItem("Level Edit", new ImageView("/fontAwesome/16/font-awesome_4-7-0_pencil_16_0_f39c12_none.png"));
        levelEditMenuItem.setAccelerator(KeyCombination.keyCombination("shortcut+e"));

        editMenu.getItems().addAll(levelEditMenuItem);

        // View Menu
        Menu viewMenu = new Menu("View", new ImageView("/fontAwesome/16/font-awesome_4-7-0_window-maximize_16_0_f39c12_none.png"));

        MenuItem fullscreenMenuIten = new MenuItem("Fullscreen", new ImageView("/fontAwesome/16/font-awesome_4-7-0_arrows-alt_16_0_f39c12_none.png"));
        fullscreenMenuIten.setAccelerator(KeyCombination.keyCombination("shortcut+f"));

        MenuItem toolbarMenuIten = new MenuItem("Disable Toolbar", new ImageView("/fontAwesome/16/font-awesome_4-7-0_bars_16_0_f39c12_none.png"));
        toolbarMenuIten.setAccelerator(KeyCombination.keyCombination("shortcut+t"));

        viewMenu.getItems().addAll(fullscreenMenuIten, toolbarMenuIten);

        this.menuBar.getMenus().addAll(fileMenu, editMenu, viewMenu);
    }

    /**
     * Make the Toolbar in / visible
     */
    public void flipToolbarVisibility() {
        if (this.borderPane.getTop() != null) {
            this.borderPane.setTop(null);
        } else {
            this.borderPane.setTop(this.menuBar);
        }
    }

    public void show() {
        launch();
    }
}
