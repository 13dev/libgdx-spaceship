package pt.uma.arq.entities;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import pt.uma.arq.game.Animator;

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


}
