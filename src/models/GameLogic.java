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

import fields.LaborCamp;
import fields.Ownable;

import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by tjc on 23/11/16.
 */
public class GameLogic
{
    private int playerTurn = 1;
    private Collection<Player> players;
    private GameBoard board;

    public GameLogic()
    {
        board = new GameBoard();
        players = Player.getPlayersList();
    }

    public void playTurn(Player currentPlayer)
    {
        if (hasWon(currentPlayer))
            return;

        System.out.println("--------------- " + currentPlayer.getPlayerName() + " ---------------");

        currentPlayer.getDiceCup().roll();

        // TODO: Remove below, just for testing purposes
        System.out.println(currentPlayer.getPlayerName() + "'s turn. Current balance: " + currentPlayer.getPlayerAccount().getBalance());

        System.out.println(currentPlayer.getPlayerName() + " rolled " + currentPlayer.getDiceCup().getResultArr()[0] + " and " + currentPlayer.getDiceCup().getResultArr()[1] + " (" + currentPlayer.getDiceCup().getTotalEyes() + ").");
        // TODO: Remove above, just for testing purposes

        currentPlayer.moveCurrentField(currentPlayer.getDiceCup().getTotalEyes()); // Moves the player's currentFieldID to the next field based on the rolled dice
        board.getFields()[currentPlayer.getCurrentField() - 1].landOnField(currentPlayer); // - 1 to make sure you can land on index 0, but not 21 - otherwise just calls the landOnField method for the player

        // TODO: Remove below, just for testing purposes
        System.out.println(currentPlayer.getPlayerName() + " landed on " + board.getFields()[(currentPlayer.getCurrentField() - 1)]);
        System.out.println(currentPlayer.getPlayerName() + "'s balance is now " + currentPlayer.getPlayerAccount().getBalance());
        // TODO: Remove above, just for testing purposes
    }

    public void purchaseField(Player currentPlayer) {

        // TODO: Remove below, just for testing purposes
        if (board.getFields()[currentPlayer.getCurrentField() - 1] instanceof Ownable) {
            Ownable ownedField = (Ownable) board.getFields()[currentPlayer.getCurrentField() - 1];

            if (!ownedField.isOwned() && ownedField.getPrice() <= currentPlayer.getPlayerAccount().getBalance()) { // Field isn't owned by anyone
                String answer;
                System.out.println("\nCurrent Balance: " + currentPlayer.getPlayerAccount().getBalance() + " | Plot Price: " + ownedField.getPrice());
                System.out.print("This plot is not owned, do you want to buy? ");
                Scanner in = new Scanner(System.in);
                answer = in.nextLine().toLowerCase();
                if (answer.equals("y") || answer.equals("yes")) {
                    ownedField.purchaseField(currentPlayer);
                    System.out.println(currentPlayer.getPlayerName() + " just bought " + ownedField + " for " + ownedField.getPrice() + ".");
                    System.out.println(currentPlayer.getPlayerName() + "'s balance is now " + currentPlayer.getPlayerAccount().getBalance() + ".");
                }
            } else if (ownedField.isOwned()){ // Field is owned by someone
                System.out.println(ownedField + " is currently owned by " + ownedField.getOwner() + ".");
                try {
                    System.out.println("The rent is " + ownedField.getRent() + ". " + currentPlayer.getPlayerName() + "'s balance is now " + currentPlayer.getPlayerAccount().getBalance() + ".");
                    System.out.println(ownedField.getOwner().getPlayerName() + " recieved " + ownedField.getRent() + " from " + currentPlayer.getPlayerName() + ". " + ownedField.getOwner().getPlayerName() + "'s balance is now " + ownedField.getOwner().getPlayerAccount().getBalance());
                } catch (IllegalArgumentException ex) {
                    System.out.println("The rent is " + ownedField.getRent(currentPlayer.getDiceCup()) + ". " + currentPlayer.getPlayerName() + "'s balance is now " + currentPlayer.getPlayerAccount().getBalance() + ".");
                }

//                if (board.getFields()[currentPlayer.getCurrentField()] instanceof LaborCamp)
//                    System.out.println("The rent is " + ownedField.getRent(currentPlayer.getDiceCup()) + ". " + currentPlayer.getPlayerName() + "'s balance is now " + currentPlayer.getPlayerAccount().getBalance() + ".");
//                else
//                    System.out.println("The rent is " + ownedField.getRent() + ". " + currentPlayer.getPlayerName() + "'s balance is now " + currentPlayer.getPlayerAccount().getBalance() + ".");
            } else { // Field isn't owned by anyone, but the player cannot afford the field
                System.out.println(ownedField + " is not owned by anyone, however you cannot afford this field (Current Balance: " + currentPlayer.getPlayerAccount().getBalance() + " | Field Price: " + ownedField.getPrice() + ")");
            }
        }
        System.out.println("\n");
    }

