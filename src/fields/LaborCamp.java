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

    @Override
    public void purchaseField(Player player)
    {

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
