package fields;

/*
           ,                                             |
          /#\         _         _     _    ___   ___     | Projekt: Landlordopoly - CDIO_del3
         /###\       | |__   _ | | __| |  /_  | /_  |    | Version: v0.2.0
        /#####\      | '_ \ / \| |/ _  |    | |   | |    |
       /##,-,##\     | | | | O | | ( | |   _| |_ _| |_   | Anders Wiberg Olsen (s165241), Emil Johan Høg (s152282),
      /##(   )##\    |_| |_|\_/|_|\__,_|  |_____|_____|  | Iman Chelhi (s165228), Troels Just Christoffersen (s120052)
     /#.--   --.#\                                       | Sebastian Tibor Bakonyvári (s145918), Valentin Leon Christensen (s152735)
    /`           ´\                                      |
 */

import models.Player;

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
