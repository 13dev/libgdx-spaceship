package pt.uma.arq.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import pt.uma.arq.entities.PlayerShip;
import pt.uma.arq.entities.core.Ship;
import pt.uma.arq.entities.enemies.Fleet;
import pt.uma.arq.managers.*;

public class Game extends ApplicationAdapter {
    public static final int WINDOW_WIDTH = 600;
    public static final int WINDOW_HEIGHT = 800;

    private SpriteBatch batch;
    private BackgroundManager backgroundManager;
    private BitmapFont font;
    private PlayerShip playerShip;
    private AudioManager audioManager;
    private UIManager uiManager;

    Fleet fleet;

    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new FontManager("font.ttf", 30).getFont();
        backgroundManager = new BackgroundManager();
        audioManager = new AudioManager();
        audioManager.setMusicVolume(0.4f);
        audioManager.registerSound("shoot.ogg");
        audioManager.registerSong("background-music.mp3");
        audioManager.playSong("background-music", true);
        playerShip = new PlayerShip(
                WINDOW_WIDTH / 2.f - PlayerShip.SHIP_WIDTH / 2,
                25f,
                audioManager
        );
        fleet = new Fleet(new Vector2(5, WINDOW_HEIGHT - Ship.SHIP_HEIGHT * 3));
        fleet.create();
        uiManager = new UIManager();

    }

    @Override
    public void render() {
        // clear screen
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        batch.begin();

        playerShip.update();
        backgroundManager.render(batch);
        playerShip.render(batch);
        fleet.render(batch);
        LaserManager.render(batch);
        ExplosionManager.render(batch);


        uiManager.renderNumber(batch, playerShip.getScore(), 138, WINDOW_HEIGHT - 15, 25f);

        font.draw(batch, "SCORE:", 30, WINDOW_HEIGHT - 20);
        batch.end();


    }


    @Override
    public void dispose() {
        // don't forget to dispose to avoid memory leaks!
        font.dispose();
        batch.dispose();
    }
}