package pt.uma.arq.entities.enemies;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import pt.uma.arq.entities.Laser;
import pt.uma.arq.entities.core.Ship;
import pt.uma.arq.entities.core.Utils;
import pt.uma.arq.entities.enemies.EnemyShip.EnemyShipType;
import pt.uma.arq.game.CollisionHandler;
import pt.uma.arq.game.GameStateHandler;
import pt.uma.arq.managers.LaserManager;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Fleet {

    private int largeShipNum;
    private int mediumShipNum;
    private int smallShipNum;

    private final Vector2 position;
    public ArrayList<EnemyShip> ships;
    private static final int MARGIN = 20;
    private TimerTask shootRandomShipTask;
    private Timer shootRandomShipTimer;

    public Fleet(Vector2 position) {
        this.position = position;
        ships = new ArrayList<>();
        largeShipNum = 4;
        mediumShipNum = 5;
        smallShipNum = 7;
        shootRandomShipTimer = new Timer();
        shootRandomShipTask = new TimerTask() {
            @Override
            public void run() {
                shootRandomShip();
            }
        };

        shootRandomShipTimer.schedule(shootRandomShipTask, 2000, 2000);
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
        LaserManager.lasers.forEach(laser -> {
            ships.forEach(ship -> CollisionHandler.laserAndEnemyShip(laser, ship));
        });

//       CollisionManager.CheckCollisionFunction<Laser, Ship> laserAndShipLambda = (laser, ship) -> {
//            if(!laser.isRemovable()) {
//                laser.setRemovable(true);
//                ExplosionManager.explosions.add(
//                        new Explosion(laser.getPosition())
//                );
//                PlayerShip.score += 1;
//            }
//        };
//
//        CollisionManager.dynamicCollision(LaserManager.lasers, ships, laserAndShipLambda);


    }

    public void update() {
        checkCollisions();
        cleanEnemiesShip();
        if(ships.isEmpty()) {
            GameStateHandler.setGameState(GameStateHandler.StateType.WIN);
        }
    }

    public void render(SpriteBatch batch) {
        update();
        ships.forEach(ship -> ship.render(batch));
    }

    public void shootRandomShip() {
        if (!ships.isEmpty()) {
            EnemyShip ship = ships.get(
                    Utils.randomRange(0, ships.size())
            );

            ((Ship) ship).fire(Laser.LaserOwnerType.ENEMY, ship.getDamage());
        }
    }

    public void cleanEnemiesShip() {
        if (!ships.isEmpty()) {
            ships.removeIf(EnemyShip::isRemovable);
        }
    }
}
