package pt.uma.arq.entities.enemies;


import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pt.uma.arq.entities.Collidable;
import pt.uma.arq.entities.Removable;

public interface EnemyShip extends Collidable, Removable {
    enum EnemyShipType {
        SMALL,
        MEDIUM,
        LARGE,
    }

    void render(SpriteBatch batch);

    // get damage to different type of ship
    int getDamage();

}
