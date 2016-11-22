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
    public void purchaseField(Player player) {

    }

    @Override
    public int getRent() {
        return 0;
    }

    @Override
    public void landOnField(Player player) {

    }
}
