package views;

import controllers.SceneManager;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.lang.reflect.Array;
import java.util.*;

import javafx.scene.text.Text;
import models.*;


public class LeagueSimulatorPane extends GamePane {

    Game GAME = Game.getInstance();

    private final VBox leftContainer = new VBox();
    private final VBox matchesContainer = new VBox();
    private final VBox centerContainer = new VBox();

    private Label title = new Label("League Simulator");
    private final Button returnButton = new Button("Return");
    private final Button playButton = new Button("Start");
    private final Button refreshButton = new Button("Clear");

    private Label sizeLabel = new Label("League size:");
    final ComboBox<String> size = new ComboBox<>();
    private HBox sizeBox = new HBox();

    ArrayList<String > teamNames = GAME.getAllTeamNames();

    private Label match1 = new Label("Match 1:");
    final ComboBox<String> comboBox1 = new ComboBox<>(FXCollections.observableList(teamNames));
    final ComboBox<String> comboBox2 = new ComboBox<>(FXCollections.observableList(teamNames));
    private VBox matchBox1 = new VBox();

    private Label match2 = new Label("Match 2:");
    final ComboBox<String> comboBox3 = new ComboBox<>(FXCollections.observableList(teamNames));
    final ComboBox<String> comboBox4 = new ComboBox<>(FXCollections.observableList(teamNames));
    private VBox matchBox2 = new VBox();

    private HBox matches1and2 = new HBox();

    private Label match3 = new Label("Match 3:");
    final ComboBox<String> comboBox5 = new ComboBox<>(FXCollections.observableList(teamNames));
    final ComboBox<String> comboBox6 = new ComboBox<>(FXCollections.observableList(teamNames));
    private VBox matchBox3 = new VBox();

    private Label match4 = new Label("Match 4:");
    final ComboBox<String> comboBox7 = new ComboBox<>(FXCollections.observableList(teamNames));
    final ComboBox<String> comboBox8 = new ComboBox<>(FXCollections.observableList(teamNames));
    private VBox matchBox4 = new VBox();

    private HBox matches3and4 = new HBox();

    private Label match5 = new Label("Match 5:");
    final ComboBox<String> comboBox9 = new ComboBox<>(FXCollections.observableList(teamNames));
    final ComboBox<String> comboBox10 = new ComboBox<>(FXCollections.observableList(teamNames));
    private VBox matchBox5 = new VBox();

    private Label match6 = new Label("Match 6:");
    final ComboBox<String> comboBox11 = new ComboBox<>(FXCollections.observableList(teamNames));
    final ComboBox<String> comboBox12 = new ComboBox<>(FXCollections.observableList(teamNames));
    private VBox matchBox6 = new VBox();

    private HBox matches5and6 = new HBox();

    private Label match7 = new Label("Match 7:");
    final ComboBox<String> comboBox13 = new ComboBox<>(FXCollections.observableList(teamNames));
    final ComboBox<String> comboBox14 = new ComboBox<>(FXCollections.observableList(teamNames));
    private VBox matchBox7 = new VBox();

    private Label match8 = new Label("Match 8:");
    final ComboBox<String> comboBox15 = new ComboBox<>(FXCollections.observableList(teamNames));
    final ComboBox<String> comboBox16 = new ComboBox<>(FXCollections.observableList(teamNames));
    private VBox matchBox8 = new VBox();

    private HBox matches7and8 = new HBox();

    int currentLeagueId = 0;


    public LeagueSimulatorPane() {
        connectComponents();
        styleComponents();
        setCallbacks();
    }

