package com.linuxluigi.edu.model.gameObject;

import static com.linuxluigi.edu.model.StaticVar.relativeHeight;
import static com.linuxluigi.edu.model.StaticVar.relativeWidth;

/**
 * Created by fubu on 23.05.17.
 */
public class Ball {

    // speed
    private double directionX = 0;
    private double directionY = 0;

    // position
    private double positionX;
    private double positionY;

    private double radius;

    public Ball(double centerX, double centerY, double radius) {
        this.radius = radius;
        setCenterX(centerX);
        setCenterY(centerY);
    }

    public void setCenterX(double centerX) {
        this.positionX = centerX - this.radius;
    }

    public void setCenterY(double centerY) {
        this.positionY = centerY - this.radius;
    }

    public double getRelativeCenterX() {
        return relativeWidth(this.positionX) + relativeWidth(this.radius);
    }

    public double getRelativeCenterY() {
        return relativeHeight(this.positionY) + relativeHeight(this.radius);
    }

    public double getDirectionX() {
        return directionX;
    }

    public void setDirectionX(double directionX) {
        this.directionX = directionX;
    }

    public double getDirectionY() {
        return directionY;
    }

    public void setDirectionY(double directionY) {
        this.directionY = directionY;
    }

    public double getPositionX() {
        return positionX;
    }

    public void setPositionX(double positionX) {
        this.positionX = positionX;
    }

    public double getRelativPositionX() {
        return relativeHeight(this.positionX);
    }

    public double getPositionY() {
        return positionY;
    }

    public void setPositionY(double positionY) {
        this.positionY = positionY;
    }

    public double getRelativPositionY() {
        return relativeHeight(this.positionY);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRelativRadius() {
        double radius = relativeHeight(this.radius) + relativeWidth(this.radius);
        radius = radius / 2;

        return radius;
    }
}
