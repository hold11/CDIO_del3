package fields;
import models.Player;

/**
 * Created by tjc on 21/11/16.
 */
public abstract class Ownable extends Field
{
    private int price;
    private Player owner;
    public abstract int getRent();
}
