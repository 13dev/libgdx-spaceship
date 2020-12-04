package pt.uma.arq.entities.enemies;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import pt.uma.arq.entities.core.Ship;
import pt.uma.arq.managers.TextureAtlasManager;

public class MediumShip extends Ship implements EnemyShip {
    public MediumShip(Vector2 position) {
        super(position, SHIP_WIDTH, SHIP_HEIGHT);
    }

    @Override
    public void render(SpriteBatch batch) {

        batch.draw(
                TextureAtlasManager.getRegion("playerShip1_blue.png"),
                position.x, position.y,
                SHIP_WIDTH / 2, SHIP_HEIGHT / 2,
                SHIP_WIDTH, SHIP_HEIGHT,
                1f, 1f,
                -180f
        );
    }

    @Override
    public int getDamage() {
        return 20;
    }
}
