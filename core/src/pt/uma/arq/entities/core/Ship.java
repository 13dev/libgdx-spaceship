package pt.uma.arq.entities.core;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import pt.uma.arq.entities.Laser;
import pt.uma.arq.managers.LaserManager;

public abstract class Ship extends GameObject {
    public static final float SHIP_SPEED = 320;
    public static final float SHIP_WIDTH = 99 / 1.2f;
    public static final float SHIP_HEIGHT = 75 / 1.2f;

    protected SpriteBatch batch;
    protected float powerAttack = 0;

    public Ship(Vector2 position, float width, float height) {
        super(position, width, height);
        this.powerAttack = baseAttack() + powerAttack;
    }

    public void setPowerAttack(float powerAttack) {
        this.powerAttack = powerAttack;
    }

    public abstract float baseAttack();

    public float getPowerAttack() {
        return powerAttack;
    }

    public void fire(Laser.LaserOwnerType type) {
        Vector2 laserPosition = new Vector2(position.x + (getWidth() / 2) - 4, position.y );
        Laser laser = new Laser(laserPosition);
        laser.setOwner(type);

        LaserManager.lasers.add(laser);
    }


}
