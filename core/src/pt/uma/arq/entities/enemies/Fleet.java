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

    private int largeShipNum;
    private int mediumShipNum;
    private int smallShipNum;

    private final Vector2 position;
    public ArrayList<EnemyShip> ships;
    private static final int MARGIN = 20;

    public Fleet(Vector2 position) {
        this.position = position;
        ships = new ArrayList<>();
        largeShipNum = 4;
        mediumShipNum = 5;
        smallShipNum = 7;
    }


    public void create() {

        for (int i = 0; i < largeShipNum; i++) {
            Vector2 newPosition = new Vector2(
                    calcPositionX(i + .3f, LargeShip.SHIP_LENGHT, 50),
                    position.y
            );

            ships.add(EnemyShipFactory.create(EnemyShipType.LARGE, newPosition));
        }

        for (int i = 0; i < mediumShipNum; i++) {
            Vector2 newPosition = new Vector2(
                    calcPositionX(i + .5f, MediumShip.SHIP_WIDTH, 20),
                    position.y - 50 - MediumShip.SHIP_HEIGHT
            );

            ships.add(EnemyShipFactory.create(EnemyShipType.MEDIUM, newPosition));
        }

        for (int i = 0; i < smallShipNum; i++) {
            Vector2 newPosition = new Vector2(
                    calcPositionX(i + .15f, SmallShip.WIDTH + 10, 10),
                    position.y - 100 - LargeShip.SHIP_LENGHT
            );

            ships.add(EnemyShipFactory.create(EnemyShipType.SMALL, newPosition));
        }


    }

    private float calcPositionX(float index, float shipWidth, int margin) {
        return position.x + (shipWidth + margin) * index;
    }

    public void checkCollisions() {
        // Check collisions
        for (Laser laser : LaserManager.lasers) {
            for (EnemyShip enemyShip : ships) {
                if (enemyShip.isCollidedWith(laser.getBoundingBox()) && !laser.isRemovable()) {
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
