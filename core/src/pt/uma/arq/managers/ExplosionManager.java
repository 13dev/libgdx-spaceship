package pt.uma.arq.managers;
// Created by 13dev - 03/12/2020

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import pt.uma.arq.entities.Collidable;
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
    public static void newMiddleExplosion(Collidable collidableObject) {

        // calc middle of the collidable object
        Vector2 explosionPosition = collidableObject.getBoundingBox().getCenter(new Vector2());
        explosionPosition.x -= Explosion.WIDTH / 2;
        explosionPosition.y -= Explosion.HEIGHT / 2;

        // add to arraylist
        explosions.add(new Explosion(explosionPosition));
    }

}
