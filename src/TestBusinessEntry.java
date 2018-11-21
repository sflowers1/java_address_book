import junit.framework.TestCase;

/**
 * TestBusinessEntry class to verify BusinessEntry class methods functionality
 * 
 * @author sflowers
 * @version 22/04/13 
 */
public class TestBusinessEntry extends TestCase {
	
	private BusinessEntry be;
	
	/**
	 * Called before every method execution
	 * @throws Exception from JUnit 
	 */
	protected void setUp() throws Exception
	{
		super.setUp();
		be = new BusinessEntry("FirstName","LastName","Street","Town","DL5 6GP","BusinessName");
	}
	
	/**
	 * Called after every method execution
	 * @throws Exception from JUnit 
	 */
	protected void tearDown() throws Exception
	{
		super.tearDown();
		be = null;		
	}
	
	/**
	 * Tests business entry object has been instantiated correctly
	 */
	public void testNotNull()
	{
		assertNotNull(be);		
	}

	/**
	 * Tests business entry object toString() method
	 */
	public void testToString()
	{
		String s = be.toString();		
		assertTrue(s.equals("FirstName LastName, Street, Town, DL5 6GP, BusinessName"));		
	}	
}
