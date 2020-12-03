package pt.uma.arq.entities.enemies;


import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pt.uma.arq.entities.Collidable;

public interface EnemyShip extends Collidable {
    enum EnemyShipType {
        SMALL,
        MEDIUM,
        LARGE,
    }

    void render(SpriteBatch batch);
}
