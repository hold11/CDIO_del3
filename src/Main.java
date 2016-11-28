/*
           ,                                             |
          /#\         _         _     _    ___   ___     | Projekt: Landlordopoly - CDIO_del3
         /###\       | |__   _ | | __| |  /_  | /_  |    | Version: v0.2.0
        /#####\      | '_ \ / \| |/ _  |    | |   | |    |
       /##,-,##\     | | | | O | | ( | |   _| |_ _| |_   | Anders Wiberg Olsen (s165241), Emil Johan Høg (s152282),
      /##(   )##\    |_| |_|\_/|_|\__,_|  |_____|_____|  | Iman Chelhi (s165228), Troels Just Christoffersen (s120052)
     /#.--   --.#\                                       | Sebastian Tibor Bakonyvári (s145918), Valentin Leon Christensen (s152735)
    /`           ´\                                      |
 */

import GUI.GameGUI;
import models.GameBoard;
import models.GameLogic;
import models.Player;

public class Main
{
    public static void main(String[] args)
    {
        Player p1 = new Player();
        Player p2 = new Player();

        GameLogic game = new GameLogic();
        GameGUI gui = new GameGUI();

        // From version v1.2-stable
        while (true) {
            gui.playerRoll(game.getCurrentPlayer());
            game.playTurn(game.getCurrentPlayer());
            game.purchaseField(game.getCurrentPlayer());
            gui.moveMovers(game.getCurrentPlayer());
            gui.updateBalance(game.getCurrentPlayer());
            gui.setOwner(game.getCurrentPlayer());
            gui.removeBankruptPlayer(game.getCurrentPlayer();

            if (game.hasWon(game.getCurrentPlayer())) {
                System.out.println("\n------------------------------\n\n");
                System.out.println(Player.getPlayersList().get(0).getPlayerName() + " has won the game. Balance: " + Player.getPlayersList().get(0).getPlayerAccount().getBalance());
                return;
            }
            game.nextPlayer();
        }
    }
}