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

import java.lang.reflect.Array;

/**
 * This Class creates 21 game fields.
 */

public class GameBoard
{
    private String[] fields = new String[20];    //Initializes String array containing 21 elements.

    public void fieldsList()
    {
        fields[0] = "Tribe Encampment";
        fields[1] = "Crater";
        fields[2] = "Mountain";
        fields[3] = "Cold Desert";
        fields[4] = "Black Cave";
        fields[5] = "The Werewall";
        fields[6] = "Mountain Village";
        fields[7] = "South Citadel";
        fields[8] = "Palace Gates";
        fields[9] = "Tower";
        fields[10] = "Castle";
        fields[11] = "Walled City";
        fields[12] = "Monastery";
        fields[13] = "Huts in the Mountain";
        fields[14] = "The Pit";
        fields[15] = "Gold Mine";
        fields[16] = "Caravan";
        fields[17] = "Second Sail";
        fields[18] = "Sea Grover";
        fields[19] = "The Buccaneers";
        fields[20] = "Privateer Armada";
    }
}
