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


    private float calcPositionX(float index, float atualPosition, float shipWidth, int margin)
    {
        return atualPosition + (shipWidth + margin) * index;
    }

    public void create() {

        for (int i = 0; i < largeShipNum; i++) {
            Vector2 newPosition = new Vector2(
                    calcPositionX(i + .3f, position.x, LargeShip.SHIP_LENGHT, 50),
                    position.y
            );
            ships.add(EnemyShipFactory.create(EnemyShipType.LARGE, newPosition));
        }

        for (int i = 0; i < mediumShipNum; i++) {
            Vector2 newPosition = new Vector2(
                    calcPositionX(i + .5f, position.x, MediumShip.SHIP_WIDTH, 20),
                    position.y - 50 - MediumShip.SHIP_HEIGHT
            );

            ships.add(EnemyShipFactory.create(EnemyShipType.MEDIUM, newPosition));
        }

        for (int i = 0; i < smallShipNum; i++) {

            Vector2 newPosition = new Vector2(
                    calcPositionX(i + .15f, position.x, SmallShip.WIDTH + 10, 10),
                    position.y - 100 - LargeShip.SHIP_LENGHT
            );
            ships.add(EnemyShipFactory.create(EnemyShipType.SMALL, newPosition));
        }

//        for (int j = 0; j < SHIPS_PER_LINE; j++) {
//
//
//            float posx = (float) Gdx.graphics.getWidth() / 4;
//            posx /= 2;
//            float posxx = (posx - (ship.getWidth() / 2));
//            posx = posxx + ship.getWidth() + posxx;
//
//            //posx += MARGIN_BETWEEN * 2;
//            //posx += ship.getWidth() / 2;
//            //posx += ship.getWidth();
//
//            float help = Math.abs(MARGIN_BETWEEN * j);
//            ship.setPosition(new Vector2(help + (posx * j),
//                    position.y + ship.getHeight() * i
//            ));
//
//            ships.add((EnemyShip) ship);
//        }


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
