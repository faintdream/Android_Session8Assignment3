package bank;      // this class also part of bank package

import java.util.Scanner;                   // here we import scanner, logger and level classes
import java.util.logging.Level;
import java.util.logging.Logger;

public class FarjiBank extends Bank {

    Scanner input = new Scanner(System.in);
    int balance;                                    // balance variable to keep track of balance

    void deposit() {                                // method to handle deposit activity

        deposit = 2;                                // default deposit amount
        System.out.print(" Deposit Amount " + deposit + " ");
        balance = balance + deposit;                // adding deposit to balance
    }

    void withdrawal() {                                     // method to handle withdraw activity
        withdraw = 4;                                       // default withdraw amount
        System.out.print(" Withdrawal Amount " + withdraw + " ");
        if (!(withdraw > balance)) {                       // check whether withdraw bigger then balance amount 
            balance = balance - withdraw;
        } else {
            System.out.println("Cannot withdraw more than balance !");
        }

    }

    @Override
    public void run() {            // overriding run method from thread class
        balance = 10000;                        // this is non synchronized which means threads access this method at will
        // no locks, eventually causing balance to be incorrect
        for (int i = 0; i < 2; i++) {
            System.out.print(" Thread Name " + Thread.currentThread().getId() + " "); // display running  thread id
            withdrawal();                                                             // calling withdraw
            deposit();                                                                // calling deposit

            System.out.println(" balance " + this.balance + " ");                       // output balance

            try {
                Thread.sleep(500);                                                      //putting thread to sleep

            } catch (InterruptedException ex) {
                Logger.getLogger(FarjiBank.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}

