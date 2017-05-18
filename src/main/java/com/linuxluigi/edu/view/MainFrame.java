package com.linuxluigi.edu.view;/**
 * Created by fubu on 17.05.17.
 */

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainFrame {

    private Scene scene;
    private MenuBar menuBar;
    private BorderPane borderPane;
    private Stage primaryStage;
    private HBox editBox;

    public MainFrame() {
        this.borderPane = new BorderPane();
        this.scene = new Scene(this.borderPane, 800, 600);

        // set boarder center

        // set boarder top
        setMenuBar();
        this.borderPane.setTop(this.menuBar);

        // set border bottom
        setEditBox();
        this.borderPane.setBottom(this.editBox);
    }

    private void setMenuBar() {
        // tutorial http://www.java2s.com/Tutorials/Java/JavaFX/0560__JavaFX_Menu.htm
        this.menuBar = new MenuBar();

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

    private void setEditBox() {
        this.editBox = new HBox();

        final ColorPicker colorPicker = new ColorPicker();
        colorPicker.setValue(Color.RED);

        final Text text = new Text("Color picker:");
        text.setFill(colorPicker.getValue());



        colorPicker.setOnAction((ActionEvent t) -> {
            text.setFill(colorPicker.getValue());
        });



        this.editBox.getChildren().addAll(colorPicker, text);
    }

    /**
     * Make the Toolbar in / visible
     */
    public void toogleToolbarVisibility() {
        if (this.borderPane.getTop() != null) {
            this.borderPane.setTop(null);
        } else {
            this.borderPane.setTop(this.menuBar);
        }
    }

    public MenuBar getMenuBar() {
        return menuBar;
    }

    public void show(Stage stage) {
        this.primaryStage = stage;
        stage.setTitle("Arkanoid XD");
        stage.setScene(scene);
        stage.show();
    }

    public void fullscreenToggle() {
        this.primaryStage.setFullScreen(!this.primaryStage.isFullScreen());
    }

    public void toggleEditBox() {
        if (this.borderPane.getBottom() != null) {
            this.borderPane.setBottom(null);
        } else {
            this.borderPane.setBottom(this.editBox);
        }
    }
}
