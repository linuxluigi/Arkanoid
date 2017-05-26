package com.linuxluigi.edu.controller;

import com.linuxluigi.edu.model.StaticVar;
import com.linuxluigi.edu.model.board.Stone;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import static com.linuxluigi.edu.model.StaticVar.absoluteHeight;
import static com.linuxluigi.edu.model.StaticVar.absoluteWidth;


/**
 * Created by fubu on 23.05.17.
 */
public class MouseClick implements EventHandler<MouseEvent> {

    @Override
    public void handle(MouseEvent event) {
        if (Controller.getModel().isEditmode()) {
            for (Stone stone : Controller.getModel().getBoard().getStones()) {

                double realY;

                if (Controller.getView().isToolbarActivat()) {
                    realY = event.getY() - 30; // Toolbarsize
                } else {
                    realY = event.getY();
                }

                if (stone.isHit(
                        absoluteWidth(event.getSceneX()),
                        absoluteHeight(realY)
                )) {
                    Stone newStone = Controller.getView().getEditStone();

                    stone.setColor(newStone.getColor());
                    if (stone.isDestroyable()) {
                        stone.setPointValue(newStone.getPointValue());
                    } else {
                        stone.setPointValue(0);
                    }
                    stone.setVisible(newStone.isVisible());
                    stone.setDestroyable(newStone.isDestroyable());

                    Controller.updateViewObjects();
                }
            }
        }
    }
}