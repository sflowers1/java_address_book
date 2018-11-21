import java.io.*;

/**
 * Class to redirect standard error to a string.
 * Useful as the supplied class files write to standard error rather than 
 * return an error string, so with this class am able to show the user exactly
 * what the error code was.
 * 
 * @author Stephen Flowers
 * @version 16/04/2013
 */


public class RedirectStdErr 
{
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	PrintStream ps = new PrintStream(baos);
	
	/**
	 * Constructor.  Flushes the std error buffer 
	 * and redirects to a printstream object  
	 */
	public RedirectStdErr() 
	{
		System.err.flush();	// clear any existing std error contents
	    System.setErr(ps);	// redirect to printstream 
	}
	
	/**
	 * Reverts std error back to normal  
	 * @return String containing any redirected std error output
	 */
	public String GetStdErr() 
	{
	    System.err.flush();			// flush the buffer
	    System.setErr(System.err);	// remove our redirection
	    return (baos.toString());	// return what we captured
	}	
}
