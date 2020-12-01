package pt.uma.arq.managers;
// Created by 13dev - 01/12/2020

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class TextureAtlasManager {
    static final TextureAtlas textureAtlas;

    static {
        textureAtlas = new TextureAtlas(Gdx.files.internal("sheet.pack"));
    }

    public static TextureAtlas.AtlasRegion getRegion(String region) {
       return textureAtlas.findRegion(region);
    }

    public static Array<TextureAtlas.AtlasRegion> getRegions(String region) {
        return textureAtlas.findRegions(region);
    }
}
