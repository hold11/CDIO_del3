/*
           ,                                             |
          /#\         _         _     _    ___   ___     | Projekt: Landlordopoly - CDIO_del3
         /###\       | |__   _ | | __| |  /_  | /_  |    | Version: v1.2.2
        /#####\      | '_ \ / \| |/ _  |    | |   | |    |
       /##,-,##\     | | | | O | | ( | |   _| |_ _| |_   | Anders Wiberg Olsen (s165241), Emil Johan Høg (s152282),
      /##(   )##\    |_| |_|\_/|_|\__,_|  |_____|_____|  | Iman Chelhi (s165228), Troels Just Christoffersen (s120052)
     /#.--   --.#\                                       | Sebastian Tibor Bakonyvári (s145918), Valentin Leon Christensen (s152735)
    /`           ´\                                      |
 */

import models.*;
import fields.Ownable;
import strings.Lang;

public class Main
{
    private static GameGUI gui;
    public static void main(String[] args)
    {
        Lang.setLanguage(args);
        gui = new GameGUI();
//        Player p1 = new Player();
//        Player p2 = new Player();

        GameLogic game = new GameLogic();
//        GameGUI gui = new GameGUI();
        GameBoard board = new GameBoard();

        Player p1 = new Player(new TestDiceCup());
        Player p2 = new Player(new TestDiceCup());

        scriptedGame(5, 4, p1);
        scriptedGame(4, 5, p2);

//        while (true) {
//            gui.playerRoll(game.getCurrentPlayer());
//            game.playTurn(game.getCurrentPlayer());
//            gui.moveMovers(game.getCurrentPlayer());
//                if (game.purchaseField(game.getCurrentPlayer())) {
//                    if (gui.getPlayerPurchaseChoice(game.getCurrentPlayer())) {
//                        ((Ownable) board.getFields()[game.getCurrentPlayer().getCurrentField() - 1]).purchaseField(game.getCurrentPlayer());
//                    }
//                }
//            gui.updateBalance(game.getCurrentPlayer());
//            //gui.removeBankruptPlayer(game.getCurrentPlayer());
//            game.checkBankruptcy(game.getCurrentPlayer());
//
//            if (game.hasWon(game.getCurrentPlayer())) {
//                System.out.println("\n------------------------------\n\n");
//                System.out.println(Player.getPlayersList().get(0).getPlayerName() + " has won the game. Balance: " + Player.getPlayersList().get(0).getPlayerAccount().getBalance());
//                return;
//            }
//            game.nextPlayer();
//        }
    }

    public static void scriptedGame(int d1, int d2, Player player) {
        Player.reset();
        Ownable.reset();

//        Player p1 = new Player(new TestDiceCup());
//        Player p2 = new Player(new TestDiceCup());
        GameLogic game = new GameLogic();
        GameBoard board = new GameBoard();

        int[] diceResults = new int[2];

            diceResults[0] = d1; diceResults[1] = d2;
            guiPlayerRoll(player, diceResults);
            game.playTurn(player);
//            gui.moveMovers(p1);

            if (game.purchaseField(player))
                if (gui.getPlayerPurchaseChoice(player))
                    ((Ownable) board.getFields()[player.getCurrentField() - 1]).purchaseField(player);
            gui.updateBalance(player);
            game.checkBankruptcy(player);

            if (game.hasWon(player)) {
                System.out.println(Player.getPlayersList().get(0).getPlayerName() + " has won the bame.");
                return;
            }
    }

    public static void guiPlayerRoll(Player player, int[] results) {
        GUI.GUI.getUserButtonPressed(player.getPlayerName() + "! Roll for adventure and glory!", "Roll!");
        ((TestDiceCup) player.getDiceCup()).roll(results);
        GUI.GUI.setDice(player.getDiceCup().getResultArr()[0], player.getDiceCup().getResultArr()[1]);
    }
}