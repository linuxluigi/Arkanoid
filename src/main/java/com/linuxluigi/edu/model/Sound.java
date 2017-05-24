package com.linuxluigi.edu.model;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by fubu on 24.05.17.
 */
public class Sound {

    private static final int ballItems = 1;
    private static final int blobItems = 3;
    private static final int finishItems = 3;
    private static final int klingItems = 1;
    private static final int loserItems = 2;
    private static final int wallItems = 1;

    public static void playBall() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(ballItems);
        playSound("ball" + randomInt + ".wav");
    }

    public static void playBlob() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(blobItems);
        playSound("blob" + randomInt + ".wav");
    }

    public static void playFinish() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(finishItems);
        playSound("finish" + randomInt + ".wav");
    }

    public static void playKling() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(klingItems);
        playSound("kling" + randomInt + ".wav");
    }

    public static void playLoser() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(loserItems);
        playSound("loser" + randomInt + ".wav");
    }

    public static void playWall() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(wallItems);
        playSound("wall" + randomInt + ".wav");
    }

    public static synchronized void playSound(final String url) {
        new Thread(new Runnable() {
            // The wrapper thread is unnecessary, unless it blocks on the
            // Clip finishing; see comments.
            public void run() {
                try {
                    Clip clip = AudioSystem.getClip();
                    ClassLoader classloader = Thread.currentThread().getContextClassLoader();
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                            classloader.getResourceAsStream("audio/" + url));
                    clip.open(inputStream);
                    clip.start();
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        }).start();
    }
}
