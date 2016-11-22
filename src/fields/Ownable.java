package fields;
import models.DiceCup;
import models.Player;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tjc on 21/11/16.
 */
public abstract class Ownable extends Field
{
    protected int price;
    protected Player owner;
    public abstract int getRent();
    public int getRent(DiceCup diceCup) { throw new NotImplementedException(); };   // This one is optional. Specific for LaborCamp to enable payment of 100 x diceroll.
    public abstract void purchaseField(Player player);
    protected static List<Ownable> ownedOwnables = new ArrayList<>();   // List of fields that are owned by someone.
}
