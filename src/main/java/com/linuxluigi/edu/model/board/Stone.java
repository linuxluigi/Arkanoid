package com.linuxluigi.edu.model.board;

import javafx.scene.paint.Color;

/**
 * Created by fubu on 17.05.17.
 */
public class Stone {
    private Color color;
    private int pointValue;
    private boolean visible;

    public Stone(Color color, int pointValue, boolean visible) {
        this.color = color;
        this.pointValue = pointValue;
        this.visible = visible;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getPointValue() {
        return pointValue;
    }

    public void setPointValue(int pointValue) {
        this.pointValue = pointValue;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
