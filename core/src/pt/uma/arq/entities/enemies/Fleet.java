package pt.uma.arq.entities.enemies;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import pt.uma.arq.entities.*;
import pt.uma.arq.entities.enemies.EnemyShip.EnemyShipType;
import pt.uma.arq.managers.LaserManager;
import pt.uma.arq.managers.ExplosionManager;

import java.util.ArrayList;

public class Fleet {
    public static final int SHIPS_PER_LINE = 5;
    public static final int SHIPS_PER_COLUMN = 3;
    public static final int MARGIN_BETWEEN = 15;
    private final Vector2 position;
    public ArrayList<EnemyShip> ships;

    public Fleet(Vector2 position) {
        this.position = position;
        ships = new ArrayList<>();
    }


    public void create() {

        for (int i = 0; i < SHIPS_PER_COLUMN; i++) {
            for (int j = 0; j < SHIPS_PER_LINE; j++) {
                EnemyShipType type = EnemyShipType.values()[i % 3];

                Ship ship = (Ship) EnemyShipFactory.create(type, position);

                float posx = (float) Gdx.graphics.getWidth() / 4;
                posx /= 2;
                float posxx = (posx - (ship.getWidth() / 2));
                posx = posxx + ship.getWidth() + posxx;

                //posx += MARGIN_BETWEEN * 2;
                //posx += ship.getWidth() / 2;
                //posx += ship.getWidth();

                float help = Math.abs(MARGIN_BETWEEN * j);
                ship.setPosition(new Vector2(help + (posx * j),
                        position.y + ship.getHeight() * i
                ));

                ships.add((EnemyShip) ship);
            }
        }

    }
    public void checkCollisions() {
        // Check collisions
        for (Laser laser : LaserManager.lasers) {
            for (EnemyShip enemyShip : ships) {
                Ship ship = (Ship) enemyShip;
                if (ship.isCollidedWith(laser.getBoundingBox()) && !laser.isRemovable()) {

                    laser.setRemovable(true);
                    ExplosionManager.explosions.add(
                            new Explosion(laser.getPosition())
                    );
                    PlayerShip.score += 1;
                    break;
                }
            }
        }
    }

    public void render(SpriteBatch batch) {
        checkCollisions();
        ships.forEach(ship -> ship.render(batch));

    }
}
