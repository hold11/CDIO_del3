/*
           ,                                             |
          /#\         _         _     _    ___   ___     | Projekt: Black Darkness 3 - CDIO_del2
         /###\       | |__   _ | | __| |  /_  | /_  |    | Version: v1.0.0
        /#####\      | '_ \ / \| |/ _  |    | |   | |    |
       /##,-,##\     | | | | O | | ( | |   _| |_ _| |_   | Anders Wiberg Olsen (s165241), Emil Johan Høg (s152282),
      /##(   )##\    |_| |_|\_/|_|\__,_|  |_____|_____|  | Iman Chelhi (s165228), Troels Just Christoffersen (s120052)
     /#.--   --.#\                                       | Sebastian Tibor Bakonyvári (s145918), Valentin Leon Christensen (s152735)
    /`           ´\                                      |
 */

/**
 * This class contains describes the player bankaccount and associated withdraw and deposit methods.
 * @version 1.0.2
 */

public class BankAccount {
    private int balance;
    private int id = 0;
    
    private static int idCount;

    public BankAccount(int balance) {
        this.balance = balance;
        id = idCount;
        idCount++;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int value) {
        if (value > 0)
            this.balance += value;
    }

    public void withdraw(int value) {
        if (value > 0)
            this.balance -= value;
        if (balance < 0){
            balance = 0;
        };
    }
}
