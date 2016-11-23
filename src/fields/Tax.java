package fields;

import models.Player;

/**
 * Created by tjc on 21/11/16.
 */
public class Tax extends Field
{
    private int taxAmount;
    private double taxRate = -1;       // should be 10% of total assets.

    public Tax(String fieldName, int taxAmount)
    {
        this.fieldName = fieldName;
        this.taxAmount = taxAmount;
    }

    public Tax(String fieldName, int taxAmount, double taxRate)
    {
        this.fieldName = fieldName;
        this.taxAmount = taxAmount;
        this.taxRate = taxRate;
    }

    @Override
    public void landOnField(Player player)
    {
        if (this.taxRate == -1)
        {
            player.getPlayerAccount().withdraw(this.taxAmount);
        }
        else
        {
           if (player.getPlayerAccount().getBalance() * this.taxRate > this.taxAmount)
           {
               player.getPlayerAccount().withdraw(this.taxAmount);
           }
           else
           {
               player.getPlayerAccount().withdraw((int) Math.round(player.getPlayerAccount().getBalance() * this.taxRate));
           }
        }
    }
}
