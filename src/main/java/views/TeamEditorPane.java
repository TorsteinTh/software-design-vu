package views;

import controllers.SceneManager;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.*;

import javafx.scene.text.Text;
import models.*;


public class TeamEditorPane extends GamePane {

    Game GAME = Game.getInstance();

    private final VBox centerContainer = new VBox();

    private Label title = new Label("Team Editor");
    private final Button returnButton = new Button("Return");
    private final Button saveButton = new Button("Save team");

    private ArrayList<String> playerNames = GAME.getAllPlayersNames();
    private ArrayList<Player> fullPlayers = GAME.getAllPlayers();
    private Player[] playerStuff = new Player[11];

    private Label player1 = new Label("Player 1: ");
    ComboBox<String> comboBox1 = new ComboBox<>(FXCollections.observableList(playerNames));
    private HBox playerBox1 = new HBox();
    private HBox errorContainer1 = new HBox();

    private Label player2 = new Label("Player 2: ");
    ComboBox<String> comboBox2 = new ComboBox<>(FXCollections.observableList(playerNames));
    private HBox playerBox2 = new HBox();
    private HBox errorContainer2 = new HBox();

    private Label player3 = new Label("Player 3: ");
    ComboBox<String> comboBox3 = new ComboBox<>(FXCollections.observableList(playerNames));
    private HBox playerBox3 = new HBox();
    private HBox errorContainer3 = new HBox();

    private Label player4 = new Label("Player 4: ");
    ComboBox<String> comboBox4 = new ComboBox<>(FXCollections.observableList(playerNames));
    private HBox playerBox4 = new HBox();
    private HBox errorContainer4 = new HBox();

    private Label player5 = new Label("Player 5: ");
    ComboBox<String> comboBox5 = new ComboBox<>(FXCollections.observableList(playerNames));
    private HBox playerBox5 = new HBox();
    private HBox errorContainer5 = new HBox();

    private Label player6 = new Label("Player 6: ");
    ComboBox<String> comboBox6 = new ComboBox<>(FXCollections.observableList(playerNames));
    private HBox playerBox6 = new HBox();
    private HBox errorContainer6 = new HBox();

    private Label player7 = new Label("Player 7: ");
    ComboBox<String> comboBox7 = new ComboBox<>(FXCollections.observableList(playerNames));
    private HBox playerBox7 = new HBox();
    private HBox errorContainer7 = new HBox();

    private Label player8 = new Label("Player 8: ");
    ComboBox<String> comboBox8 = new ComboBox<>(FXCollections.observableList(playerNames));
    private HBox playerBox8 = new HBox();
    private HBox errorContainer8 = new HBox();

    private Label player9 = new Label("Player 9: ");
    ComboBox<String> comboBox9 = new ComboBox<>(FXCollections.observableList(playerNames));
    private HBox playerBox9 = new HBox();
    private HBox errorContainer9 = new HBox();

    private Label player10 = new Label("Player 10: ");
    ComboBox<String> comboBox10 = new ComboBox<>(FXCollections.observableList(playerNames));
    private HBox playerBox10 = new HBox();
    private HBox errorContainer10 = new HBox();

    private Label player11 = new Label("Player 11: ");
    ComboBox<String> comboBox11 = new ComboBox<>(FXCollections.observableList(playerNames));
    private HBox playerBox11 = new HBox();
    private HBox errorContainer11 = new HBox();

    Text successText = new Text("Team successfully created!");

    public TeamEditorPane() {
        connectComponents();
        styleComponents();
        setCallbacks();
    }

    @Override
    void connectComponents() {

        ArrayList<String> playerNames = GAME.getAllPlayersNames();

        for (int i = 0; i < fullPlayers.size(); i++){
            playerNames.set(i, fullPlayers.get(i).getName() + ", Score: " + fullPlayers.get(i).getScore());
        }

        comboBox1 = new ComboBox<>(FXCollections.observableList(playerNames));
        comboBox2 = new ComboBox<>(FXCollections.observableList(playerNames));
        comboBox3 = new ComboBox<>(FXCollections.observableList(playerNames));
        comboBox4 = new ComboBox<>(FXCollections.observableList(playerNames));
        comboBox5 = new ComboBox<>(FXCollections.observableList(playerNames));
        comboBox6 = new ComboBox<>(FXCollections.observableList(playerNames));
        comboBox7 = new ComboBox<>(FXCollections.observableList(playerNames));
        comboBox8 = new ComboBox<>(FXCollections.observableList(playerNames));
        comboBox9 = new ComboBox<>(FXCollections.observableList(playerNames));
        comboBox10 = new ComboBox<>(FXCollections.observableList(playerNames));
        comboBox11 = new ComboBox<>(FXCollections.observableList(playerNames));

        playerBox1.getChildren().addAll(player1, comboBox1, errorContainer1);
        playerBox2.getChildren().addAll(player2, comboBox2, errorContainer2);
        playerBox3.getChildren().addAll(player3, comboBox3, errorContainer3 );
        playerBox4.getChildren().addAll(player4, comboBox4, errorContainer4);
        playerBox5.getChildren().addAll(player5, comboBox5, errorContainer5);
        playerBox6.getChildren().addAll(player6, comboBox6, errorContainer6);
        playerBox7.getChildren().addAll(player7, comboBox7, errorContainer7);
        playerBox8.getChildren().addAll(player8, comboBox8, errorContainer8);
        playerBox9.getChildren().addAll(player9, comboBox9, errorContainer9);
        playerBox10.getChildren().addAll(player10, comboBox10, errorContainer10);
        playerBox11.getChildren().addAll(player11, comboBox11, errorContainer11);

        centerContainer.getChildren().addAll(title,playerBox1, playerBox2, playerBox3, playerBox4, playerBox5, playerBox6, playerBox7, playerBox8, playerBox9, playerBox10, playerBox11, saveButton, returnButton, successText);

        this.setCenter(centerContainer);
    }

