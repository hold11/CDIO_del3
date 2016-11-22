package fields;
import models.Player;

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
    public abstract void purchaseField(Player player);
    protected static List<Ownable> ownedOwnables = new ArrayList<>();
}
