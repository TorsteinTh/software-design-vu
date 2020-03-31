package models;

public class Player {

    private String name;
    private PlayerType type;

    public Player(String name, /*int score,*/ PlayerType type){
        this.name = name;
        this.type = type;
    }

    public PlayerType getType() {return type;}

    public String getName() { return name; }
}
