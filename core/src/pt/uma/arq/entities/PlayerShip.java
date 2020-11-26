package pt.uma.arq.entities;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import pt.uma.arq.game.Animator;

public class PlayerShip extends Ship {

    public static final float PLAYER_BASE_ATTACK = 10;

    public PlayerShip(Vector2 position, SpriteBatch batch) {
        super(position, batch);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }

    @Override
    public void setAnimator(SpriteBatch batch) {
        this.animator = new Animator(batch, "player.png", 100, 200);
    }
}