    @Override
    void connectComponents() {

        leftContainer.getChildren().addAll(title, sizeBox, matchesContainer, playButton, refreshButton, returnButton);

        size.getItems().addAll("8", "4", "2");
        size.getSelectionModel().selectFirst();
        sizeBox.getChildren().addAll(sizeLabel, size);

        matchBox1.getChildren().addAll(match1, comboBox1, comboBox2);
        matchBox2.getChildren().addAll(match2, comboBox3, comboBox4);
        matchBox3.getChildren().addAll(match3, comboBox5, comboBox6);
        matchBox4.getChildren().addAll(match4, comboBox7, comboBox8);
        matchBox5.getChildren().addAll(match5, comboBox9, comboBox10);
        matchBox6.getChildren().addAll(match6, comboBox11, comboBox12);
        matchBox7.getChildren().addAll(match7, comboBox13, comboBox14);
        matchBox8.getChildren().addAll(match8, comboBox15, comboBox16);

        matches1and2.getChildren().addAll(matchBox1,matchBox2);
        matches3and4.getChildren().addAll(matchBox3,matchBox4);
        matches5and6.getChildren().addAll(matchBox5,matchBox6);
        matches7and8.getChildren().addAll(matchBox7,matchBox8);

        matchesContainer.getChildren().addAll(matches1and2,matches3and4,matches5and6,matches7and8);

        this.setLeft(leftContainer);
        this.setCenter(centerContainer);
    }

    @Override
    void styleComponents() {
        leftContainer.setStyle(" -fx-padding: 20 20 20 20;\n" +
                "        -fx-alignment: top-center;\n" +
                "        -fx-background-color: #ccc;\n" +
                "        -fx-spacing: 15;");
        leftContainer.setAlignment(Pos.CENTER);

        //centerContainer.setAlignment(Pos.CENTER);
        centerContainer.setStyle("-fx-alignment: top-left;\n"+
                " -fx-padding: 20 20 20 20;\n"+
                "        -fx-spacing: 15;");

        matchesContainer.setAlignment(Pos.CENTER);

        title.setStyle("-fx-font-size: 20;");
        sizeLabel.setStyle("-fx-font-size: 16;");

        String bigButton = "    -fx-font-size: 15;\n" +
                "    -fx-font-family: sans-serif;\n" +
                "    -fx-pref-width: 200;\n" +
                "    -fx-pref-height: 40;\n" +
                "    -fx-background-radius: 16px;";

        returnButton.setStyle(bigButton);
        playButton.setStyle(bigButton);
        refreshButton.setStyle(bigButton);
    }

    void createLeagueSchedule() throws Exception{

        Queue<Team> schedule = new LinkedList<>();
        int leagueSize = Integer.parseInt(size.getSelectionModel().getSelectedItem());
        ArrayList<String> teamNames = new ArrayList<>();

        if ( leagueSize == 8 ){
            teamNames.addAll(Arrays.asList(comboBox1.getSelectionModel().getSelectedItem(),
                    comboBox2.getSelectionModel().getSelectedItem(),
                    comboBox3.getSelectionModel().getSelectedItem(),
                    comboBox4.getSelectionModel().getSelectedItem(),
                    comboBox5.getSelectionModel().getSelectedItem(),
                    comboBox6.getSelectionModel().getSelectedItem(),
                    comboBox7.getSelectionModel().getSelectedItem(),
                    comboBox8.getSelectionModel().getSelectedItem(),
                    comboBox9.getSelectionModel().getSelectedItem(),
                    comboBox10.getSelectionModel().getSelectedItem(),
                    comboBox11.getSelectionModel().getSelectedItem(),
                    comboBox12.getSelectionModel().getSelectedItem(),
                    comboBox13.getSelectionModel().getSelectedItem(),
                    comboBox14.getSelectionModel().getSelectedItem(),
                    comboBox15.getSelectionModel().getSelectedItem(),
                    comboBox16.getSelectionModel().getSelectedItem()));
        } else if (leagueSize == 4){
            teamNames.addAll(Arrays.asList(comboBox1.getSelectionModel().getSelectedItem(),
                    comboBox2.getSelectionModel().getSelectedItem(),
                    comboBox3.getSelectionModel().getSelectedItem(),
                    comboBox4.getSelectionModel().getSelectedItem(),
                    comboBox5.getSelectionModel().getSelectedItem(),
                    comboBox6.getSelectionModel().getSelectedItem(),
                    comboBox7.getSelectionModel().getSelectedItem(),
                    comboBox8.getSelectionModel().getSelectedItem()));

        } else {
            teamNames.addAll(Arrays.asList(comboBox1.getSelectionModel().getSelectedItem(),
                    comboBox2.getSelectionModel().getSelectedItem(),
                    comboBox3.getSelectionModel().getSelectedItem(),
                    comboBox4.getSelectionModel().getSelectedItem()));
        }

        for(int i = 0; i < teamNames.size(); i++){
            if(teamNames.get(i) != null)
                schedule.add(GAME.getTeamByName(teamNames.get(i)));
            else
                throw new Exception("Field empty");
        }

        GAME.createLeague(schedule, currentLeagueId);

    }