    public boolean fieldIsPurchaseable(Player currentPlayer) {
        if (board.getFields()[currentPlayer.getCurrentField() - 1] instanceof Ownable) {
            Ownable ownedField = (Ownable) board.getFields()[currentPlayer.getCurrentField() - 1];

            if (ownedField.isOwned())
            {
                System.out.println(ownedField.getOwner() + " is already owned by " + ownedField.getOwner().getPlayerName());
                return false;
            }
            else
                if (ownedField.getPrice() <= currentPlayer.getPlayerAccount().getBalance())
                    return true;
        }
        else return false;

        return false;
    }

//    public boolean fieldIsPurchaseable(Player currentPlayer) {
//        // TODO: Remove below, just for testing purposes
//        // Check if the current field is ownable
//        if (board.getFields()[currentPlayer.getCurrentField() - 1] instanceof Ownable)
//        {
//            Ownable ownedField = (Ownable) board.getFields()[currentPlayer.getCurrentField()];
//
//            if (!ownedField.isOwned()) { // Field isn't owned by anyone
//                if (ownedField.getPrice() <= currentPlayer.getPlayerAccount().getBalance()) {
//                    // If the field isn't owned, and the player can afford it, ask
//                    // Following is CLI for testing purposes:
//
////                    String answer;
////                    System.out.println("\nCurrent Balance: " + currentPlayer.getPlayerAccount().getBalance() + " | Plot Price: " + ownedField.getPrice());
////                    System.out.print("This plot is not owned, do you want to buy? ");
////                    Scanner in = new Scanner(System.in);
////                    answer = in.nextLine().toLowerCase();
//
////                    if (answer.equals("y") || answer.equals("yes")) {
////                        ownedField.purchaseField(currentPlayer);
////                        System.out.println(currentPlayer.getPlayerName() + " just bought " + ownedField + " for " + ownedField.getPrice() + ".");
////                        System.out.println(currentPlayer.getPlayerName() + "'s balance is now " + currentPlayer.getPlayerAccount().getBalance() + ".");
////                    }
//                    return true;
//                } else return false;
//            } else return false;
//            // Land on field, isn't needed here.
////            else { // Field is owned by someone
////                System.out.println(ownedField + " is currently owned by " + ownedField.getOwner() + ".");
////                try
////                {
////                    System.out.println("The rent is " + ownedField.getRent() + ". " + currentPlayer.getPlayerName() + "'s balance is now " + currentPlayer.getPlayerAccount().getBalance() + ".");
////                }
////                catch (IllegalArgumentException ex)
////                {
////                    System.out.println("The rent is " + ownedField.getRent(currentPlayer.getDiceCup()) + ". " + currentPlayer.getPlayerName() + "'s balance is now " + currentPlayer.getPlayerAccount().getBalance() + ".");
////                }
////            }
////
////            System.out.println("\n");
//        } else return false;
//
//        // TODO: Remove above, just for testing purposes
//    }

    /**
     * hasWon checks if player has won.
     * @return
     */
    public boolean hasWon(Player player)
    {
        if (Player.getPlayersList().size() == 1 && Player.getPlayersList().get(0) == player)
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
