package fields;

import models.Player;

/**
 * Created by tjc on 21/11/16.
 */
public class Territory extends Ownable
{
    private int rent;

    /**
     *
     * @param fieldName Name of field
     * @param rent      Rent of field
     * @param price     Price of field
     * @param owner     Owner of field
     */
    public Territory(String fieldName, int rent, int price)
    {
        this.fieldName = fieldName;
        this.rent = rent;
        this.price = price;
        this.owner = null;
    }

    /**
     * Checks if field is owned by some player.
     * @param ownable
     * @return
     */
    public static boolean isOwned(Ownable ownable)
    {
        for (Ownable o : ownedOwnables)
        {
            if (ownable == o)   // Check if field is owned by someone.
                return true;
        }
        return false;
    }

    @Override
    public void purchaseField(Player player)
    {
        if (isOwned(this))              // Checks if field is owned. If it is, exit method.
            return;

        this.ownedOwnables.add(this);       // Adds fleet to list of owned ownables by Player. 'this' refers to the fleet the Player landed on.
        this.owner = player;                                // Sets fields owner to player.
        player.getPlayerAccount().withdraw(this.price);     // Withdraws field price from player account
    }


    @Override
    public int getRent() {
        return this.rent;
    }

    @Override
    public void landOnField(Player player)
    {

    }
}
