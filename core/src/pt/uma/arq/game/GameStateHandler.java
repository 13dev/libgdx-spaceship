package pt.uma.arq.game;
// Created by 13dev - 04/12/2020

public class GameStateHandler {
    public enum StateType {
        PLAYING,
        GAME_OVER,
        WIN,
    }

    private static StateType gameState;

    static {
        gameState = StateType.PLAYING;
    }

    public static void setGameState(StateType gameState) {
        GameStateHandler.gameState = gameState;
    }

    public static StateType getGameState() {
        return gameState;
    }
}
