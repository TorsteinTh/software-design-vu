package models;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Game {

    private static final Game GAME_INSTANCE = new Game();

    private static ArrayList<Player> allPlayers;
    private static ArrayList<Team> allTeams;
    private ArrayList<League> leagues;

    private Game(){
        allPlayers = new ArrayList<>();
        allTeams = new ArrayList<>();
        leagues = new ArrayList<>();
    }

    public void addPlayers(Player newPlayer){
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

    public void createLeague(Queue<Team> schedule, int leagueId){
        leagues.add(new League(schedule, leagueId));
    }

    public HashMap<Integer, ArrayList<Team>> getLeagueResults(int leagueId){
        for(League league : leagues){
            if( league.getId() == leagueId )
                return league.getWinners();
        }
        return null;
    }

    public ArrayList<Team>  generateLeaderboard(){
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

    public static Game getInstance() {
        return GAME_INSTANCE;
    }

}
