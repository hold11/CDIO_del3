package fields;

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

import models.Player;
import models.DiceCup;

public class LaborCamp extends Ownable
{
    private int baseRent;

    public LaborCamp(String fieldName, int price)
    {
        this.fieldName = fieldName;
        this.baseRent = 0;
        this.price = price;
        this.owner = null;      // owner explicitly set to null to begin with.
    }

    @Override
    public int getRent(DiceCup diceCup)
    {
        int totalResult = 0;
        for (int result : diceCup.getResults())     // Saves total value of the rolled dice in totalResult
            totalResult += result;
        return totalResult * 100;       // Amount to pay when landing on LaborCamp field.
    }

    @Override
    public int getRent()
    {
        throw new IllegalArgumentException("Instead of using getRent(), use getRent(DiceCup).");
    }

    /**
     * landOnField. When player lands on field, if field is owned by other player withdraw rent.
     * @param player
     */
    @Override
    public void landOnField(Player player)
    {
        if (this.isOwned() && this.owner != player)      // If field is owned by other player, withdraw rent.
        {
            player.getPlayerAccount().withdraw(this.getRent(player.getDiceCup()));
            this.getOwner().getPlayerAccount().deposit(this.getRent(player.getDiceCup()));
        }
    }
}
