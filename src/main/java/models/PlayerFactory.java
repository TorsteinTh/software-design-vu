package models;
import java.util.HashMap;
import java.util.Map;

public class PlayerFactory {
    static Map<String, PlayerType> playerTypes = new HashMap<>();

    public static PlayerType getPlayerType(String name, int score) {
        PlayerType player = playerTypes.get(name);
        if (player == null) {
            player = new PlayerType(score);
            playerTypes.put(name, player);
        }
        return player;
    }
}