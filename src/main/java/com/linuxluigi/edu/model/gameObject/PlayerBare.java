package com.linuxluigi.edu.model.gameObject;

import javafx.scene.paint.Color;

import static com.linuxluigi.edu.model.StaticVar.*;

/**
 * Created by fubu on 19.05.17.
 */
public class PlayerBare {
    private double PositionX;
    private double PositionY;

    private double width;
    private double height;

    private Color color;

    public PlayerBare(double positionX, double positionY, double lengthX, double lengthY, Color color) {
        PositionX = positionX;
        PositionY = positionY;
        this.width = lengthX;
        this.height = lengthY;
        this.color = color;
    }

    public PlayerBare() {
        PositionX = 100;
        PositionY = 100;
        this.width = 50;
        this.height = 10;
        this.color = Color.GREEN;
    }

    public double getPositionX() {
        return PositionX;
    }

    public double getRelativPositionX() {
        return relativeWidth(this.PositionX);
    }

    public void setPositionX(double positionX) {
        PositionX = positionX;
    }

    public double getPositionY() {
        return PositionY;
    }

    public double getRelativPositionY() {
        return relativeHeight(this.PositionY);
    }

    public void setPositionY(double positionY) {
        PositionY = positionY;
    }

    public double getWidth() {
        return width;
    }

    public double getRelativWidth() {
        return relativeWidth(this.width);
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public double getRelativHeight() {
        return relativeHeight(this.height);
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setCenter(double width, double height) {
        setPositionX(absoluteWidth(width));
        setPositionY(absoluteHeight(height));
    }
}