    @Override
    void styleComponents() {
        centerContainer.setStyle(" -fx-padding: 20 20 20 20;\n" +
                "        -fx-alignment: top-center;\n" +
                "        -fx-background-color: #ccc;\n" +
                "        -fx-spacing: 15;");
        centerContainer.setAlignment(Pos.CENTER);

        title.setStyle("-fx-font-size: 20;");

        String bigButton = "    -fx-font-size: 15;\n" +
                "    -fx-font-family: sans-serif;\n" +
                "    -fx-pref-width: 200;\n" +
                "    -fx-pref-height: 40;\n" +
                "    -fx-background-radius: 16px;";

        returnButton.setStyle(bigButton);
        saveButton.setStyle(bigButton);
        successText.setFill(Color.GREEN);
        successText.setVisible(false);
    }

    private void createTeam() throws Exception {
        errorContainer1.getChildren().clear();
        errorContainer2.getChildren().clear();
        errorContainer3.getChildren().clear();
        errorContainer4.getChildren().clear();
        errorContainer5.getChildren().clear();
        errorContainer6.getChildren().clear();
        errorContainer7.getChildren().clear();
        errorContainer8.getChildren().clear();
        errorContainer9.getChildren().clear();
        errorContainer10.getChildren().clear();
        errorContainer11.getChildren().clear();

        String[] chosenPlayers = getChosenPlayers();

        for(int i = 0; i < chosenPlayers.length; i++){
            if(chosenPlayers[i] != null) {
                String name = chosenPlayers[i].substring(0, chosenPlayers[i].indexOf(","));
                playerStuff[i] = (GAME.getPlayerByName(name));
            }
            else
                throw new Exception("Field empty");
        }

        GAME.addTeam(playerStuff, "Your Team");
    }

    String[] getChosenPlayers() {
        String[] players = {comboBox1.getSelectionModel().getSelectedItem(),
                comboBox2.getSelectionModel().getSelectedItem(),
                comboBox3.getSelectionModel().getSelectedItem(),
                comboBox4.getSelectionModel().getSelectedItem(),
                comboBox5.getSelectionModel().getSelectedItem(),
                comboBox6.getSelectionModel().getSelectedItem(),
                comboBox7.getSelectionModel().getSelectedItem(),
                comboBox8.getSelectionModel().getSelectedItem(),
                comboBox9.getSelectionModel().getSelectedItem(),
                comboBox10.getSelectionModel().getSelectedItem(),
                comboBox11.getSelectionModel().getSelectedItem(),};
        return players;
    }

    private void showError( String text ){
        String[] players = getChosenPlayers();

        for(int i = 0; i < players.length; i++){
            if(players[i] == null){
                Text errorText = new Text(text);
                errorText.setFill(Color.RED);
                HBox boxToChange = new HBox();

                switch (i){
                    case 0:
                        boxToChange = errorContainer1;
                        break;
                    case 1:
                        boxToChange = errorContainer2;
                        break;
                    case 2:
                        boxToChange = errorContainer3;
                        break;
                    case 3:
                        boxToChange = errorContainer4;
                        break;
                    case 4:
                        boxToChange = errorContainer5;
                        break;
                    case 5:
                        boxToChange = errorContainer6;
                        break;
                    case 6:
                        boxToChange = errorContainer7;
                        break;
                    case 7:
                        boxToChange = errorContainer8;
                        break;
                    case 8:
                        boxToChange = errorContainer9;
                        break;
                    case 9:
                        boxToChange = errorContainer10;
                        break;
                    case 10:
                        boxToChange = errorContainer11;
                        break;
                }
                boxToChange.getChildren().clear();
                boxToChange.getChildren().add(errorText);
            }
        }
    }

    @Override
    void setCallbacks() {
        saveButton.setOnMouseClicked(event -> {
            try {
                this.createTeam();
                LeagueSimulatorPane pane = SceneManager.getInstance().getPane(LeagueSimulatorPane.class);
                pane.updateTeams();
                successText.setVisible(true);
            } catch (Exception e) {
                this.showError("Missing player");
            }
        });

        returnButton.setOnMouseClicked(event -> SceneManager.getInstance().showPane((MainMenuPane.class)));
    }

}