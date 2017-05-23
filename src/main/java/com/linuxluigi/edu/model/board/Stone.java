package com.linuxluigi.edu.model.board;

import com.linuxluigi.edu.model.StaticVar;
import javafx.scene.paint.Color;

import static com.linuxluigi.edu.model.StaticVar.relativeHeight;
import static com.linuxluigi.edu.model.StaticVar.relativeWidth;

/**
 * Created by fubu on 17.05.17.
 */
public class Stone {
    private Color color;
    private int pointValue;
    private boolean visible;
    private boolean destroyable;

    // position
    private double positionX;
    private double positionY;
    private double width;
    private double height;

    // row & colum
    private int row;
    private int colum;

    public Stone(Color color, int pointValue, boolean visible,
                 boolean destroyable, double positionX, double positionY,
                 double width, double height, int row, int colum) {
        this.color = color;
        this.pointValue = pointValue;
        this.visible = visible;
        this.destroyable = destroyable;
        this.positionX = positionX;
        this.positionY = positionY;
        this.width = width;
        this.height = height;
        this.row = row;
        this.colum = colum;
    }

    public Stone(Color color, int pointValue, boolean visible, boolean destroyable) {
        this.color = color;
        this.pointValue = pointValue;
        this.visible = visible;
        this.destroyable = destroyable;
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

    public boolean isDestroyable() {
        return destroyable;
    }

    public void setDestroyable(boolean destroyable) {
        this.destroyable = destroyable;
    }

    public double getPositionX() {
        return positionX;
    }

    public void setPositionX(double positionX) {
        this.positionX = positionX;
    }

    public double getRelativePositionX() {
        return relativeWidth(this.positionX);
    }

    public double getPositionY() {
        return positionY;
    }

    public void setPositionY(double positionY) {
        this.positionY = positionY;
    }

    public double getRelativePositionY() {
        return relativeHeight(this.positionY);
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getRelativeWidth() {
        return relativeWidth(this.width);
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getRelativeHeight() {
        return relativeHeight(this.height);
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColum() {
        return colum;
    }

    public void setColum(int colum) {
        this.colum = colum;
    }

    /**
     * Check if the block was hit
     *
     * @param positionX
     * @param positionY
     * @return
     */
    public boolean isHit(double positionX, double positionY) {
        if (positionX >= this.positionX
                & this.positionX + this.width >= positionX
                & positionY >= this.positionY
                & this.positionY + this.height >= positionY) {
            return true;
        } else {
            return false;
        }

    }
}
