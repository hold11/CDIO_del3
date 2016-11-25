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
import models.GameLogic;
import models.Player;
import strings.Lang;

public class Main
{
    public static void main(String[] args)
    {
        Player p1 = new Player();
        Player p2 = new Player();
        GameLogic game = new GameLogic();
        GameGUI g = new GameGUI();


        for (int i = 0; i < 1000; i++) {
            game.playTurn(game.getCurrentPlayer());
            game.purchaseField(game.getCurrentPlayer());
            game.nextPlayer();

            if (game.hasWon(game.getCurrentPlayer()))
                return;
        }
        System.out.println("This works.");
    }
}
