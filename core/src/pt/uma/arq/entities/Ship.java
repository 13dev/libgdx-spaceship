package pt.uma.arq.entities;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import pt.uma.arq.game.Animator;

public abstract class Ship {
    public static final float SHIP_SPEED = 320;
    public static final float SHIP_WIDTH = 99 / 1.2f;
    public static final float SHIP_HEIGHT = 75 / 1.2f;


    protected SpriteBatch batch;
    protected Vector2 position;
    protected float powerAttack = 0;
    protected Rectangle boundingBox;
    protected boolean collided;

    public Ship(Vector2 position, SpriteBatch batch) {
        this.position = position;
        this.batch = batch;
        this.setPowerAttack(baseAttack() + powerAttack);
    }

    public void setPowerAttack(float powerAttack) {
        this.powerAttack = powerAttack;
    }

    public abstract float baseAttack();
    public abstract void render();

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public float getPowerAttack() {
        return powerAttack;
    }

    public Rectangle getBoundingBox() {
        return boundingBox;
    }

    public void setBoundingBox(Rectangle boundingBox) {
        this.boundingBox = boundingBox;
    }

    public boolean isCollided() {
        return collided;
    }

    public boolean isCollidedWith(Rectangle rectangle) {
        return this.boundingBox.overlaps(rectangle);
    }

}
