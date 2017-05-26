package com.linuxluigi.edu.controller;

import com.linuxluigi.edu.model.Model;
import com.linuxluigi.edu.model.Sound;
import com.linuxluigi.edu.model.board.Stone;
import com.linuxluigi.edu.view.*;
import javafx.animation.AnimationTimer;

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
                        model.getBall().setDirectionY(model.getPlayerBare().getSpeedY());
                        model.getBall().setDirectionX(model.getPlayerBare().getSpeedX());
                    }
                    Sound.playKling();
                }

                // if hit the boarder left & right (X)
                if (model.getBall().getCenterX() + model.getBall().getRadius() >= defaultWidth
                        || model.getBall().getCenterX() - model.getBall().getRadius() <= 0) {
                    model.getBall().setOppsiteDirectionX();

                    if (Controller.getModel().getLives() != 0 & !Controller.getModel().getBoard().getGameWin()) {
                        Sound.playWall();
                    }
                }

                // if hit the boarder top (Y)
                if (model.getBall().getCenterY() - model.getBall().getRadius() <= 0) {
                    model.getBall().setOppsiteDirectionY();

                    if (Controller.getModel().getLives() != 0 & !Controller.getModel().getBoard().getGameWin()) {
                        Sound.playWall();
                    }
                }

                // if lost a live
                if (model.getBall().getCenterY() >= defaultHeight) {
                    model.setLives(model.getLives() - 1);

                    if (model.getLives() == 0) {
                        model.getBall().disableBall();

                        if (!view.getGameMessage().equals("Game Win!") & !view.getGameMessage().equals("Gameover")) {
                            Sound.playLoser();
                        }

                    } else {
                        model.newBall();
                        Sound.playBall();
                    }
                }

                // if Ball hit Block
                boolean isHitX = false;
                boolean isHitY = false;
                for (Stone stone : model.getBoard().getStones()) {
                    if (stone.isHitByBall(model.getBall())) {

                        isHitX = stone.isHitByBallX(model.getBall());
                        isHitY = stone.isHitByBallY(model.getBall());

                        if (!stone.isDestroyable()) {
                            stone.setVisible(false);
                        }
                        double speedMutiplicator = Math.abs(model.getBall().getDirectionX())
                                + Math.abs(model.getBall().getDirectionY());
                        double score = stone.getPointValue() * speedMutiplicator;
                        model.setPoints(model.getPoints() + (int) score);
                    }
                }

                if (isHitX) {
                    model.getBall().setOppsiteDirectionX();
                    Sound.playBlob();
                }

                if (isHitY) {
                    model.getBall().setOppsiteDirectionY();
                    Sound.playBlob();
                }

                if (model.getBoard().getGameWin()
                        & !model.isEditmode()
                        & !view.getGameMessage().equals("Game Win!")) {
                    view.setGameMessage("Game Win!");
                    model.getBall().disableBall();
                    Sound.playFinish();
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


