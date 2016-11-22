package fields;

import models.Player;

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
    public int getRent() {
        return 0;
    }

    @Override
    public void landOnField(Player player)
    {

    }
}
