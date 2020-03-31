package models;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class PlayerFactory {
    static Map<String, PlayerType> playerTypes = new HashMap<>();

    public static PlayerType getPlayerType(String name, int score) {
        PlayerType result = playerTypes.get(name);
        if (result == null) {
            result = new PlayerType(score);
            playerTypes.put(name, result);
        }
        return result;
    }
}