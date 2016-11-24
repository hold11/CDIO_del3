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

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by tjc on 23/11/16.
 */
public class GameLogic
{
    private DiceCup diceCup;
    private int playerTurn = 1;
    private Collection<Player> players;
    private GameBoard board;

    public GameLogic()
    {
        diceCup = new DiceCup();    // Creates the default diceCup with 2 dice with 6 sides.
        board = new GameBoard();
        players = Player.getPlayersList();
    }

    /**
     * playTurn
     */
    public void playTurn(Player currentPlayer)
    {
        // TODO: This is method from CDIO_2, has to get rewritten.
        if (hasWon(currentPlayer)) {
            return;
        }
        diceCup.roll();

        // TODO: Remove below, just for testing purposes
        System.out.println(currentPlayer.getPlayerName() + "'s turn. Current balance: " + currentPlayer.getPlayerAccount().getBalance());
        int[] results = new int[2];
        int i = 0;
        for (Iterator<Integer> iter = diceCup.getResults().iterator(); iter.hasNext(); i++)
            results[i] = iter.next();
        System.out.println(currentPlayer.getPlayerName() + " rolled " + results[0] + " and " + results[1] + " (" + getTotalEyes(diceCup) + ").");
        // TODO: Remove above, just for testing purposes

        currentPlayer.moveCurrentField(getTotalEyes(diceCup));
        board.getFields()[currentPlayer.getCurrentField() - 1].landOnField(currentPlayer); // - 1 to make sure you can land on index 0, but not 21
//        currentPlayer.getCurrentField().landOnField(currentPlayer); // old from CDIO_del2

        // TODO: Remove below, just for testing purposes
        System.out.println(currentPlayer.getPlayerName() + " landed on " + (currentPlayer.getCurrentField() - 1));
        System.out.println(currentPlayer.getPlayerName() + "'s balance is now " + currentPlayer.getPlayerAccount().getBalance());
        System.out.println("\n");
        // TODO: Remove above, just for testing purposes

        // Below is from CDIO_del2:
//
//
//        getCurrentPlayer().moveCurrentField(Field.values()[getTotalEyes(diceCup)-2]);
//        if (currentPlayer.getCurrentField().getScoreValue() < 0) {
//            currentPlayer.getPlayerAccount().withdraw(currentPlayer.getCurrentField().getScoreValue());
//        } else {
//            currentPlayer.getPlayerAccount().deposit(currentPlayer.getCurrentField().getScoreValue());
//        }
    }

    /**
     * hasWon checks if player has won.
     * @return
     */
    public boolean hasWon(Player player)
    {
        if (Player.getPlayersList().size() == 1 && Player.getPlayersList().get(0) == player) // TODO: Test if this actually works
            return true;
        else
            return false;
    }

    /**
     * nextPlayer
     */
    public void nextPlayer()
    {
        if (playerTurn < players.size())
            playerTurn++;
        else
            playerTurn = 1;
    }

    /**
     * getPlayerTurn
     * @return
     */
    public int getPlayerTurn()
    {
        return playerTurn;
    }

    /**
     * getCurrentPlayer
     * @return
     */
    public Player getCurrentPlayer()
    {
        return Player.findPlayer(playerTurn);
    }

    /**
     * getDiceCup
     * @return
     */
    public DiceCup getDiceCup()
    {
        return diceCup;
    }

    /**
     * getTotalEyes returns the total number of eyes of the rolled dice.
     * @return
     */
    public int getTotalEyes(DiceCup diceCup)
    {
        int total = 0;

        for (int i: diceCup.getResults())
            total += i;
        return total;
    }

    /**
     * checkBankruptcy
     * Check if player has gotten bankrupt by the end of his turn, and remove him from list of players
     * or mark player as bankrupt so that player will not get any more turns for the rest of the game.
     * @param player
     */
    private void checkBankruptcy(Player player)
    {
        if (player.getPlayerAccount().getBalance() == 0)
            player.removePlayer(player);
    }
}
