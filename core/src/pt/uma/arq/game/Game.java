package pt.uma.arq.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import pt.uma.arq.entities.Bullet;
import pt.uma.arq.entities.PlayerShip;
import pt.uma.arq.entities.Ship;
import pt.uma.arq.entities.enemies.EnemyShip;
import pt.uma.arq.entities.enemies.Fleet;
import pt.uma.arq.managers.BackgroundManager;
import pt.uma.arq.managers.FontManager;

import java.util.ArrayList;

public class Game extends ApplicationAdapter {
    public static final int WINDOW_WIDTH = 600;
    public static final int WINDOW_HEIGHT = 800;

    private SpriteBatch batch;
    private BackgroundManager backgroundManager;
    private BitmapFont font;
    private PlayerShip playerShip;
    public static ArrayList<Bullet> bullets;
    Fleet fleet;

    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new FontManager("font.ttf", 20).getFont();
        backgroundManager = new BackgroundManager(batch);
        playerShip = new PlayerShip(
                new Vector2(WINDOW_WIDTH / 2.f - PlayerShip.SHIP_WIDTH / 2, 25f),
                batch
        );

        bullets = new ArrayList<>();
        fleet = new Fleet(new Vector2(60, WINDOW_HEIGHT - Ship.SHIP_HEIGHT * 5 - 20), batch);
        fleet.create();
    }

    @Override
    public void render() {
        // clear screen
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        backgroundManager.render();
        playerShip.render();
        playerShip.handleInput();
        updateBullets();

        for (Ship i : fleet.getShips()) {
            i.render();
        }

        font.draw(batch, "HELLO WORLD", 0, 0);
        batch.end();
    }

    public void updateBullets() {
        for (Bullet bullet : bullets) {
            bullet.update();
            bullet.render(batch);
        }

        if(!bullets.isEmpty()) {
            bullets.removeIf(Bullet::isRemovable);
        }
    }

    @Override
    public void dispose() {
        // don't forget to dispose to avoid memory leaks!
        font.dispose();
        batch.dispose();
    }
}