package com.linuxluigi.edu.model.board;

import com.linuxluigi.edu.model.StaticVar;
import com.linuxluigi.edu.model.gameObject.Ball;
import javafx.scene.paint.Color;

import static com.linuxluigi.edu.model.StaticVar.relativeHeight;
import static com.linuxluigi.edu.model.StaticVar.relativeWidth;

/**
 * Created by fubu on 17.05.17.
 */
public class Stone {
    private String color;
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

    public Stone(String color, int pointValue, boolean visible,
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

    public Stone(String color, int pointValue, boolean visible, boolean destroyable) {
        this.color = color;
        this.pointValue = pointValue;
        this.visible = visible;
        this.destroyable = destroyable;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
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

    public boolean isHitByBall(Ball ball) {
        if (this.positionX <= ball.getCenterX() + ball.getRadius()
                & ball.getCenterX() - ball.getRadius() <= this.positionX + this.width
                & this.positionY <= ball.getCenterY() + ball.getRadius()
                & ball.getCenterY() - ball.getRadius() <= this.positionY + this.height
                & this.visible) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isHitByBallY(Ball ball) {
        if (this.positionX  + ball.getSpeedX() <= ball.getCenterX() + ball.getRadius()
                & ball.getCenterX() - ball.getRadius() <= this.positionX + this.width - ball.getSpeedX()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isHitByBallX(Ball ball) {
        if (this.positionY + ball.getSpeedY() <= ball.getCenterY() + ball.getRadius()
                & ball.getCenterY() - ball.getRadius() <= this.positionY + this.height - ball.getSpeedY()) {
            return true;
        } else {
            return false;
        }
    }
}
