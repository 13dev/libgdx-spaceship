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
    private static final int SHIP_LENGHT = 90;
    float elapsedTime = 0f;
    float random;

    public LargeShip(Vector2 position) {
        super(position, SHIP_LENGHT, SHIP_LENGHT);
        random = (float) (Math.random() * 200) + 50f;
    }

    @Override
    public float baseAttack() {
        return 0;
    }

    @Override
    public void render(SpriteBatch batch) {
        elapsedTime = (elapsedTime + Gdx.graphics.getDeltaTime()) % 360f;
        batch.draw(TextureAtlasManager.getRegion("ufoRed.png"),
                position.x, position.y,
                SHIP_LENGHT / 2f, SHIP_LENGHT / 2f,
                SHIP_LENGHT, SHIP_LENGHT,
                1f, 1f,
                elapsedTime * random
        );
    }
}
