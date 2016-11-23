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
}
