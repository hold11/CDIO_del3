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

    /**
     * Checks if the player purchasing a fleet already owns a fleet,
     * and sets multiplier to ownedFleetCount.
     * @param player
     */
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

    @Override
    public int getRent() {
        return BASERENT * (int) Math.pow(2, multiplier);
    }

    @Override
    public void landOnField(Player player) {

    }
}
