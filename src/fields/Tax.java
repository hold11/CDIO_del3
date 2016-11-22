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
        this.taxRate = taxRate; // TODO: DO we need to delete this.
    }

    public Tax(String fieldName, int taxAmount, double taxRate)
    {
        this.fieldName = fieldName;
        this.taxAmount = taxAmount;
        this.taxRate = taxRate;
    }

    @Override
    public void landOnField(Player player) {

    }
}
