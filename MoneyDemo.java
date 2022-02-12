import java.io.*;
import java.util.*;
/**
 * Runs terminal program that asks the user for information that will put into or taken out of their credit card details. 
 *
 * @author (Julia Tran)
 * @version (1/20/2022)
 * 
 * Received help from Ms. Pandya and peer tuto.
 */
public class MoneyDemo
{
    // instance variables - replace the example below with your own
    private Scanner scan;
    private Scanner sc;
    
    /**
     * Main method that starts the program.
     * 
     * @throws FileNotFoundException if the "Data1.csv" file is not found in the project folder.
     */
    public static void main(String[] args)throws FileNotFoundException //main method
    {
        MoneyDemo m = new MoneyDemo();
        System.out.println("Program ended!");
    }
    
    /**
     * Runs program, printing user response questions to the terminal. 
     */
    public MoneyDemo()throws FileNotFoundException
    {
        scan = new Scanner(new File("Data1.csv"));
        sc = new Scanner(System.in);
        scan.nextLine(); //now in the right position
        while (scan.hasNextLine())
        {
            String line = scan.nextLine();
            String[] data = line.split(",");
            String name[] = data[0].split(" ");
            Address addr = new Address(data[1], data[2], data[3], data[4]);
            Person owner = new Person(name[1], name[0], addr);
            Money limit = new Money(Double.parseDouble(data[5]));
            CreditCard visa = new CreditCard(owner,limit);
            System.out.println("");
            System.out.println(visa.getPersonals());
            System.out.println("Initial Balance: " + visa.getBalance());
            System.out.println("Credit Limit: " + visa.getCreditLimit());
            System.out.println(" ");
            System.out.println("Would you like to do any transactions? y/n");
            String res = sc.next();
            while (res.equals("y"))
            {
                System.out.println("Enter the type of transaction and the amount, separated by space: c for charge, p for payment");
                String type = sc.next();
                double amt = sc.nextDouble();
                Money amount = new Money(amt);
                if (type.equals("c"))
                {
                    // do charge method
                    System.out.println("Attempting to charge " + amount.toString());
                    visa.charge(amount);
                    System.out.println("Balance: " + visa.getBalance());
                }
                else if (type.equals("p"))
                {
                    // do payment method
                    System.out.println("Attempting to pay " + amount.toString());
                    visa.payment(amount);
                    System.out.println("Balance: " + visa.getBalance());
                }
                else
                {
                    // please input valid value
                    System.out.println("Please enter either c for charge or p for payment.");
                }
                System.out.println("Would you like to make any more transaction? y/n");
                res = sc.next();
            }
            System.out.println("Thank you for the transactions! Next Customer please:");
            //scan.nextLine();
        }
        scan.close();
    }

    
}