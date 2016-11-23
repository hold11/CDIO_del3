package fields;

import models.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tjc on 21/11/16.
 */
public class Fleet extends Ownable
{

    private final int BASERENT = 500;   // 500*2^multiplier
    private int multiplier = 0;

    private static List<Fleet> ownedFleets = new ArrayList<>();

    public Fleet(String fieldName)
    {
        this.fieldName = fieldName;
        this.price = 4000;
        this.owner = null; // TODO: Do this need to be here?
    }

    /**
     * Checks if the player purchasing a fleet already owns a fleet,
     * and sets multiplier to ownedFleetCount.
     * @param player
     */
    @Override
    public void purchaseField(Player player)
    {
        if (isOwned(this))              // Checks if field is owned. If it is, exit method.
            return;

        int ownedFleetCount = 0;
        this.ownedOwnables.add(this);       // Adds fleet to list of owned ownables by Player. 'this' refers to the fleet the Player landed on.
        for (Ownable o : ownedOwnables)
        {
            if (o.owner == player)
            {
                if (o instanceof Fleet)
                    ownedFleetCount++;
                multiplier = ownedFleetCount;   // Sets multiplier for the fleet that the player already owns.
            }
        }
        this.multiplier = ownedFleetCount;                  // Sets multiplier to ownedFleetCount
        this.owner = player;                                // Sets fields owner to player.
        player.getPlayerAccount().withdraw(this.price);     // Withdraws field price from player account
    }

    /**
     * getRent returns rent amount depending on number of Fleet fields tha the owner owns.
     * @return int
     */
    @Override
    public int getRent() {
        return BASERENT * (int) Math.pow(2, multiplier);
    }

    /**
     * landOnField. When player lands on field, if field is owned by other player withdraw rent.
     * @param player
     */
    @Override
    public void landOnField(Player player)
    {
        if (isOwned(this) && this.owner != player)      // If field is owned by other player, withdraw rent.
        {
            player.getPlayerAccount().withdraw(this.getRent());
        }
    }
}
