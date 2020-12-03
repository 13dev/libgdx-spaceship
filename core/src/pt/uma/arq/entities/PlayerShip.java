package pt.uma.arq.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import pt.uma.arq.entities.core.Ship;
import pt.uma.arq.game.Game;
import pt.uma.arq.managers.AudioManager;
import pt.uma.arq.managers.LaserManager;
import pt.uma.arq.managers.TextureAtlasManager;

public class PlayerShip extends Ship {

    public static final float PLAYER_BASE_ATTACK = 10;
    public static final float SHOOT_WAIT_TIME = 0.3f;
    private final AudioManager audioManager;
    private float elapsedTime = 0f;
    private float shootTime = 0f;
    private final Animation fireEffect;
    public static int score;

    public PlayerShip(float x, float y, AudioManager audioManager) {
        super(new Vector2(x, y), SHIP_WIDTH, SHIP_HEIGHT);
        this.audioManager = audioManager;
        score = 0;
        fireEffect = new Animation<TextureRegion>(0.090f, TextureAtlasManager.getRegions("fire"), Animation.PlayMode.LOOP);
    }

    @Override
    public float baseAttack() {
        return PLAYER_BASE_ATTACK;
    }

    @Override
    public void render(SpriteBatch batch) {
        elapsedTime += Gdx.graphics.getDeltaTime();
        shootTime += Gdx.graphics.getDeltaTime();
        batch.draw(TextureAtlasManager.getRegion("playerShip1_red.png"), position.x, position.y, SHIP_WIDTH, SHIP_HEIGHT);

        batch.draw((TextureRegion) fireEffect.getKeyFrame(elapsedTime, true), position.x + 16, position.y - 18);
        batch.draw((TextureRegion) fireEffect.getKeyFrame(elapsedTime, true), position.x + 55, position.y - 18);

    }

    public void update() {
        handleInput();
    }

    public void handleInput() {
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            position.x += SHIP_SPEED * Gdx.graphics.getDeltaTime();

            if(position.x + SHIP_WIDTH > Game.WINDOW_WIDTH) {
                position.x = 0;
            }
        }

        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            position.x -= SHIP_SPEED * Gdx.graphics.getDeltaTime();

            if(position.x < 0f) {
                position.x = Game.WINDOW_WIDTH - SHIP_WIDTH;
            }
        }

        if(Gdx.input.isKeyPressed(Input.Keys.SPACE) && shootTime >= SHOOT_WAIT_TIME) {
            shootTime = 0;

            Laser laser = new Laser(new Vector2(position.x + (SHIP_WIDTH / 2) - 4, position.y + Laser.DEFAULT_Y));

            LaserManager.lasers.add(laser);

            audioManager.play("shoot", (float)(Math.random() * 3) + 1f);
        }
    }

    public static int getScore() {
        return score;
    }

    public void incrementScore(int score) {
        this.score += score;
    }
}
