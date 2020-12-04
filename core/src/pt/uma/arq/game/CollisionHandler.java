package pt.uma.arq.game;

import com.badlogic.gdx.math.Vector2;
import pt.uma.arq.entities.Explosion;
import pt.uma.arq.entities.Laser;
import pt.uma.arq.entities.PlayerShip;
import pt.uma.arq.entities.core.Ship;
import pt.uma.arq.entities.enemies.EnemyShip;
import pt.uma.arq.managers.ExplosionManager;

public class CollisionHandler {

    public static void laserAndEnemyShip(Laser laser, EnemyShip ship)
    {
        if (ship.isCollidedWith(laser.getBoundingBox()) && !laser.isRemovable()) {
            PlayerShip.score++;
            laser.setRemovable(true);
            ship.setRemovable(true);

            ExplosionManager.newMiddleExplosion(ship);
        }
    }

    public static void laserAndPlayerShip(Laser laser, PlayerShip ship) {
        if (ship.isCollidedWith(laser.getBoundingBox()) && !laser.isRemovable()) {
            PlayerShip.life -= laser.getDamage();
            laser.setRemovable(true);

            ExplosionManager.newMiddleExplosion(ship);
        }
    }

//    @FunctionalInterface
//    public interface CheckCollisionFunction<T extends Collidable, P extends Collidable> {
//        void apply(T object1, P object2);
//    }

//    public static boolean intersects(Collidable box, Collidable box1) {
//        return box.isCollidedWith(box1.getBoundingBox());
//    }

//    public static boolean dynamicCollision(ArrayList<? extends Collidable> dataOne, ArrayList<? extends Collidable> datatwo, CheckCollisionFunction<? extends Collidable,? extends Collidable> callback) {
//        for (Collidable object1 : dataOne) {
//            for (Collidable object2 : datatwo) {
//                if(intersects(object1, object2)) {
//                    callback.apply((GameObject) object1, object2);
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
}
