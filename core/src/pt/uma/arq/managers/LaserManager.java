package pt.uma.arq.managers;
// Created by 13dev - 03/12/2020

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pt.uma.arq.entities.Laser;

import java.util.ArrayList;

public class LaserManager {
    public static ArrayList<Laser> lasers;

    static {
        lasers = new ArrayList<>();
    }

    public static void render(SpriteBatch batch) {
        for (Laser laser : lasers) {
            laser.update();
            laser.render(batch);
        }
        if (!lasers.isEmpty()) {
            lasers.removeIf(Laser::isRemovable);
        }
    }

}
