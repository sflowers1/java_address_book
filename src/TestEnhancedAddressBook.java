import junit.framework.TestCase;

/**
 * TestEnhancedAddressBook class to verify class methods functionality
 * 
 * @author sflowers
 * @version 22/04/13 
 */
public class TestEnhancedAddressBook extends TestCase {

	private BusinessEntry be1; 
	private BusinessEntry be2;
	private BusinessEntry be3;
	private BusinessEntry be4;
	private PersonalEntry pe1;
	private PersonalEntry pe2;
	private EnhancedAddressBook eab;
	
	/**
	 * Called before every method execution
	 * @throws Exception from JUnit 
	 */
	protected void setUp() throws Exception
	{
		super.setUp();
		
		be1 = new BusinessEntry("Business1", "Lastname", "Street", "Town", "PL4 4TT", "Businessname"); 
		be2 = new BusinessEntry("Business2", "Lastname", "Street", "Town", "PL4 4TT", "Businessname");
		be3 = new BusinessEntry("Business3", "Lastname", "Street", "Town", "PL4 4TT", "Businessname");
		be4 = new BusinessEntry("Business4", "Lastname", "Street", "Town", "PL4 4TT", "Businessname");
		
		pe1 = new PersonalEntry("Personal1", "Lastname", "Street", "Town", "PL4 4TT", "DOB");
		pe2 = new PersonalEntry("Personal2", "Lastname", "Street", "Town", "PL4 4TT", "DOB");
		
		eab = new EnhancedAddressBook();
		
		// add entries to the address book
		eab.add(be1);
		eab.add(be2);
		eab.add(be3);
		eab.add(be4);
		eab.add(pe1);
		eab.add(pe2);
	}
	
	/**
	 * Called after every method execution
	 * @throws Exception from JUnit 
	 */
	protected void tearDown() throws Exception
	{
		super.tearDown();
	}
	
	/**
	 * Test for correct object instantiation
	 */
	public void testNotNull()
	{
		assertNotNull(eab);		
	}
	
	/**
	 * Tests for listAllEntries() returning the correct amount of entries
	 */
	public void testListAllEntries()
	{
		String s = eab.listAllEntries();
		assertTrue(s.contains("Number of entries: 6"));
	}
	
	/**
	 * Tests for listAllPersonalEntries() returning the correct amount of entries
	 */
	public void testListAllPersonalEntries()
	{
		String s = eab.listAllPersonalEntries();
		assertTrue(s.contains("Number of entries: 2"));
	}
	
	/**
	 * Tests for listAllBusinessEntries() returning the correct amount of entries
	 */
	public void testListAllBusinessEntries()
	{
		String s = eab.listAllBuisnessEntries();
		assertTrue(s.contains("Number of entries: 4"));
	}	
}
