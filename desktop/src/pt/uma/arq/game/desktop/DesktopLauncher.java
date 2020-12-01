package pt.uma.arq.game.desktop;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import pt.uma.arq.game.Game;

public class DesktopLauncher {
    public static void main(String[] arg) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setWindowedMode(Game.WINDOW_WIDTH, Game.WINDOW_HEIGHT);
        config.setResizable(false);
        new Lwjgl3Application(new Game(), config);
    }
}
