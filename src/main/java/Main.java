import controllers.SceneManager;
import javafx.application.Application;
import javafx.stage.Stage;
import models.Game;
import models.Player;
import models.PlayerFactory;
import models.PlayerType;
import views.MainMenuPane;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Main extends Application {

    @Override
    public void start(final Stage primaryStage) {
        generatePlayers();
        generateTeams();

        SceneManager.getInstance().setStage(primaryStage);
        SceneManager.getInstance().showPane(MainMenuPane.class);
    }

    /* Generates 100 Players with a random score */
    public void generatePlayers() {
        for(int i = 0; i < 100; i++){
            PlayerType type = PlayerFactory.getPlayerType("Player" + i, getRandomNumberInRange(15, 25));
            Player player = new Player("Player" + i, type);
            Game.getInstance().addPlayers(player);
        }
    }

    /* Generates 8 different teams with 11 random players */
    public void generateTeams(){
        ArrayList<Player> players = Game.getPlayers();

        for(int i = 0; i < 8; i++){
            ArrayList<Player> tmpTeam = new ArrayList<Player>();

            for (int j = 0; j < 11; j++) {
                tmpTeam.add(players.get(getRandomNumberInRange(0, 99)));
            }
            Game.getInstance().addTeam(tmpTeam.toArray(new Player[0]), "Team " + i);
        }
        return;
    }

    // Function to randomly generate a number between min and max
    private static int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }


    public static void main(String[] args) {
            Main.launch(args);
    }
}
