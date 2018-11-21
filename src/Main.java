/**
 * The driver class for Assignment 1, Phonebook
 * 
 * @author Stephen Flowers
 * @version 16/04/2013
 */

public class Main {

	/**
	 * Program entry point.  Create a new UserInterface 
	 * instance and run the menu system 
	 * @param args
	 */
	public static void main(String args[]) 	
	{
		AddressBookGUI gui = new AddressBookGUI();
		gui.run();		
	}	
}
