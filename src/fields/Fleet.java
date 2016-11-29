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

import java.util.ArrayList;
import java.util.List;

public class Fleet extends Ownable
{

    private final int BASERENT = 500;   // 500*2^multiplier
    private int multiplier = 0;

    private static List<Fleet> ownedFleets = new ArrayList<>();

    public Fleet(String fieldName)
    {
        this.fieldName = fieldName;
        this.price = 4000;
        this.owner = null;
    }

    /**
     * Checks if the player purchasing a fleet already owns a fleet,
     * and sets multiplier to ownedFleetCount.
     * @param player
     */
    @Override
    public void purchaseField(Player player)
    {
        if (this.isOwned())              // Checks if field is owned. If it is, exit method.
            return;

        int ownedFleetCount = 0;
        this.ownedOwnables.add(this);       // Adds fleet to list of owned ownables by Player. 'this' refers to the fleet the Player landed on.
        for (Ownable o : ownedOwnables)     // Sets ownedFleetCount to total number of Fleets that a specific player owns.
            if (o.owner == player && o instanceof Fleet)
                ownedFleetCount++;

        for (Ownable o : ownedOwnables)     // Sets multiplier to ownedFleetCount for each fleet that a specific player owns.
            if (o.owner == player && o instanceof Fleet)
                ((Fleet) o).setMultiplier(ownedFleetCount);     // Sets multiplier for the fleet that the player already owns.

        this.multiplier = ownedFleetCount;                  // Sets multiplier to ownedFleetCount
        this.owner = player;                                // Sets fields owner to player.
        player.getPlayerAccount().withdraw(this.price);     // Withdraws field price from player account
    }

    /**
     * setMultiplier to ownedFleetCount = number of Fleets owned by player.
     * @param ownedFleetCount int
     */
    public void setMultiplier(int ownedFleetCount)
    {
        this.multiplier = ownedFleetCount;
    }

    /**
     * getRent returns rent amount depending on number of Fleet fields tha the owner owns.
     * @return int
     */
    @Override
    public int getRent()
    {
        if (this.isOwned())
            return BASERENT * (int) Math.pow(2, multiplier);    // Rent if field is owned
        else
            return 0;       // Rent is 0 if field is not owned.
    }

    /**
     * landOnField. When player lands on field, if field is owned by other player withdraw rent.
     * @param player Player
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
