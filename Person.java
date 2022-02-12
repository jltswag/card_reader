/**
 * Creates personal details of a credit card user that will be utilized in the credit card and address classes. 
 *
 * @author (Julia Tran)
 * @version (1/19/2022)
 * 
 */
public class Person
{
    // instance variables - replace the example below with your own
    private String lastName; 
    private String firstName;
    private Address home;

    /**
     * Initializes fields for Person class. 
     * 
     * @params last String that is set equal to the last name of a Person Object.
     * 
     * @params first String that is set equal to the first name of a Person Object.
     * 
     * @params residence Address that is set equal to the address of a Person Object.
     */
    public Person(String last, String first, Address residence)
    {
        lastName = last;
        firstName = first;
        home = residence;
    }
    
    /**
     * Gets Person's full name and address. 
     * 
     * String method that returns string listing the full name of a person along with their address.
     */
    public String toString()
    {
        return lastName + " " + firstName + ", " + home;
    } 
}