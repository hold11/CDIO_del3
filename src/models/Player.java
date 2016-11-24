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
import fields.Field;

/**
 * This class is the player class.
 * @version 1.4
 */
public class Player
{
    private int playerID;
    private String playerName;
    private BankAccount playerAccount;
    private Field currentField;
    private final int STARTING_BALANCE = 30000;

    private static int nextPlayerID = 1; // This variable is used to specify the next ID for the next player that gets constructed
    private static List<Player> players = new ArrayList<Player>();

    public Player()
    {
        this.playerName = String.format("models.Player %s", nextPlayerID);
        this.playerID = nextPlayerID;

        this.playerAccount = new BankAccount(STARTING_BALANCE);
        nextPlayerID++;
        players.add(this);
    }

    public Player(String playerName)
    {
        this.playerName = playerName;
        this.playerID = nextPlayerID;

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

    public Field getCurrentField()
    {
        return this.currentField;
    }

    public void setCurrentField(Field f)
    {
        this.currentField = f;
    }

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
        players.remove(player);
    }

    public static void reset()
    {
        nextPlayerID = 1;
        players.clear();
    }
}
