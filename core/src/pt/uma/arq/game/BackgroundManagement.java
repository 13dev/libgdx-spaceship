package pt.uma.arq.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BackgroundManagement {

    private Sprite sprite;

    SpriteBatch spriteBatch;

    public BackgroundManagement(SpriteBatch batch) {
        this.spriteBatch = batch;
        Texture texture = new Texture("space.png");
        sprite = new Sprite(texture);
        sprite.setSize(600, 800);
        sprite.setPosition(0, 0);

    }

    public void render() {
        spriteBatch.draw(sprite, 0, 0, sprite.getWidth(), sprite.getHeight());
    }

}
