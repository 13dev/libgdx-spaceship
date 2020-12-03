package pt.uma.arq.managers;
// Created by 13dev - 02/12/2020

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import java.util.HashMap;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

public class UIManager {
    protected HashMap<String, TextureRegion> textureRegionHashMap;

    public UIManager() {
        textureRegionHashMap = new HashMap<>();
        loadNumbers();
    }

    public void add(String key, TextureRegion textureRegion) {
        textureRegionHashMap.put(key, textureRegion);
    }

    public void loadNumbers() {
        // Load Numbers
        for (int i = 0; i < 10; i++) {
            TextureRegion textureRegion = TextureAtlasManager.getRegion(
                    String.format("numeral%s.png", i)
            );
            textureRegionHashMap.put(Integer.toString(i).toUpperCase(), textureRegion);
        }

    }

    public void renderNumber(SpriteBatch batch, int value, float x, float y, float width) {
        Stack<Integer> digits = getDigits(value);
        int counter = 0;

        while(!digits.empty()) {
            // get top and pop it
            int digit = digits.pop();

            // convert char to up and use as key
            String key = String.valueOf(digit).toUpperCase();

            // calc new position
            Vector2 pos = new Vector2(x + ((width + 2) * counter++), y);

            // render it
            render(textureRegionHashMap.get(key), batch, pos, width);
        }
    }


    private Stack<Integer> getDigits(int num) {
        Stack<Integer> digits = new Stack<>();
        while ( num > 0 ) {
            digits.push(num % 10);
            num /= 10;
        }
        return digits;
    }

    public void render(String key, SpriteBatch batch, Vector2 position, float width) {
        TextureRegion textureRegion = textureRegionHashMap.get(key);

        batch.draw(textureRegion, position.x, position.y, width, width);
    }

    public void render(TextureRegion textureRegion, SpriteBatch batch, Vector2 position, float width) {
        batch.draw(textureRegion, position.x, position.y, width, width);
    }


}
