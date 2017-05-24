package com.linuxluigi.edu.model.gameObject;

import javafx.scene.paint.Color;

import java.sql.Time;

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

    private long time;
    private double speedX = 0;
    private double speedY = 0;

    public PlayerBare(double positionX, double positionY, double lengthX, double lengthY, Color color) {
        PositionX = positionX;
        PositionY = positionY;
        this.width = lengthX;
        this.height = lengthY;
        this.color = color;

        this.time = System.currentTimeMillis();
    }

    public PlayerBare() {
        PositionX = 100;
        PositionY = 864;
        this.width = 250;
        this.height = 50;
        this.color = Color.GREEN;
    }

    public double getPositionX() {
        return PositionX;
    }

    public double getRelativPositionX() {
        return relativeWidth(this.PositionX);
    }

    public void setPositionX(double positionX) {
        // set speed
        if (this.time - System.currentTimeMillis() <= 500) {
            this.speedX = positionX - this.PositionX;
        } else {
            this.speedX = 0;
        }

        PositionX = positionX;
    }

    public double getPositionY() {
        return PositionY;
    }

    public double getRelativPositionY() {
        return relativeHeight(this.PositionY);
    }

    public void setPositionY(double positionY) {
        // set speed
        if (this.time - System.currentTimeMillis() <= 500) {
            this.speedY = positionY - this.PositionY;
        } else {
            this.speedY = 0;
        }

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

    public double getSpeedX() {
        return speedX;
    }

    public double getSpeedY() {
        return speedY;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setCenter(double width, double height) {
        // width
        setPositionX(absoluteWidth(width) - this.width / 2);

        // height
        double absoluteHeight = absoluteHeight(height);

        if (absoluteHeight > playerAreaHeight) {
            setPositionY(absoluteHeight - this.height / 2);
        } else {
            setPositionY(playerAreaHeight - this.height / 2);
        }

    }

    public boolean isHitByBall(Ball ball) {
        if (this.PositionX <= ball.getCenterX() + ball.getRadius()
                & ball.getCenterX() - ball.getRadius() <= this.PositionX + this.width
                & this.PositionY <= ball.getCenterY() + ball.getRadius()
                & ball.getCenterY() - ball.getRadius() <= this.PositionY + this.height
                & ball.getDirectionY() >= 0) {
            return true;
        } else {
            return false;
        }
    }
}
