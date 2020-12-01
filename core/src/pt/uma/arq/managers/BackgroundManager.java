package pt.uma.arq.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import pt.uma.arq.game.Game;

public class BackgroundManager {

    private Texture texture;
    SpriteBatch spriteBatch;
    int sourceY = 0;

    public BackgroundManager(SpriteBatch batch) {
        this.spriteBatch = batch;
        texture = new Texture(Gdx.files.internal("background-blue.png"));
        texture.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);

    }

    public void render() {
        sourceY = ((sourceY + 2) % texture.getHeight());
        spriteBatch.draw(texture, 0, 0, 0, -sourceY, Game.WINDOW_WIDTH, Game.WINDOW_HEIGHT);

    }

}
