package pt.uma.arq.entities.enemies;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import pt.uma.arq.entities.Ship;
import pt.uma.arq.game.Animator;
import pt.uma.arq.managers.TextureAtlasManager;

public class SmallShip extends Ship implements EnemyShip {

    public SmallShip(Vector2 position, SpriteBatch batch) {
        super(position, batch);
    }


    @Override
    public float baseAttack() {
        return 0;
    }

    @Override
    public void render() {
        batch.draw(
                TextureAtlasManager.getRegion("playerShip1_green.png"),
                position.x, position.y,
                SHIP_WIDTH / 2, SHIP_HEIGHT / 2,
                SHIP_WIDTH, SHIP_HEIGHT,
                1f, 1f,
                -180f
        );
    }
}
