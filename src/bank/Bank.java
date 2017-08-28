/*
 * This Program shows deposit and withdraw functionality 
 * for the Online Banking Application(Using synchronized).
 * Also it compares output without using synchronized for 
 * one of the classes
 */
package bank;

import java.util.Scanner;                           // importing scanner class
import static javafx.application.Platform.exit;     // importing class for exit method

public abstract class Bank extends Thread {         // abstract Bank class extending Thread class, since this is
                                                    // a threaded application    
    int deposit;                                    //deposit variable to hold deposits
    int withdraw;                                   // withdraw variable to hold withdraw

    abstract void deposit();                        // abstract method deposit

    abstract void withdrawal();                     // abstract method withdrawal
    
    public static void main(String[] args) {        // main section

        FarjiBank1 objIcici = new FarjiBank1();       // creating object of FarjiBank1 class 
        FarjiBank objFarji = new FarjiBank();       // creating object of FarjiBank class
        Thread t11 = new Thread(objIcici);          // creating object of Thread class , purposed for synchronized execution
        Thread t12 = new Thread(objIcici);          // creating object of Thread class , purposed for synchronized execution 
        Thread t21 = new Thread(objFarji);          // creating object of Thread class , purposed for NONsynchronized execution
        Thread t22 = new Thread(objFarji);          // creating object of Thread class , purposed for NONsynchronized execution
        
        Scanner input = new Scanner(System.in);    //defining scanner object

        System.out.println(" Banking System");          //user
        System.out.println(" Select Operation ");       //  interaction
        System.out.println(" 'S' Savings Account ");    // here 
        System.out.println(" 'E' Exit Application");
        String choice = input.next();                   // securing user input
        choice = choice.toUpperCase();

        switch (choice) {                              //switch evaluation

            case "E":
                exit();                                // exit app 
                break;
            case "S":
                System.out.println("Select Bank");      // user 
                System.out.println(" 1. ICICI");        // interaction
                System.out.println(" 2. Farji");        // here 

                String select = input.next();           // securing user input 
                switch (select) {                       //switch evaluation
                    case "1":                        
                        t11.start();                    // starting t11 object
                        t12.start();                    // starting t12 object 
                        break;

                    case "2":                        
                        t21.start();                    //starting t21 object
                        t22.start();                    // starting t22 object 
                        break;
                    default:
                        System.out.println("wrong choice");     // user output just incase wrong inputs 
                        exit();

                }
                break;
            default:
                System.out.println("wrong choice");              // user output just incase wrong inputs 
                exit();

        }

    }

}
