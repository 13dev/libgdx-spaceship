package pt.uma.arq.entities;
// Created by 13dev - 03/12/2020

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import pt.uma.arq.entities.core.GameObject;
import pt.uma.arq.managers.TextureAtlasManager;

public class Explosion extends GameObject {
    public final static float WIDTH = 50f;
    public final static float HEIGHT = 50f;
    public boolean removable;

    private final Animation<TextureRegion> animation;
    private float elapsedTime;

    public Explosion(Vector2 position) {
        super(position, WIDTH, HEIGHT);
        animation = new Animation<TextureRegion>(.05f, TextureAtlasManager.getRegions("explosionRed"), Animation.PlayMode.NORMAL);
        removable = false;
    }

    @Override
    public void render(SpriteBatch batch) {
        if (elapsedTime < 0.2) {
            elapsedTime += Gdx.graphics.getDeltaTime();

            batch.draw(animation.getKeyFrame(elapsedTime, true),
                    position.x, position.y,
                    WIDTH / 2f, HEIGHT / 2f,
                    WIDTH, HEIGHT,
                    1f, 1f,
                    (float) (Math.random() * 360)
            );

            return;
        }

        removable = true;
    }
}
