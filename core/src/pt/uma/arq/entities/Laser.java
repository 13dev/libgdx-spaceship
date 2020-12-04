package pt.uma.arq.entities;
// Created by 13dev - 01/12/2020

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import pt.uma.arq.entities.core.GameObject;
import pt.uma.arq.entities.core.Ship;
import pt.uma.arq.entities.enemies.EnemyShip;
import pt.uma.arq.managers.TextureAtlasManager;

public class Laser extends GameObject {

    public enum LaserOwnerType {
        PLAYER,
        ENEMY,
    }

    public static final int SPEED = 20;
    public static final float DEFAULT_Y = 50;
    public static final float WIDTH = 10f;
    public static final float HEIGHT = 50f;

    private final Animation<TextureRegion> animation;
    private float elapsedTime;
    private boolean removable;
    private LaserOwnerType ownerType;
    private float damage;

    public Laser(Vector2 position) {
        super(position, WIDTH, HEIGHT);
        animation = new Animation<TextureRegion>(.1f, TextureAtlasManager.getRegions("laserRed"), Animation.PlayMode.NORMAL);
        removable = false;
        ownerType = LaserOwnerType.PLAYER;
    }

    public void render(SpriteBatch batch) {
        elapsedTime += Gdx.graphics.getDeltaTime();
        if (!isRemovable()) {
            batch.draw(animation.getKeyFrame(elapsedTime, false), position.x, position.y, WIDTH, HEIGHT);
        }

    }

    public void update() {

        switch (ownerType) {
            case ENEMY -> position.y -= SPEED * elapsedTime;
            case PLAYER -> position.y += SPEED * elapsedTime;
        }

        setBoundingBoxY(position.y);
        setBoundingBoxX(position.x);

        if (position.y > Gdx.graphics.getHeight() + HEIGHT) {
            removable = true;
        }

        if (position.y < 0) {
            removable = true;
        }
    }

    public boolean isRemovable() {
        return removable;
    }

    public void setRemovable(boolean removable) {
        this.removable = removable;
    }

    public void setOwnerType(LaserOwnerType ownerType) {
        this.ownerType = ownerType;
    }

    public void setDamage(float damage) {
        this.damage = damage;
    }

    public float getDamage() {
        return this.damage;
    }
}
