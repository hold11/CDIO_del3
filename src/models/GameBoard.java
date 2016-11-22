package models;/*
           ,                                             |
          /#\         _         _     _    ___   ___     | Projekt: Landlordopoly - CDIO_del3
         /###\       | |__   _ | | __| |  /_  | /_  |    |
        /#####\      | '_ \ / \| |/ _  |    | |   | |    |
       /##,-,##\     | | | | O | | ( | |   _| |_ _| |_   | Anders Wiberg Olsen (s165241), Emil Johan Høg (s152282),
      /##(   )##\    |_| |_|\_/|_|\__,_|  |_____|_____|  | Iman Chelhi (s165228), Troels Just Christoffersen (s120052)
     /#.--   --.#\                                       | Sebastian Tibor Bakonyvári (s145918), Valentin Leon Christensen (s152735)
    /`           ´\                                      |
 */

import java.lang.reflect.Array;
import fields.*;

/**
 * This Class creates 21 game fields.
 */

public class GameBoard
{
    private Field[] fields = new Field[21];    //Initializes String array containing 21 elements.

    public void fieldsList()
    {
        fields[0] = new Territory("Tribe Encampment", 100, 1000);   // (fieldName, rent, price)
        fields[1] = new Territory("Crater", 300, 1500);
        fields[2] = new Territory("Mountain", 500, 2000);
        fields[3] = new Territory("Cold Desert", 700, 3000);
        fields[4] = new Territory("Black Cave", 1000, 4000);
        fields[5] = new Territory("The Werewall", 1300, 4300);
        fields[6] = new Territory("Mountain Village", 1600, 4750);
        fields[7] = new Territory("South Citadel", 2000, 5000);
        fields[8] = new Territory("Palace Gates", 2600, 5500);
        fields[9] = new Territory("Tower", 3200, 6000);
        fields[10] = new Territory("Castle", 4000, 8000);
        fields[11] = new Refuge("Walled City", 5000);               // (fieldName, receive)
        fields[12] = new Refuge("Monastery", 500);
        fields[13] = new LaborCamp("Huts in the Mountain", 2500);   // (fieldName, price)
        fields[14] = new LaborCamp("The Pit", 2500);
        fields[15] = new Tax("Gold Mine", 2000);                    // Pay 2000
        fields[16] = new Tax("Caravan", 4000, 0.1);                 // Pay 4000 or 10% of total assets
        fields[17] = new Fleet("Second Sail");                      // Pay 500-4000
        fields[18] = new Fleet("Sea Grover");                       // Pay 500-4000
        fields[19] = new Fleet("The Buccaneers");                   // Pay 500-4000
        fields[20] = new Fleet("Privateer Armada");                 // Pay 500-4000
    }
}
