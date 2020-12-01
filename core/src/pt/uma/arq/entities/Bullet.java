package pt.uma.arq.entities;
// Created by 13dev - 01/12/2020

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import pt.uma.arq.managers.TextureAtlasManager;

public class Bullet {
    public static final int SPEED = 80;
    public static final float DEFAULT_Y = 50;
    public static final float WIDTH = 8 / 1.3f;
    public static final float HEIGHT = 43 / 1.3f;

    private final Animation<TextureRegion> animation;
    private final Vector2 position;
    private float elapsedTime;
    private boolean removable;


    Bullet(Vector2 position) {
        this.position = position;
        animation = new Animation<TextureRegion>(.1f, TextureAtlasManager.getRegions("laserRed"), Animation.PlayMode.NORMAL);
        removable = false;
    }

    public void render(SpriteBatch batch) {
        elapsedTime += Gdx.graphics.getDeltaTime();
        batch.draw(animation.getKeyFrame(elapsedTime, false), position.x, position.y, WIDTH, HEIGHT);
    }

    public void update() {
        position.y += SPEED * elapsedTime;
        if (position.y > Gdx.graphics.getHeight() + HEIGHT) {
            removable = true;
        }
    }

    public boolean isRemovable() {
        return removable;
    }
}
