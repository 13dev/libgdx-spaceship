package pt.uma.arq.entities.enemies;


import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface EnemyShip {
    enum EnemyShipType {
        SMALL,
        MEDIUM,
        LARGE,
    }

    void render(SpriteBatch batch);
}
