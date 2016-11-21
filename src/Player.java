/*
           ,                                             |
          /#\         _         _     _    ___   ___     | Projekt: Black Darkness 3 - CDIO_del2
         /###\       | |__   _ | | __| |  /_  | /_  |    | Version: v1.0.0
        /#####\      | '_ \ / \| |/ _  |    | |   | |    |
       /##,-,##\     | | | | O | | ( | |   _| |_ _| |_   | Anders Wiberg Olsen (s165241), Emil Johan Høg (s152282),
      /##(   )##\    |_| |_|\_/|_|\__,_|  |_____|_____|  | Iman Chelhi (s165228), Troels Just Christoffersen (s120052)
     /#.--   --.#\                                       | Sebastian Tibor Bakonyvári (s145918), Valentin Leon Christensen (s152735)
    /`           ´\                                      |
 */

import java.util.ArrayList;
import java.util.List;

/**
 * This class is the player class.
 * @version 1.3.7
 */
public class Player {
    private int playerID;
    private String playerName;
    private BankAccount playerAccount;
    private Field currentField;
    private final int STARTING_BALANCE = 1000;

    private static int playerCount = 1;
    private static List<Player> players = new ArrayList<Player>();

    public Player() {
        this.playerName = String.format("Player %s", playerCount);
        this.playerID = playerCount;

        this.playerAccount = new BankAccount(STARTING_BALANCE);

        playerCount++;

        players.add(this);
    }

    public Player(String playerName) {
        this.playerName = playerName;
        this.playerID = playerCount;

        this.playerAccount = new BankAccount(STARTING_BALANCE);

        playerCount++;

        players.add(this);
    }

    public BankAccount getPlayerAccount() {
        return playerAccount;
    }

    public int getPlayerID() {
        return playerID;
    }

    public String getPlayerName() {
        return playerName;
    }

    public Field getCurrentField() {
        return this.currentField;
    }

    public void setCurrentField(Field f) {
        this.currentField = f;
    }

    public static Player findPlayer(int playerID) {
        for (int i = 0; i < players.size(); i++)
            if (players.get(i).getPlayerID() == playerID)
                return players.get(i);

        throw new IndexOutOfBoundsException("Could not find a player the following ID: " + playerID);
    }

    public static List<Player> getPlayersList() {
        return players;
    }

    public static void reset() {
        playerCount = 1;
        players.clear();
    }
}
