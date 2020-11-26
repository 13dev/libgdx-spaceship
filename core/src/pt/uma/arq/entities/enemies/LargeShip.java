package pt.uma.arq.entities.enemies;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import pt.uma.arq.entities.Ship;
import pt.uma.arq.game.Animator;

public class LargeShip extends Ship implements EnemyShip {
    public LargeShip(Vector2 position, SpriteBatch batch) {
        super(position, batch);
    }

    @Override
    protected Animator animator(SpriteBatch batch) {
        return null;
    }

    @Override
    public float baseAttack() {
        return 0;
    }

    @Override
    public void render() {

    }
}
