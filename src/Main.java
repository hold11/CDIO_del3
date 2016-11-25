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

import fields.Ownable;
import fields.Territory;
import models.GameBoard;
import models.GameLogic;
import models.Player;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Player p1 = new Player();
        Player p2 = new Player();
        GameLogic game = new GameLogic();
        GameBoard board = new GameBoard();

        for (int i = 0; i < 1000; i++) {
            game.playTurn(game.getCurrentPlayer());

            game.purchaseField(game.getCurrentPlayer());
//            if (game.fieldIsPurchaseable(game.getCurrentPlayer())) {
//                Scanner in = new Scanner(System.in);
//                System.out.print("Buy? ");
//                String msg = in.nextLine();
//
//                if (msg.equals("yes") || msg.equals("y")) {
//                    System.out.println("Want to buy.");
//                    ((Ownable) board.getFields()[game.getCurrentPlayer().getCurrentField() - 1]).purchaseField(game.getCurrentPlayer());
//
//                } else
//                    System.out.println("Don't want to buy.");
//            }

            if (game.hasWon(game.getCurrentPlayer()))
                return;

            game.nextPlayer();
        }


//        for (int i = 0; i < 1000; i++) {
//            game.playTurn(game.getCurrentPlayer());         // Player Turn
//
//            if(game.fieldIsPurchaseable(game.getCurrentPlayer()))      // Can buy?
//            {
//                Scanner in = new Scanner(System.in);
//                System.out.println("Want to buy? ");
//                String msg = in.nextLine().toLowerCase();
//                if (msg.equals("yes"))
//                    ((Ownable) board.getFields()[game.getCurrentPlayer().getCurrentField() ]).purchaseField(game.getCurrentPlayer());  // BUY!!
//            }
//
//            game.nextPlayer();                              // Next player turn
//
//            if (game.hasWon(game.getCurrentPlayer()))       // ... unless someone has won the game
//                return;
//        }
//        System.out.println("This works.");
    }

    public static void testGame() {
        Player p1 = new Player();
        Player p2 = new Player();
        GameLogic game = new GameLogic();
        GameBoard board = new GameBoard();

        // Player 1 lands on field 2
        ((Territory) board.getFields()[1]).landOnField(p1);

        p1.setCurrentField(1);
//        if (game.fieldIsPurchaseable(p1))
//            ((Ownable) board.getFields()[game])
    }
}
