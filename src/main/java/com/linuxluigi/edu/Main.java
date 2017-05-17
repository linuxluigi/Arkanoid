package com.linuxluigi.edu;

import com.linuxluigi.edu.controller.Controller;
import com.linuxluigi.edu.model.Model;
import com.linuxluigi.edu.view.MainFrame;

/**
 * Created by fubu on 17.05.17.
 */
public class Main  {
    public static void main(String[] args) {
        // Model
        Model model = new Model();

        MainFrame view = new MainFrame();

        // controller
        Controller controller = new Controller(model, view);
        controller.show();
        //controller.addEventHandler();
    }
}
