package pt.uma.arq.managers;
// Created by 13dev - 03/12/2020

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import pt.uma.arq.entities.Collidable;
import pt.uma.arq.entities.Explosion;
import pt.uma.arq.entities.Laser;
import pt.uma.arq.entities.core.GameObject;
import pt.uma.arq.entities.core.Ship;

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

    public static Laser newLaser(Ship object, Laser.LaserOwnerType type) {
        //offest bullet on y axis
        float positionY = object.getPosition().y;

        switch (type) {
            case ENEMY -> positionY -= object.getHeight() - 5;
            case PLAYER -> positionY += object.getHeight() - 5;
        }

        Vector2 laserPosition = new Vector2(
                object.getPosition().x + (object.getWidth() / 2) - 4,
                positionY
        );

        Laser laser = new Laser(laserPosition);
        laser.setOwnerType(type);

        return laser;


        //offest bullet on y axis
//        float positionY = position.y;
//        switch (type) {
//            case ENEMY -> positionY -= getHeight() - 5;
//            case PLAYER -> positionY += getHeight() - 5;
//        }
//
//        Vector2 laserPosition = new Vector2(position.x + (getWidth() / 2) - 4, positionY);
//        Laser laser = new Laser(laserPosition);
//        laser.setOwnerType(type);
//        laser.setDamage(damage);
//
//        LaserManager.lasers.add(laser);
    }

}
