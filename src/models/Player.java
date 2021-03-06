package models;

/*
           ,                                             |
          /#\         _         _     _    ___   ___     | Projekt: Landlordopoly - CDIO_del3
         /###\       | |__   _ | | __| |  /_  | /_  |    |
        /#####\      | '_ \ / \| |/ _  |    | |   | |    |
       /##,-,##\     | | | | O | | ( | |   _| |_ _| |_   | Anders Wiberg Olsen (s165241), Emil Johan Høg (s152282),
      /##(   )##\    |_| |_|\_/|_|\__,_|  |_____|_____|  | Iman Chelhi (s165228), Troels Just Christoffersen (s120052)
     /#.--   --.#\                                       | Sebastian Tibor Bakonyvári (s145918), Valentin Leon Christensen (s152735)
    /`           ´\                                      |
 */
import java.util.ArrayList;
import java.util.List;

import fields.Ownable;

/**
 * This class is the player class.
 * @version 1.4
 */
public class Player
{
    private int playerID;
    private String playerName;
    private BankAccount playerAccount;
    private DiceCup diceCup;
    private int currentField;
    private int previousField;
    private final int STARTING_BALANCE = 30000;

    private static int nextPlayerID = 1; // This variable is used to specify the next ID for the next player that gets constructed
    private static List<Player> players = new ArrayList<Player>();

    public Player()
    {
        this.playerName = String.format("Player %s", nextPlayerID);
        this.playerID = nextPlayerID;
        this.diceCup = new DiceCup();

        this.playerAccount = new BankAccount(STARTING_BALANCE);
        nextPlayerID++;
        players.add(this);

        currentField = 0;
        previousField = 0;
    }

    public Player(DiceCup diceCup)
    {
        this.playerName = String.format("Player %s", nextPlayerID);
        this.playerID = nextPlayerID;
        this.diceCup = diceCup;

        this.playerAccount = new BankAccount(STARTING_BALANCE);
        nextPlayerID++;
        players.add(this);

        currentField = 0;
        previousField = 0;
    }

    public Player(String playerName)
    {
        this.playerName = playerName;
        this.playerID = nextPlayerID;
        this.diceCup = new DiceCup();

        this.playerAccount = new BankAccount(STARTING_BALANCE);

        nextPlayerID++;

        players.add(this);
    }

    public Player(String playerName, DiceCup diceCup)
    {
        this.playerName = playerName;
        this.playerID = nextPlayerID;
        this.diceCup = diceCup;

        this.playerAccount = new BankAccount(STARTING_BALANCE);

        nextPlayerID++;

        players.add(this);
    }

    public BankAccount getPlayerAccount()
    {
        return playerAccount;
    }

    public int getPlayerID()
    {
        return playerID;
    }

    public String getPlayerName()
    {
        return playerName;
    }

    public void moveCurrentField(int diceCount) {
        models.GameBoard board = new models.GameBoard();
        if (this.currentField + diceCount > board.getFields().length)
            this.setCurrentField(diceCount - board.getFields().length + this.currentField);
        else
            this.setCurrentField(this.currentField + diceCount);
    }

    public void setCurrentField(int fieldID) {
            if (this.currentField == 0)
                this.previousField = this.currentField + 1;
            else
                this.previousField = this.currentField;
        this.currentField = fieldID;
    }

    public int getCurrentField() {
        return this.currentField;
    }

    public int getPreviousField() {
        return this.previousField;
    }

    public DiceCup getDiceCup() { return this.diceCup; }

    public static Player findPlayer(int playerID)
    {
        for (int i = 0; i < players.size(); i++)
            if (players.get(i).getPlayerID() == playerID)
                return players.get(i);

        throw new IndexOutOfBoundsException("Could not find a player the following ID: " + playerID);
    }

    public static List<Player> getPlayersList()
    {
        return players;
    }

    public static void removePlayer(Player player)
    {
        Ownable.removeAPlayersOwnables(player);
        players.remove(player);
    }

    @Override
    public String toString() { return this.playerName; }

    public static void reset()
    {
        nextPlayerID = 1;
        players.clear();
    }
}
