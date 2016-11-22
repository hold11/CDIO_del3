package fields;
import models.Player;

/**
 * Created by tjc on 21/11/16.
 */
public abstract class Field
{
    protected String fieldName;
    public abstract void landOnField(Player player);
}
