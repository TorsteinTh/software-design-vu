package models;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Game {

    private static final Game GAME_INSTANCE = new Game();

    private static ArrayList<Player> allPlayers;
    private static ArrayList<Team> allTeams;
    private League league;

    public Game(){
        allPlayers = new ArrayList<>();
        allTeams = new ArrayList<>();
    }

    public void addPlayers(Player newPlayer){
        //TODO
        allPlayers.add(newPlayer);
    }

    public ArrayList<String> getAllPlayersNames() {
        return new ArrayList<>(allPlayers.stream().map(player -> player.getName()).collect(Collectors.toList()));
    }

    public ArrayList<Player> getAllPlayers() {
        return allPlayers;
    }

    public Player getPlayerByName(String name){

        for(Player player : allPlayers){
            if(player.getName().equals(name))
                return player;
        }
        return null;
    }

    public void addTeam(Player[] players, String teamName){

        Team newTeam = new Team(players, teamName);
        if( this.getTeamByName(teamName) != null ) {
            this.getTeamByName(teamName).setPlayers(players);
        } else {
            allTeams.add(newTeam);
        }

    }

    public void createLeague(Queue<Team> schedule){

        league = new League(schedule);
    }

    public HashMap<Integer, ArrayList<Team>> getLeagueResults(){
        //TODO
        return league.getWinners();
    }

    public ArrayList<Team>  generateLeaderboard(){
        //TODO
        ArrayList<Team> leaderboard = (ArrayList<Team>) allTeams.clone();
        Collections.sort(leaderboard, Comparator.comparingInt(Team::getTotalWins));
        return leaderboard;

    }

    public ArrayList<String> getAllTeamNames(){
        return new ArrayList<>(allTeams.stream().map(team -> team.getTeamName()).collect(Collectors.toList()));
    }

    public Team getTeamByName(String name){

        for(Team team : allTeams){
            if(team.getTeamName().equals(name))
                return team;
        }
        return null;

    }

    public static ArrayList<Player> getPlayers(){
        return allPlayers;

    }
    public void removeTeam(String teamName){
        //TODO
    }

    public void removePlayer(String playerName){
        //TODO
    }

    public static Game getInstance() {
        return GAME_INSTANCE;
    }

}
