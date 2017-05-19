package com.linuxluigi.edu.model;

/**
 * Created by fubu on 19.05.17.
 */
public class StaticVar {
    public static final double defaultWidth = 1920;
    public static final double defaultHeight = 1080;

    // todo change default value
    private static double windowWidth;
    private static double windowHeigh;

    /**
     * Generate relative postion of width
     * @param ObjectWidth
     * @return
     */
    public static double relativeWidth(double ObjectWidth) {
        double relativeWidthPercent = 100 * windowWidth / defaultWidth;
        double relativWidthPosition = relativeWidthPercent * ObjectWidth / 100;
        return relativWidthPosition;
    }

    /**
     * Generate relative postion of width
     * @param ObjectHeight
     * @return
     */
    public static double relativeHeight(double ObjectHeight) {
        double relativeHeightPercent = 100 * windowHeigh / defaultHeight;
        double relativHeightPosition = relativeHeightPercent * ObjectHeight / 100;
        return relativHeightPosition;
    }

    public static void setWindowWidth(double windowWidth) {
        StaticVar.windowWidth = windowWidth;
    }

    public static void setWindowHeigh(double windowHeigh) {
        StaticVar.windowHeigh = windowHeigh;
    }
}
