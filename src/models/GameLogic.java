package models;

import java.util.Collection;

/**
 * Created by tjc on 23/11/16.
 */
public class GameLogic
{
    private DiceCup diceCup;
    private int playerTurn = 1;
    private Collection<Player> players = Player.getPlayersList();

    public GameLogic()
    {
        DiceCup = new diceCup();    // Creates the default dicecup with 2 dice with 6 sides.

    }

    /**
     * playTurn
     */
    public void playTurn(Player)
    {

    }

    /**
     * hasWon checks if player has won.
     * @return
     */
    public boolean hasWon(Player)
    {

    }

    /**
     * nextPlayer
     */
    public void nextPlayer()
    {

    }

    /**
     * getPlayerTurn
     * @return
     */
    public int getPlayerTurn()
    {

    }

    /**
     * getCurrentPlayer
     * @return
     */
    public Player getCurrentPlayer()
    {

    }

    /**
     * getDiceCup
     * @return
     */
    public DiceCup getDiceCup()
    {

    }

    /**
     * getTotalEyes returns the total number of eyes of the rolled dice.
     * @return
     */
    public int getTotalEyes(DiceCup)
    {

    }
}
