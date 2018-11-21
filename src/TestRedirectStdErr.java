import junit.framework.TestCase;

/**
 * TestRedirectStandardError class to verify redirection
 * 
 * @author sflowers
 * @version 22/04/13 
 */
public class TestRedirectStdErr extends TestCase {
							
	/**
	 * Called before every method execution
	 * @throws Exception from JUnit 
	 */
	protected void setUp() throws Exception
	{
		super.setUp();		
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
	 * Test StdErr redirection
	 */
	public void testRedirection()
	{
		RedirectStdErr rse = new RedirectStdErr();
		
		System.err.print("Testing StdErr class");
				
		String s = rse.GetStdErr();
		
		assertTrue(s.equals("Testing StdErr class"));		
	}
}
