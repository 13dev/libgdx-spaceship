package pt.uma.arq.entities.enemies;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import pt.uma.arq.entities.Ship;
import pt.uma.arq.game.Animator;
import pt.uma.arq.managers.TextureAtlasManager;

public class LargeShip extends Ship implements EnemyShip {
    public LargeShip(Vector2 position, SpriteBatch batch) {
        super(position, batch);
    }

    @Override
    public float baseAttack() {
        return 0;
    }

    @Override
    public void render() {
        batch.draw(TextureAtlasManager.getRegion("ufoRed.png"), position.x, position.y, 90, 90);
    }
}
