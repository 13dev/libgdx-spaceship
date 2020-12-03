package pt.uma.arq.managers;
// Created by 13dev - 03/12/2020

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pt.uma.arq.entities.Explosion;

import java.util.ArrayList;

public class ExplosionManager {
    public static ArrayList<Explosion> explosions;

    static {
        explosions = new ArrayList<>();
    }

    public static void render(SpriteBatch batch) {
        for (Explosion explosion : explosions) {
            explosion.render(batch);
        }

        if(!explosions.isEmpty()) {
            explosions.removeIf(explosion -> explosion.removable);
        }
    }

}
