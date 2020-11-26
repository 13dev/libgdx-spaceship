package pt.uma.arq.entities;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import pt.uma.arq.game.Animator;

public abstract class Ship extends Actor {
    protected Animator animator;
    protected Vector2 position;
    protected float powerAttack;
    protected Rectangle boundingBox;
    protected boolean collided;

    public Ship(Vector2 position, SpriteBatch batch) {
        this.position = position;
        this.setAnimator(batch);
    }

    public void setPowerAttack(float powerAttack) {
        this.powerAttack = powerAttack;
    }

    public Animator getAnimator() {
        return animator;
    }

    public abstract void setAnimator(SpriteBatch batch);

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
