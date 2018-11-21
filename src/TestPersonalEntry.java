import junit.framework.TestCase;

/**
 * TestPersonalEntry class to verify PersonalEntry class methods functionality
 * 
 * @author sflowers
 * @version 22/04/13 
 */
public class TestPersonalEntry extends TestCase {
	
	private PersonalEntry pe;
	
	/**
	 * Called before every method execution
	 * @throws Exception from JUnit 
	 */
	protected void setUp() throws Exception
	{
		super.setUp();
		pe = new PersonalEntry("FirstName","LastName","Street","Town","DL5 6GP","02/03/79");
	}
	
	/**
	 * Called after every method execution
	 * @throws Exception from JUnit 
	 */
	protected void tearDown() throws Exception
	{
		super.tearDown();
		pe = null;		
	}
	
	/**
	 * Tests personal entry object has been instantiated correctly
	 */
	public void testNotNull()
	{
		assertNotNull(pe);		
	}

	/**
	 * Tests personal entry object toString() method
	 */
	public void testToString()
	{
		String s = pe.toString();		
		assertTrue(s.equals("FirstName LastName, Street, Town, DL5 6GP, 02/03/79"));		
	}	
}
