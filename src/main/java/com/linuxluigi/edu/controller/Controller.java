package com.linuxluigi.edu.controller;

import com.linuxluigi.edu.model.Model;
import com.linuxluigi.edu.model.StaticVar;
import com.linuxluigi.edu.model.board.Stone;
import com.linuxluigi.edu.view.*;
import javafx.animation.AnimationTimer;
import javafx.scene.paint.Color;

import static com.linuxluigi.edu.model.StaticVar.defaultHeight;
import static com.linuxluigi.edu.model.StaticVar.defaultWidth;
import static com.linuxluigi.edu.model.StaticVar.minBallSpeed;

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
        this.view.initGame(model.getPlayerBare(), model.getBoard(), model.getBall());
        updateViewObjects();
        setAnimationTimer();
    }

    public void addEventHandler() {
        AddMenuBarEventHandler.addMenuBarEventHandler(this.view.getMenuBar());
        AddWindowChangedSize.addWindowChangedSize(this.view.getScene());
        AddMouseHandler.addMouseMovemntEvent(this.view.getScene());
        AddClickEvent.addClickEvent(this.view.getScene());

    }

    protected static void updateViewObjects() {
        view.updateAllObjects(
                getModel().getPlayerBare(),
                getModel().getBoard(),
                getModel().getLives(),
                getModel().getPoints(),
                getModel().getBall()
        );
    }

    private void setAnimationTimer() {
        new AnimationTimer() { //animate all circles
            @Override
            public void handle(long now) {
                // Ball movement
                if (!model.isEditmode()) {
                    double newPositionX = model.getBall().getCenterX() + model.getBall().getDirectionX();
                    double newPositionY = model.getBall().getCenterY() + model.getBall().getDirectionY();
                    model.getBall().setCenterX(newPositionX);
                    model.getBall().setCenterY(newPositionY);
                }

                // if Ball hit player
                if (model.getPlayerBare().isHitByBall(model.getBall())) {
                    // normal punch Y
                    if (model.getPlayerBare().getSpeedY() >= minBallSpeed * -1) {
                        model.getBall().setDirectionY(minBallSpeed * -1);
                    } else {
                        model.getBall().setDirectionY(model.getPlayerBare().getSpeedY());
                    }

                    // normal punch X
                    model.getBall().setDirectionX(
                            model.getPlayerBare().getSpeedX()
                    );

                    // starting punch
                    if (model.getBall().getDirectionY() == 0) {
                        if (model.getPlayerBare().getSpeedY() >= minBallSpeed * -1) {
                            model.getBall().setDirectionY(minBallSpeed * -1);
                        } else {
                            model.getBall().setDirectionY(model.getPlayerBare().getSpeedY());
                        }

                        model.getBall().setDirectionX(model.getPlayerBare().getSpeedX());
                    }
                }

                // if hit the boarder
                if (model.getBall().getCenterX() + model.getBall().getRadius() >= defaultWidth
                        || model.getBall().getCenterX() - model.getBall().getRadius() <= 0
                        || model.getBall().getCenterY() - model.getBall().getRadius() <= 0) {
                    model.getBall().setOppsiteDirection();
                }

                // if lost a live
                if (model.getBall().getCenterY() >= defaultHeight) {
                    model.setLives(model.getLives() - 1);

                    if (model.getLives() == 0) {
                        model.getBall().disableBall();
                        view.toogleGameOver(true);
                    } else {
                        model.newBall();
                    }
                }

                // if Ball hit Block
                boolean isHit = false;
                for (Stone stone : model.getBoard().getStones()) {
                    if (stone.isHitByBall(model.getBall())) {
                        isHit = true;
                        stone.setVisible(false);
                        double speedMutiplicator = Math.abs(model.getBall().getDirectionX())
                                + Math.abs(model.getBall().getDirectionY());
                        double score = stone.getPointValue() * speedMutiplicator;
                        model.setPoints(model.getPoints() + (int) score);
                    }
                }
                if (isHit) {
                    model.getBall().setOppsiteDirection();
                }

                updateViewObjects();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                }
            }
        }.start();
    }

    protected static Model getModel() {
        return model;
    }

    protected static MainFrame getView() {
        return view;
    }
}


