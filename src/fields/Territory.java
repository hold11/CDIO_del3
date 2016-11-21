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
    public Territory(String fieldName, int rent, int price, Player owner)
    {
        this.fieldName = fieldName;
        this.rent = rent;
        this.price = price;
        this.owner = owner;
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
