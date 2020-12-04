package pt.uma.arq.entities.enemies;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import pt.uma.arq.entities.core.Ship;
import pt.uma.arq.managers.TextureAtlasManager;

public class SmallShip extends Ship implements EnemyShip {

    public final static float WIDTH = SHIP_WIDTH / 1.3f;
    public final static float HEIGHT = SHIP_HEIGHT / 1.3f;
//    private ShapeRenderer shapeRenderer;
    public SmallShip(Vector2 position) {
        super(position, WIDTH, HEIGHT);
//        shapeRenderer = new ShapeRenderer();
    }

    @Override
    public float baseAttack() {
        return 0;
    }

    @Override
    public void render(SpriteBatch batch) {
//        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
//        shapeRenderer.setColor(Color.RED);
//        shapeRenderer.rect(getBoundingBox().x, getBoundingBox().y, getBoundingBox().width, getBoundingBox().height);
//        shapeRenderer.end();

        batch.draw(
                TextureAtlasManager.getRegion("playerShip1_green.png"),
                position.x, position.y,
                WIDTH / 2f, HEIGHT / 2f,
                WIDTH, HEIGHT,
                1f, 1f,
                -180f
        );
    }
}
