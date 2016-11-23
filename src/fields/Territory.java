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
     */
    public Territory(String fieldName, int rent, int price)
    {
        this.fieldName = fieldName;
        this.rent = rent;
        this.price = price;
        this.owner = null;
    }

    /**
     * getRent
     * @return
     */
    @Override
    public int getRent() {
        return this.rent;
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
            player.getPlayerAccount().withdraw(this.rent);
        }
    }
}
