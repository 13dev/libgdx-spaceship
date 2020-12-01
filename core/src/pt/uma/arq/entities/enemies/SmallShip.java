package pt.uma.arq.entities.enemies;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import pt.uma.arq.entities.Ship;
import pt.uma.arq.game.Animator;

public class SmallShip extends Ship implements EnemyShip {

    public SmallShip(Vector2 position, SpriteBatch batch) {
        super(position, batch);
    }

    @Override
    protected Animator animator() {
        return new Animator(batch, "small-ship.png",2,1);
    }

    @Override
    public float baseAttack() {
        return 0;
    }

    @Override
    public void render() {
        animator.render((int) position.x, (int) position.y);
    }
}
