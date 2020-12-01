package pt.uma.arq.entities.enemies;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import pt.uma.arq.entities.PlayerShip;
import pt.uma.arq.entities.Ship;
import pt.uma.arq.entities.enemies.EnemyShip.EnemyShipType;

import java.util.ArrayList;

public class Fleet {
    public static final int SHIPS_PER_LINE = 4;
    public static final int SHIPS_PER_COLUMN = 3;
    public static final int MARGIN_BETWEEN = 50;
    private final Vector2 position;
    private final SpriteBatch batch;
    public ArrayList<Ship> ships;

    public Fleet(Vector2 position, SpriteBatch batch) {
        this.position = position;
        this.batch = batch;
        ships = new ArrayList<>();
    }

    public ArrayList<Ship> getShips() {
        return ships;
    }

    public void create() {
        for (int i = 0; i < SHIPS_PER_COLUMN; i++) {
            for (int j = 0; j < SHIPS_PER_LINE; j++) {

                Vector2 pos = new Vector2(
                        position.x + (MARGIN_BETWEEN + Ship.SHIP_WIDTH) * j,
                        position.y + (MARGIN_BETWEEN / 2.f  + Ship.SHIP_HEIGHT) * i
                );

                EnemyShipType type = EnemyShipType.values()[i % 3];

                ships.add((Ship) EnemyShipFactory.create(type, pos, batch));
            }
        }

    }
}
