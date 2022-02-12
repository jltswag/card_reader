import java.util.*;// math and scanner
/**
 * Displays the financial details of a Person's credit card based off of the Money class. 
 *
 * @author (Julia Tran)
 * @version (1/19/2022)
 * 
 * Received help from Ms. Pandya and peer tutor.
 */
public class CreditCard
{
    // instance variables - replace the example below with your own
    private Money balance;
    private Money creditLimit;
    private Person owner;
    private Random rand;

    /**
     * Initializes fields for CreditCard class. 
     * 
     * @param newCardholder Person object that represents a new card holder.
     * 
     * @param limit Money object that represents a limit on a Person's card. 
     */
    public CreditCard(Person newCardholder, Money limit)
    {
        // initialise instance variables
        creditLimit = limit;
        owner = newCardholder;
        rand = new Random();
        balance = new Money(rand.nextInt(500));
    }
    
    /**
     * Gets balance of owner's card. 
     * 
     * @return Money showing balance of owner's card. 
     */
    public Money getBalance()
    {
        return balance;
    }
    
    /**
     * Gets credit limit of owner's card.
     * 
     * @return Money showing credit limit of owner's card.
     */
    public Money getCreditLimit()
    {
        return creditLimit; 
    }
    
    /**
     * Gets owner's name of credit card.
     * 
     * @return String showing owner of credit card's full name.
     */
    public String getPersonals()
    {
        return owner.toString();
    }
    
    /**
     * Adds user-given amount to balance.
     * 
     * @param amount Money that shows a user-given currency amount and is added from the user's balance.
     */
    public void charge(Money amount)
    {
        //check if exceeds creditlimit, if can, yes, if not, no
        //compare dollars from either objects this.dollar
        if (balance.add(amount).compareTo(creditLimit) < 0)
        {
            System.out.println("Charge: " + amount);
            balance = balance.add(amount);
        }
    }
    
    /**
     * Subtracts user-given amount to balance. 
     * 
     * @param amount Money that shows a user-given currency amount and is subtracted from the user's balance. 
     */
    public void payment(Money amount)
    {
        //subtract
        if (balance.add(amount).compareTo(creditLimit) < 0)
        {
            System.out.println("Payment: " + amount);
            balance = balance.subtract(amount);
        }
    }
}