/**
 * EnhancedAddressBook class, extending the AddressBook class.
 * Provides additional methods to show all entries, all personal 
 * entries and all business entries  
 * 
 * @author Stephen Flowers
 * @version 16/04/2013
 */

public class EnhancedAddressBook extends AddressBook 
{
	/**
	 * Constructor
	 */
	public EnhancedAddressBook () 
	{
		super();	// explicit parent class constructor call
	}
	
	/**
	 * Method to iterate through all entries in the address book 
	 * @return String constaining all entries
	 */
	public String listAllEntries() 
	{
		String s = "Showing all entries...\n";
		
		// iterate through the addressbook arraylist
		for(Entry a: getAddressBook()) {
			s += a.toString() + "\n";
		}
		s += "Number of entries: " + numberOfEntries() + "\n";
		return s;
	}
	
	/**
	 * Method to iterate through all Business entries in the address book 
	 * @return String constaining all Business entries
	 */
	public String listAllBuisnessEntries() 
	{
		int numEntries = 0;
		String s = "Showing all business entries...\n";
		
		// iterate through the addressbook arraylist
		for(Entry a: getAddressBook()) {
			if(a instanceof BusinessEntry) {
				s += a.toString() + "\n";
				numEntries++;
			}
		}
		s += "Number of entries: " + numEntries + "\n"; 
		return s;
	}
	
	/**
	 * Method to iterate through all Personal entries in the address book 
	 * @return String constaining all Personal entries
	 */
	public String listAllPersonalEntries() 
	{
		int numEntries = 0;
		String s = "Showing all personal entries...\n";
		
		// iterate through the addressbook arraylist
		for(Entry a: getAddressBook()) {
			if(a instanceof PersonalEntry) {
				s += a.toString() + "\n";
				numEntries++;
			}
		}
		s += "Number of entries: " + numEntries + "\n";
		return s;
	}
}