    void displayWinners() {

        HashMap<Integer, ArrayList<Team>> winners = GAME.getLeagueResults(currentLeagueId);

        for (int round: winners.keySet()){
            int key = round;
            ArrayList<Team> values = winners.get(round);

            String roundWinners = Arrays.toString(values.stream().map(team -> team.getTeamName()).toArray());
            roundWinners = roundWinners.substring(1, roundWinners.length() - 1);

            String nextRoundMatches = "";
            for(int i = 0; i < values.size() - 1; i=i+2){
                nextRoundMatches += "( " + values.get(i).getTeamName() + " vs. " + values.get(i + 1).getTeamName() + " ) \n";
            }

            Text winnersText = new Text("Round " + round + " winner results: \n" + roundWinners);
            Text nextRound = new Text( "Round " + (round + 1) + " matches: \n" + nextRoundMatches);

            centerContainer.getChildren().addAll(winnersText, nextRound);

        }

        centerContainer.getChildren().remove(centerContainer.getChildren().size() - 1);
        currentLeagueId++;

    }

    void showError( String text ){
        Text errorText = new Text(text);
        errorText.setFill(Color.RED);
        centerContainer.getChildren().add(errorText);
    }

    void refreshSelection() {
        comboBox1.valueProperty().set(null);
        comboBox2.valueProperty().set(null);
        comboBox3.valueProperty().set(null);
        comboBox4.valueProperty().set(null);
        comboBox5.valueProperty().set(null);
        comboBox6.valueProperty().set(null);
        comboBox7.valueProperty().set(null);
        comboBox8.valueProperty().set(null);
        comboBox9.valueProperty().set(null);
        comboBox10.valueProperty().set(null);
        comboBox11.valueProperty().set(null);
        comboBox12.valueProperty().set(null);
        comboBox13.valueProperty().set(null);
        comboBox14.valueProperty().set(null);
        comboBox15.valueProperty().set(null);
        comboBox16.valueProperty().set(null);
    }

    @Override
    void setCallbacks() {
        playButton.setOnMouseClicked(event -> {
            centerContainer.getChildren().clear();
            try {
                this.createLeagueSchedule();
                this.displayWinners();
            } catch (Exception e) {
                this.showError("Please select teams for all matches.");
            }
        });

        returnButton.setOnMouseClicked(event -> SceneManager.getInstance().showPane((MainMenuPane.class)));
        refreshButton.setOnMouseClicked(event -> refreshSelection());
    }

    void updateTeams() {
        teamNames = GAME.getAllTeamNames();
        comboBox1.setItems(FXCollections.observableList(teamNames));
        comboBox2.setItems(FXCollections.observableList(teamNames));
        comboBox3.setItems(FXCollections.observableList(teamNames));
        comboBox4.setItems(FXCollections.observableList(teamNames));
        comboBox5.setItems(FXCollections.observableList(teamNames));
        comboBox6.setItems(FXCollections.observableList(teamNames));
        comboBox7.setItems(FXCollections.observableList(teamNames));
        comboBox8.setItems(FXCollections.observableList(teamNames));
        comboBox9.setItems(FXCollections.observableList(teamNames));
        comboBox10.setItems(FXCollections.observableList(teamNames));
        comboBox11.setItems(FXCollections.observableList(teamNames));
        comboBox12.setItems(FXCollections.observableList(teamNames));
        comboBox13.setItems(FXCollections.observableList(teamNames));
        comboBox14.setItems(FXCollections.observableList(teamNames));
        comboBox15.setItems(FXCollections.observableList(teamNames));
        comboBox16.setItems(FXCollections.observableList(teamNames));
    }
}
