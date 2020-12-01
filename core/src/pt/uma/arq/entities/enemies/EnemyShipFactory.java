package pt.uma.arq.entities.enemies;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class EnemyShipFactory {
    public static EnemyShip create(EnemyShip.EnemyShipType type, Vector2 position) {
        return switch (type) {
            case LARGE -> new LargeShip(position);
            case SMALL -> new SmallShip(position);
            case MEDIUM -> new MediumShip(position);
        };
    }
}
