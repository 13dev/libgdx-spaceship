package pt.uma.arq.entities;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import pt.uma.arq.game.Animator;

public abstract class Ship {
    protected Animator animator;
    protected SpriteBatch batch;
    protected Vector2 position;
    protected float powerAttack = 0;
    protected Rectangle boundingBox;
    protected boolean collided;

    public Ship(Vector2 position, SpriteBatch batch) {
        this.position = position;
        this.batch = batch;
        this.animator = animator();
        this.setPowerAttack(baseAttack() + powerAttack);
        this.animator.create();
    }

    public void setPowerAttack(float powerAttack) {
        this.powerAttack = powerAttack;
    }

    public Animator getAnimator() {
        return animator;
    }

    protected abstract Animator animator();
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
