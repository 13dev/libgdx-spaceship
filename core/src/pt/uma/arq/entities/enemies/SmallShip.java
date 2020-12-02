package pt.uma.arq.entities.enemies;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import pt.uma.arq.entities.Ship;
import pt.uma.arq.managers.TextureAtlasManager;

public class SmallShip extends Ship implements EnemyShip {

    private final static float WIDTH = SHIP_WIDTH / 1.3f;
    private final static float HEIGHT = SHIP_HEIGHT / 1.3f;
    public SmallShip(Vector2 position) {
        super(position, WIDTH, HEIGHT);
    }

    @Override
    public float baseAttack() {
        return 0;
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(
                TextureAtlasManager.getRegion("playerShip1_green.png"),
                position.x, position.y,
                WIDTH / 2, WIDTH / 2,
                WIDTH, HEIGHT,
                1f, 1f,
                -180f
        );
    }
}
