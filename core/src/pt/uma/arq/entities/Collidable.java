package pt.uma.arq.entities;

import com.badlogic.gdx.math.Rectangle;

public interface Collidable {
    boolean isCollidedWith(Rectangle rectangle);

    Rectangle getBoundingBox();
}
