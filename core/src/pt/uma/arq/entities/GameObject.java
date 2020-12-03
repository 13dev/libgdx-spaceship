package pt.uma.arq.entities;
// Created by 13dev - 01/12/2020

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class GameObject {
    private float width;
    private float height;
    protected Vector2 position;
    protected Vector2 velocity;
    protected Rectangle boundingBox;
    protected boolean collided;

    public abstract void render(SpriteBatch batch);

    public GameObject(Vector2 position, float width, float height) {
        this.width = width;
        this.height = height;
        this.position = position;
        this.boundingBox = new Rectangle(position.x, position.y, width, height);
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
        setBoundingBoxX(position.x);
        setBoundingBoxY(position.y);
    }

    public Vector2 getPosition() {
        return this.position;
    }

    public Rectangle getBoundingBox() {
        return boundingBox;
    }

    public void setBoundingBoxX(float x) {
        this.boundingBox.x = x;
    }

    public void setBoundingBoxY(float y) {
        this.boundingBox.y = y;
    }

    public boolean isCollided() {
        return collided;
    }

    public boolean isCollidedWith(Rectangle rectangle) {
        return this.boundingBox.overlaps(rectangle);
    }
}
