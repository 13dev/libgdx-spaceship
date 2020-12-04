package pt.uma.arq.entities.core;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import pt.uma.arq.entities.Collidable;
import pt.uma.arq.entities.Laser;
import pt.uma.arq.entities.Removable;
import pt.uma.arq.managers.LaserManager;

public abstract class Ship extends GameObject implements Collidable, Removable {
    public static final float SHIP_SPEED = 320;
    public static final float SHIP_WIDTH = 99 / 1.2f;
    public static final float SHIP_HEIGHT = 75 / 1.2f;

    protected SpriteBatch batch;
    protected boolean removable;

    public Ship(Vector2 position, float width, float height) {
        super(position, width, height);
        removable = false;
    }

    public void fire(Laser.LaserOwnerType type) {
        LaserManager.lasers.add(
                LaserManager.newLaser(this, type)
        );
    }

    public void fire(Laser.LaserOwnerType type, float damage) {
        Laser laser = LaserManager.newLaser(this, type);
        laser.setDamage(damage);
        LaserManager.lasers.add(laser);
    }

    public void setRemovable(boolean value) {
        removable = value;
    }

    public boolean isRemovable() {
        return removable;
    }
}
