package CustomerAccount;

/*
 * This program is part of my learning Java series
 * This one looks an a customer account
 * 
 * Find the blog here,
 * http://testsheepnz.blogspot.co.nz/2016/09/java-20-customer-account.html
 * 
 * For more information - please reread.
 * 
 * Mike Talks, Sept 2016
 */


import org.junit.Test;


public class TestClass {

	@Test
	public void addBasicUserAndPrint()
	{	
		CustomerAccountClass newCustomer = new CustomerAccountClass("bazzer01", "initPassword", "01/01/1970");
		
		newCustomer.setNewName("bazzer01", "Barry Stanley Middleton");
		
		//Some invalid calls
		newCustomer.setNewName("wozzer02", "Barry Stanley Middleton");
		newCustomer.setNewName("bazzer001", "Barry Stanley Middleton");
		newCustomer.setNewPhone("bazzzzzzer01", "90901212");
		newCustomer.setNewPassword("bazzer01", "password1");
		
		//Admin users
		newCustomer.setNewEmail("admin1", "baz.myman@bazzer.baz.com");
		newCustomer.setNewAddress("admin1", "New St, Wellington, New Zealand");
		newCustomer.setNewPhone("admin1", "04 683850");
		newCustomer.setNewPassword("admin1", "password1");
		
		
		//Print
		newCustomer.printAccount("dehude");
		newCustomer.printAccount("admin1");
	}
}
