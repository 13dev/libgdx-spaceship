package pt.uma.arq.entities;
// Created by 13dev - 01/12/2020

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import pt.uma.arq.game.Animator;

public class PlayerEffect {

    private final SpriteBatch spriteBatch;
    Animator animator;

    PlayerEffect(SpriteBatch spriteBatch) {

        this.spriteBatch = spriteBatch;
    }


    public void render(Vector2 position) {
        animator.render(position);
    }

}
