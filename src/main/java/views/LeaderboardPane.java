package views;

import controllers.SceneManager;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import models.*;

import java.util.ArrayList;

public class LeaderboardPane extends GamePane {

    Game GAME = Game.getInstance();

    private final Label title = new Label("Teams leaderboard");
    private final VBox container = new VBox();
    private final VBox rankings = new VBox();
    private final Button returnButton = new Button("Return");


    public LeaderboardPane() {
        connectComponents();
        styleComponents();
        setCallbacks();
    }

    @Override
    void connectComponents() {

        container.getChildren().addAll(title, rankings, returnButton);
        this.setCenter(container);

    }


    @Override
    void styleComponents() {

        String bigButton = "    -fx-font-size: 15;\n" +
                "    -fx-font-family: sans-serif;\n" +
                "    -fx-pref-width: 200;\n" +
                "    -fx-pref-height: 40;\n" +
                "    -fx-background-radius: 16px;";
        returnButton.setStyle(bigButton);

        container.setStyle("    -fx-background-color: #ddd;\n" +
                "    -fx-alignment: center;\n" +
                "    -fx-spacing: 20;");
        title.setStyle("-fx-font-size: 20;");

        container.setAlignment(Pos.CENTER);
        rankings.setAlignment(Pos.CENTER);

    }

    void updateRankings() {

        rankings.getChildren().clear();
        ArrayList<Team> leaderboard = GAME.generateLeaderboard();

        for (int i = 1; i <= leaderboard.size(); i++){
            Team team = leaderboard.get(leaderboard.size() - i);
            Text teamText = new Text( i + ". " + team.getTeamName() + " (Wins: " + team.getTotalWins() + ")" + ", Score: " + team.getTeamScore() );
            rankings.getChildren().add(teamText);
        }

    }

    @Override
    void setCallbacks() {
        returnButton.setOnMouseClicked(event -> SceneManager.getInstance().showPane((MainMenuPane.class)));
    }
}
