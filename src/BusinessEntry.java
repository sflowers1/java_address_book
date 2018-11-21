/**
 * BusinessEntry class, extending the Entry class.
 * Adds storage for company name and provides overridden
 * 'toString' method  
 * 
 * @author Stephen Flowers
 * @version 16/04/2013
 */

public class BusinessEntry extends Entry {

	private String strCompanyName = null;

	/**
	 * Constructor
	 * @param firstName
	 * @param lastName
	 * @param street
	 * @param town
	 * @param postcode
	 * @param companyName
	 */
	public BusinessEntry(String firstName, String lastName,
			String street, String town, String postcode, String companyName)
	{
		super(firstName, lastName, street, town, postcode);	// explicit parent class constructor
		strCompanyName = companyName;
	}
	
	/**
	 * Override the parents 'toString()' method to include the company name field
	 * @return String 
	 */
	@Override
	public String toString() 
	{
		return super.toString() + ", " + strCompanyName;
	}	
}
