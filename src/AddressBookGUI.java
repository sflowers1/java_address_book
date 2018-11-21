import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * GUI class to construct and show the frame.
 * Also handles user input and controls access to the address book
 * 
 * @author Stephen Flowers
 * @version 16/04/2013
 */

public class AddressBookGUI extends JFrame implements ActionListener {

	private JPanel pnlTextOutput;
	private JScrollPane scrollPane;

    // items for the add entry tab page
	private JTextField txtAddFirstName = new JTextField(1);
	private JTextField txtAddLastName = new JTextField(1);
	private JTextField txtAddStreet = new JTextField(1);
	private JTextField txtAddTown = new JTextField(1);
	private JTextField txtAddPostCode = new JTextField(1);
	private JTextField txtAddDOB = new JTextField(1);
	private JTextField txtAddBusinessName = new JTextField(1);
	
	private JButton btnAddPersonal = new JButton("Add Personal");
	private JButton btnAddBusiness = new JButton("Add Business");	
	
	// items for the list entries tab page
	private JButton btnListAll = new JButton("List All");
	private JButton btnListPersonal = new JButton("List Personal");
	private JButton btnListBusiness = new JButton("List Business");
	
	// items for the search tab page
	private JTextField txtFindFirstName = new JTextField(1);
	private JTextField txtFindLastName = new JTextField(1);
	private JButton btnFindEntry = new JButton("Find Entry");
	
	// items for the delete tab page
	private JTextField txtDeleteFirstName = new JTextField(1);
	private JTextField txtDeleteLastName = new JTextField(1);
	private JButton btnDeleteEntry = new JButton("Delete Entry");	
	
    private JTextArea txtOutput = new JTextArea(40,40);
    
    private EnhancedAddressBook Book = new EnhancedAddressBook();
    
       	
	/**
	 * Constructor
	 */
	public AddressBookGUI()
	{
		super("Address Book");	// explicit parent class call
	}

	/**
	 * Creates and displays the user interface
	 */
	public void run()
	{
		makeFrame();
		showFrame();
	}

