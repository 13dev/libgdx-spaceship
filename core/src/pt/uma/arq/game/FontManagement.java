package pt.uma.arq.game;
// Created by 13dev - 01/12/2020

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class FontManagement {
    private final FreeTypeFontGenerator.FreeTypeFontParameter fontParameter;
    private final FreeTypeFontGenerator fontGenerator;
    private final BitmapFont font;

    FontManagement(String fontPath, int fontSize) {
        fontGenerator = new FreeTypeFontGenerator(
                Gdx.files.internal(fontPath)
        );

        fontParameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        fontParameter.size = fontSize;

        font = fontGenerator.generateFont(fontParameter);
    }


    public BitmapFont getFont() {
        return font;
    }
}
