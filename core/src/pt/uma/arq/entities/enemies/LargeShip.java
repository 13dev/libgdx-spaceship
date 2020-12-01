package pt.uma.arq.entities.enemies;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import pt.uma.arq.entities.Ship;
import pt.uma.arq.game.Animator;
import pt.uma.arq.managers.TextureAtlasManager;

import java.util.Random;

public class LargeShip extends Ship implements EnemyShip {
    float elapsedTime = 0f;
    float random;

    public LargeShip(Vector2 position, SpriteBatch batch) {
        super(position, batch);
        random = (float) (Math.random() * 200) + 50f;
    }

    @Override
    public float baseAttack() {
        return 0;
    }

    @Override
    public void render() {
        elapsedTime = (elapsedTime + Gdx.graphics.getDeltaTime()) % 360f;
        batch.draw(TextureAtlasManager.getRegion("ufoRed.png"),
                position.x, position.y,
                90 / 2f, 90 / 2f,
                90, 90,
                1f, 1f,
                elapsedTime * random
        );
    }
}