	/**
	 * Displays the user interface 
	 */
	private void showFrame()
	{   
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);			// disable maximize button
		setSize(550,400);
		setLocationRelativeTo(null);	// centre the window when launched
		setVisible(true);		
	}
	
	/**
	 * Creates the user interface window
	 */
	private void makeFrame()
	{
		// text output 
		pnlTextOutput = new JPanel();
		pnlTextOutput.setLayout(new BorderLayout());
		pnlTextOutput.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
	        
		txtOutput.setEditable(false);
		scrollPane = new JScrollPane(txtOutput);     
		pnlTextOutput.add(scrollPane);
		 
		// jtabbbedpane with 4 entries
		JTabbedPane jtp = new JTabbedPane();
		JPanel jpAddEntry = new JPanel();
		JPanel jpListEntries = new JPanel();
		JPanel jpSearch = new JPanel();
		JPanel jpDeleteEntry = new JPanel();
		 
		// add the tab pages to the tabbed entry
		jtp.addTab("Add Entry",jpAddEntry);
		jtp.addTab("List Entries",jpListEntries);
		jtp.addTab("Search",jpSearch);
		jtp.addTab("Delete Entry",jpDeleteEntry);
		 
		// 'add entry' tab page
		JPanel pnlAddEntry = new JPanel();
		
		pnlAddEntry.setLayout(new GridLayout(5,1,10,5));
		
		pnlAddEntry.add(new Label("First Name:"));
		pnlAddEntry.add(txtAddFirstName);
		pnlAddEntry.add(new Label("Last Name:"));
		pnlAddEntry.add(txtAddLastName);
		pnlAddEntry.add(new Label("Street:"));
		pnlAddEntry.add(txtAddStreet);
		pnlAddEntry.add(new Label("Town:"));
		pnlAddEntry.add(txtAddTown);
		pnlAddEntry.add(new Label("Postcode:"));
		pnlAddEntry.add(txtAddPostCode);
		pnlAddEntry.add(new Label("D.O.B."));
		pnlAddEntry.add(txtAddDOB);
		pnlAddEntry.add(new Label("Business Name"));
		pnlAddEntry.add(txtAddBusinessName);
		 
		pnlAddEntry.add(btnAddPersonal);
		pnlAddEntry.add(btnAddBusiness);
		 
		// 'list entries' tab page
		JPanel pnlListEntries = new JPanel();
		 
		pnlListEntries.setLayout(new GridLayout(3,1,10,5));
	        
		pnlListEntries.add(btnListAll);
		pnlListEntries.add(btnListPersonal);
		pnlListEntries.add(btnListBusiness);
		 
		// 'find entry' tab page
		JPanel pnlFindEntry = new JPanel();
		pnlFindEntry.setLayout(new GridLayout(3,2,10,5));
		pnlFindEntry.add(new Label("First Name:"));
		pnlFindEntry.add(txtFindFirstName);
		pnlFindEntry.add(new Label("Last Name:"));
		pnlFindEntry.add(txtFindLastName);
		pnlFindEntry.add(btnFindEntry);		 
		 
		// 'delete entry' tab page
		JPanel pnlDeleteEntry = new JPanel();
		pnlDeleteEntry.setLayout(new GridLayout(3,2,10,5));
		pnlDeleteEntry.add(new Label("First Name:"));
		pnlDeleteEntry.add(txtDeleteFirstName);
		pnlDeleteEntry.add(new Label("Last Name"));
		pnlDeleteEntry.add(txtDeleteLastName);
		pnlDeleteEntry.add(btnDeleteEntry);
		 
		// add the panels to each tab page respectively
		jpAddEntry.add(pnlAddEntry,BorderLayout.EAST);
		jpListEntries.add(pnlListEntries, BorderLayout.EAST);
		jpSearch.add(pnlFindEntry, BorderLayout.EAST);
		jpDeleteEntry.add(pnlDeleteEntry, BorderLayout.EAST);	 
		 
		// add the main features to the frame
		add(pnlTextOutput,BorderLayout.CENTER);
		add(jtp, BorderLayout.NORTH);

		// add action listeners to the program
		btnAddPersonal.addActionListener(this);
		btnAddBusiness.addActionListener(this);
		btnListAll.addActionListener(this);
		btnListPersonal.addActionListener(this);
		btnListBusiness.addActionListener(this);
		btnFindEntry.addActionListener(this);
		btnDeleteEntry.addActionListener(this);		 
	}	   

	/**
	 * Override the 'actionPerformed' method to incorporate our desired actions
	 */
	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		String item = ae.getActionCommand(); 

		if (item.equals(btnAddPersonal.getText())) {
			
			// check for a duplicate entry
			String s = Book.findEntry(txtAddFirstName.getText() + " " + txtAddLastName.getText());
			
			if(!s.contains("does not occur")) {
				txtOutput.setText("Entry not added\nEntry already exists!");
				return;
			}
			
			// check for a dob entered
			if(txtAddDOB.getText().length() < 4) {
				txtOutput.setText("Entry not added!\nIncorrect DOB entered");
				return;
			}
			
			RedirectStdErr rse = new RedirectStdErr();
			PersonalEntry pe = new PersonalEntry(	txtAddFirstName.getText(), 
													txtAddLastName.getText(),
													txtAddStreet.getText(),
													txtAddTown.getText(), 
													txtAddPostCode.getText().toUpperCase(),
													txtAddDOB.getText());
	    
		    // check for std error output
			String stderr = rse.GetStdErr();

			// add the entry if no std error generated
		    if(stderr.equals("")) {
		    	String result = Book.add(pe);
		    	txtOutput.setText(result);
		    }
		    else {
		    	txtOutput.setText("Entry not added\n" + stderr);
		    }            
        }
		else if (item.equals(btnAddBusiness.getText())) {
			
			// check for a duplicate entry
			String s = Book.findEntry(txtAddFirstName.getText() + " " + txtAddLastName.getText());
			
			if(!s.contains("does not occur")) {
				txtOutput.setText("Entry not added\nEntry already exists!");
				return;
			}
			
			// check for a business name entered
			if(txtAddBusinessName.getText().length() < 2) {
				txtOutput.setText("Entry not added!\nInsufficient business name entered");
				return;
			}
			
			RedirectStdErr rse = new RedirectStdErr();
			BusinessEntry be = new BusinessEntry(	txtAddFirstName.getText(), 
													txtAddLastName.getText(),
													txtAddStreet.getText(),
													txtAddTown.getText(), 
													txtAddPostCode.getText().toUpperCase(),
													txtAddBusinessName.getText());
		    
		    // check for std error output
			String stderr = rse.GetStdErr();

			// add the entry if no std error generated
		    if(stderr.equals("")) {
		    	String result = Book.add(be);
		    	txtOutput.setText(result);
		    }
		    else {
		    	txtOutput.setText("Entry not added\n" + stderr);
		    }            
        }
		else if (item.equals(btnListAll.getText())) {
			
			String result = Book.listAllEntries();
			txtOutput.setText(result);            
        }
        else if (item.equals(btnListPersonal.getText())) {
        	
        	String result = Book.listAllPersonalEntries();
			txtOutput.setText(result);
        }
        else if (item.equals(btnListBusiness.getText())) {
        	
        	String result = Book.listAllBuisnessEntries();
			txtOutput.setText(result);
        }
        else if (item.equals(btnFindEntry.getText())) {
        	
        	// search entries
            txtOutput.setText(Book.findEntry(	txtFindFirstName.getText() + " " + 
            									txtFindLastName.getText()));                
        }
        else if (item.equals(btnDeleteEntry.getText())) {
        	
        	// first check if entry exists
			String s = Book.findEntry(txtDeleteFirstName.getText() + " " + txtDeleteLastName.getText());
			
			if(s.contains("does not occur")) {
				txtOutput.setText("Entry not deleted\nEntry does not exist in the address book!");
				return;
			}
            
			// entry exists, go ahead and delete
            txtOutput.setText(Book.deleteEntry(	txtDeleteFirstName.getText() + " " + 
            									txtDeleteLastName.getText()));
        }
	}	
}
