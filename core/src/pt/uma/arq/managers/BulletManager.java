package pt.uma.arq.managers;
// Created by 13dev - 03/12/2020

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pt.uma.arq.entities.Bullet;

import java.util.ArrayList;

public class BulletManager {
    public static ArrayList<Bullet> bullets;

    static {
        bullets = new ArrayList<>();
    }

    public static void render(SpriteBatch batch) {
        for (Bullet bullet : bullets) {
            bullet.update();
            bullet.render(batch);
        }
        if (!bullets.isEmpty()) {
            bullets.removeIf(Bullet::isRemovable);
        }
    }

}
