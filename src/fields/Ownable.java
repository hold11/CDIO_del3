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

import models.DiceCup;
import models.Player;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Ownable extends Field
{
    protected int price;
    protected Player owner;
    public abstract int getRent();
    public int getRent(DiceCup diceCup) { throw new NotImplementedException(); };   // This one is optional. Specific for LaborCamp to enable payment of 100 x diceroll.
    protected static List<Ownable> ownedOwnables = new ArrayList<>();   // List of fields that are owned by someone.

    /**
     * Checks if field is owned by some player.
     */
    public boolean isOwned()
    {
        for (Ownable o : ownedOwnables)
            if (this == o)   // Check if field is owned by someone.
                return true;
        return false;
    }
    /**
     *  fieldIsPurchaseable assigns player as owner to field, and withdraws field price from player's account.
     * @param player
     */
    public void purchaseField(Player player)
    {
        if (isOwned())              // Checks if field is owned. If it is, exit method.
            return;

        this.ownedOwnables.add(this);       // Adds fleet to list of owned ownables by Player. 'this' refers to the fleet the Player landed on.
        this.owner = player;                                // Sets fields owner to player.
        player.getPlayerAccount().withdraw(this.price);     // Withdraws field price from player account
        System.out.println(this.getOwner() + " just bought " + this.fieldName);
    }

    public static List<Ownable> getPlayersOwnedFields(Player player) {
        List<Ownable> ownables = new ArrayList<>();

        for (Ownable o : ownedOwnables)
            if (o.owner == player)
                ownables.add(o);

        return ownables;
    }

    public int getPrice()
    {
        return this.price;
    }

    /**
     * This method is ONLY used for unit testing
     */
    public static void reset()
    {
        ownedOwnables.clear();
    }

    public static void removeAPlayersOwnables(Player player) {
        for (Ownable o : ownedOwnables)
            if (o.getOwner() == player)
                o.resetOwner();

        for (Iterator<Ownable> oIter = ownedOwnables.iterator(); oIter.hasNext(); )
            if (oIter.next().getOwner() == player)
                oIter.remove();

//        // For some reason, this doesn't work:
//        for (Ownable o : ownedOwnables)
//            if (o.getOwner() == player)
//                ownedOwnables.remove(o);
    }

    /**
     * This method is only used for debugging in the CLI. It prints a list of all owned Ownables
     * @param player
     */
    public static void printOwnedOwnables (Player player) {
        System.out.println("Fields owned by " + player.getPlayerName());
        int ownedOwnablesCount = 0;

        if (ownedOwnables.size() > 0)
            for (Ownable o : ownedOwnables) {
                if (o.owner == player) {
                    System.out.println(" * " + o);
                    ownedOwnablesCount++;
                }
            }

        if (ownedOwnablesCount == 0)
            System.out.println(" * None");
        System.out.println();
    }

    public Player getOwner()
    {
        return this.owner;
    }

    public void resetOwner() { this.owner = null; }
}
