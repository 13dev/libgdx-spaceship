package pt.uma.arq.game;

import com.badlogic.gdx.math.Vector2;
import pt.uma.arq.entities.Explosion;
import pt.uma.arq.entities.Laser;
import pt.uma.arq.entities.core.Ship;
import pt.uma.arq.managers.ExplosionManager;

public class CollisionHandler {

    public static void laserAndEnemyShip(Laser laser, Ship ship)
    {
        if (ship.isCollidedWith(laser.getBoundingBox()) && !laser.isRemovable() && laser.isOwner(Laser.LaserOwnerType.PLAYER)) {
            laser.setRemovable(true);

            Vector2 explosionPosition = ship.getBoundingBox().getCenter(new Vector2());
            explosionPosition.x -= Explosion.WIDTH / 2;
            explosionPosition.y -= Explosion.HEIGHT / 2;

            ExplosionManager.explosions.add(
                    new Explosion(explosionPosition)
            );
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
