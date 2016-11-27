package fields;
import models.DiceCup;
import models.Player;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tjc on 21/11/16.
 */
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

    public static void removePlayersOwnables (Player player) {
        for (Ownable o : ownedOwnables)
            if (o.getOwner() == player)
                ownedOwnables.remove(o);
    }

    public Player getOwner()
    {
        return this.owner;
    }
}
