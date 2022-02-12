/**
 * Sets up Money and Double units that will be utilized in the class CreditCard. 
 *
 * @author (Julia Tran)
 * @version (1/19/2022)
 */
public class Money
{
    // instance variables - replace the example below with your own
    private int dollars;
    private int cents;

    /** 
     * Sets user-given amount equal to fields. 
     * 
     * @param amount double that represents a user-given monetary metric that they are inserting into the account.
     */
    public Money(double amount)
    {
        // initialise instance variables
        int allCents = (int) Math.round(amount * 100);
        dollars = allCents / 100;
        cents = allCents % 100;
    }
    
    /**
     * Sets user-given amount equal to fields.
     * 
     * @param otherObject Money that represents a user-given monetary metric that they are inserting into the account.
     */
    public Money(Money otherObject)
    {
        this.dollars = otherObject.dollars;
        this.cents = otherObject.cents;
    }
    
    /** 
     * Adds a user-given amount to the current balance. 
     * 
     * @param otherAmount Money that represents a user-given monetary metric that they are inserting into the account.
     * 
     * @return difference that adds user-given metrics of dollars and cents together to return a new balance.
     */
    public Money add(Money otherAmount)
    {
        Money sum = new Money(0);
        sum.cents = this.cents + otherAmount.cents;
        int carryDollars = sum.cents / 100;
        sum.cents = sum.cents % 100;
        sum.dollars = this.dollars + otherAmount.dollars + carryDollars;
        return sum;
    }
    
    /**
     * Adds a user-given amount to the current balance. 
     * 
     * @param otherAmount Money that represents a user-given monetary metric that they are taking out of the account.
     * 
     * @return difference that subtracts user-given metrics of dollars and cents together to return a new balance.
     **/
    public Money subtract(Money amount)
    {
        Money diff = new Money(0);
        diff.cents = this.cents - amount.cents;
        int carryDollars = diff.cents / 100;
        diff.cents = diff.cents % 100;
        diff.dollars = this.dollars - amount.dollars - carryDollars;
        return diff;
    }   
    
    /**
     * Compares user-given amount to current balance to determine which amount is larger than the other. 
     * 
     * @param amount Money object that represents the amount of current Money.
     * 
     * @returns positive or negative value that indicates whether the amount exceeds the creditlimit.
     */
    public int compareTo(Money amount)
    {
        if (this.dollars > amount.dollars)
        {
            return 1;
        }
        else if (this.dollars < amount.dollars)
        {
            return -1;
        }
        else if (this.cents > amount.cents)
        {
            return 1;
        }
        else if (this.cents < amount.cents)
        {
            return -1;
        }
        else
        {
            return 0;
        }
    }
    
    
    /**
     * Gets current amount from the credit card. 
     * 
     * @returns String listing the current state of the Money object.
     */
    public String toString() 
    {
        return "$" + this.dollars + "." + String.format("%02d",this.cents); // %02d provides two number values after a decimal
    }
}