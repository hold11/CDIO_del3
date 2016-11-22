package fields;

import models.Player;
import models.DiceCup;

/**
 * Created by tjc on 21/11/16.
 */
public class LaborCamp extends Ownable
{
    private int baseRent;

    public LaborCamp(String fieldName, int price)
    {
        this.fieldName = fieldName;
        this.baseRent = 0;
        this.price = price;
        this.owner = null;  // TODO: Do this need to be here?
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
        this.owner = player;                                // Sets fields owner to player.
        player.getPlayerAccount().withdraw(this.price);     // Withdraws field price from player account
    }

    @Override
    public int getRent(DiceCup diceCup)
    {
        int totalResult = 0;
        for (int result : diceCup.getResults())     // Saves total value of the rolled dice in totalResult
            totalResult += result;
        return totalResult * 100;       // Amount to pay when landing on LaborCamp field.
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
    }}
}
