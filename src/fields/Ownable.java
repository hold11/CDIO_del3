package fields;
import models.Player;

/**
 * Created by tjc on 21/11/16.
 */
public abstract class Ownable extends Field
{
    protected int price;
    protected Player owner;
    public abstract int getRent();
    public abstract void purchaseField(Player player);

}
