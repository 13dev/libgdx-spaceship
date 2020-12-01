package pt.uma.arq.entities;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import pt.uma.arq.game.Animator;

public class PlayerShip extends Ship {
    public static final float PLAYER_BASE_ATTACK = 10;

    public PlayerShip(Vector2 position, SpriteBatch batch) {
        super(position, batch);
    }

    @Override
    protected Animator animator() {
        return new Animator(batch, "player.png", 1, 1);
    }

    @Override
    public float baseAttack() {
        return PLAYER_BASE_ATTACK;
    }

    @Override
    public void render() {

    }
}
