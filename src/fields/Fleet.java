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
    }

    /**
     * Checks if the player purchasing a fleet already owns a fleet,
     * and sets multiplier to ownedFleetCount.
     * @param player
     */
    public void purchaseField(Player player)
    {
        int ownedFleetCount = 0;
        this.ownedFleets.add(this);     // Adds fleet to list of owned fleets by Player. 'this' refers to the fleet the Player landed on.
        for (Fleet f : ownedFleets)
        {
            if (f.owner == player)
            {
                ownedFleetCount++;
                f.setMultiplier(ownedFleetCount);   // Sets multiplier for the fleet that the player already owns.
            }
        }
        this.multiplier = ownedFleetCount;                  // Sets multiplier to ownedFleetCount
        this.owner = player;                                // Sets fields owner to player.
        player.getPlayerAccount().withdraw(this.price);     // Withdraws field price from player account
    }

    public void setMultiplier(int multiplier)       // Setter method - HAHA @ Anders
    {
        this.multiplier = multiplier;
    }

    @Override
    public int getRent() {
        return BASERENT * (int) Math.pow(2, multiplier);
    }

    @Override
    public void landOnField(Player player) {

    }
}
