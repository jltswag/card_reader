/**
 * Provides basic details of a person's home address that will be further utilized in the class Person. 
 *
 * @author (Julia Tran)
 * @version (1/19/2022)
 */
public class Address
{
    // instance variables - replace the example below with your own
    private String street;
    private String city; 
    private String state;
    private String zip; 

    /**
     * Sets fields equal to fields.
     * 
     * @param road String that represents a Person's home address street location. 
     * @param town String that represents a Person's home address town location. 
     * @param state String that represents a Person's home address state location. 
     * @param zip String that represents a Person's home address zip code. 
     */
    public Address(String road, String town, String state, String zip)
    {
        street = road;
        city = town;
        this.state = state; //field = this, local does not
        this.zip = zip;
    }
    
    /**
     * Gets string listing the full address of a person.
     * 
     * @return string listing the full address of a person.
     */
    public String toString()
    {
        return street + ", " + city + ", " + state + ", " + zip;
    }
}