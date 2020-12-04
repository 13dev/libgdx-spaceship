package pt.uma.arq.entities.core;
// Created by 13dev - 04/12/2020

public class Utils {
    public static float randomRange(float min, float max) {
        return (float) (min + (Math.random() * (max - min)));
    }

    public static int randomRange(int min, int max) {
        return (int) (min + (Math.random() * (max - min)));
    }
}
