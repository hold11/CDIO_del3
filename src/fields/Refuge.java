package fields;

import models.Player;

/**
 * Created by tjc on 21/11/16.
 */

public class Refuge extends Field
{
    private int receive;

    public Refuge(String fieldName, int receive)
    {
        this.fieldName = fieldName;
        this.receive = receive;
    }

    @Override
    public void landOnField(Player player)
    {
        player.getPlayerAccount().deposit(this.receive);
    }
}
