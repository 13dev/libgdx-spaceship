package pt.uma.arq.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.math.Vector2;
import pt.uma.arq.entities.PlayerShip;

public class Game extends ApplicationAdapter {
    public static final int WINDOW_WIDTH = 600;
    public static final int WINDOW_HEIGHT = 800;

    private SpriteBatch batch;
    private BackgroundManagement backgroundManagement;
    private BitmapFont font;
    private PlayerShip playerShip;
    private OrthographicCamera camera;

    @Override
    public void create() {
        Gdx.graphics.setWindowedMode(WINDOW_WIDTH, WINDOW_HEIGHT);
        batch = new SpriteBatch();
        font = new FontManagement("font.ttf", 20).getFont();
        backgroundManagement = new BackgroundManagement(batch);
        playerShip = new PlayerShip(new Vector2(WINDOW_WIDTH / 2.f, WINDOW_HEIGHT / 2.f), batch);

        camera = new OrthographicCamera();
        camera.setToOrtho(false);

    }

    @Override
    public void render() {
        // clear screen
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        backgroundManagement.render();
        playerShip.render();

        font.draw(batch, "HELLO WORLD", 0, 0);
        batch.end();
    }


    @Override
    public void dispose() {
        // don't forget to dispose to avoid memory leaks!
        font.dispose();
        batch.dispose();
    }
}