/**
 * PersonalEntry class, extending the Entry class.
 * Adds storage for date of birth and provides overridden
 * 'toString' method  
 * 
 * @author Stephen Flowers
 * @version 16/04/2013
 */

public class PersonalEntry extends Entry 
{
	private String strDOB = null;

	/**
	 * Constructor
	 * @param firstName
	 * @param lastName
	 * @param street
	 * @param town
	 * @param postcode
	 * @param dateOfBirth
	 */
	public PersonalEntry(String firstName, String lastName,
			String street, String town, String postcode, String dateOfBirth) 
	{
		super(firstName, lastName, street, town, postcode);	// explicit parent class constructor call
		strDOB = dateOfBirth;
	}
	
	/**
	 * Override the parents 'toString()' method to include the date of birth field
	 * @return String 
	 */
	@Override
	public String toString() 
	{
		return super.toString() + ", " + strDOB;
	}	
}
