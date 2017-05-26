package com.linuxluigi.edu.model.gameObject;

import com.linuxluigi.edu.model.StaticVar;

import static com.linuxluigi.edu.model.StaticVar.maxBallSpeed;
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

    public double getCenterX() {
        return this.positionX + this.radius;
    }

    public void setCenterY(double centerY) {
        this.positionY = centerY - this.radius;
    }

    public double getCenterY() {
        return this.positionY + this.radius;
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
        this.directionX = getMaxSpeed(directionX);
    }

    public double getDirectionY() {
        return directionY;
    }

    public void setDirectionY(double directionY) {
        double currentSpeed = getMaxSpeed(directionY);
        this.directionY = getMinSpeed(currentSpeed);
    }

    public double getSpeedX() {
        return Math.abs(this.directionX);
    }

    public double getSpeedY() {
        return Math.abs(this.directionY);
    }

    /**
     * If the speed is higher than allowd it will be slow down
     * @param speed
     * @return
     */
    private double getMaxSpeed(double speed) {
        double currentSpeed = Math.abs(speed);

        if (currentSpeed > StaticVar.maxBallSpeed) {
            currentSpeed = StaticVar.maxBallSpeed;
        }

        if (speed < 0) {
            currentSpeed = currentSpeed * -1;
        }

        return currentSpeed;
    }

    /**
     * If the speed is slower than allowed it will be speeden up
     * @param speed
     * @return
     */
    private double getMinSpeed(double speed) {
        double currentSpeed = Math.abs(speed);

        if (currentSpeed < StaticVar.minBallSpeed) {
            currentSpeed = StaticVar.minBallSpeed;
        }

        if (speed < 0) {
            currentSpeed = currentSpeed * -1;
        }

        return currentSpeed;
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

    public void setOppsiteDirectionX() {
        this.directionX = this.directionX * -1;
    }

    public void setOppsiteDirectionY() {
        this.directionY = this.directionY * -1;
    }

    public void disableBall() {
        this.directionX = 0;
        this.directionY = 0;
        this.positionX = this.radius * - 20;
        this.positionY = this.radius * - 20;
    }
}
