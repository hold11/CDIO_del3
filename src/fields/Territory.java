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

public class Territory extends Ownable
{
    private int rent;

    /**
     *
     * @param fieldName Name of field
     * @param rent      Rent of field
     * @param price     Price of field
     */
    public Territory(String fieldName, int rent, int price)
    {
        this.fieldName = fieldName;
        this.rent = rent;
        this.price = price;
        this.owner = null;
    }

    /**
     * getRent
     * @return
     */
    @Override
    public int getRent() {
        return this.rent;
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
            player.getPlayerAccount().withdraw(this.getRent());
            this.getOwner().getPlayerAccount().deposit(this.getRent());
        }
    }
}
