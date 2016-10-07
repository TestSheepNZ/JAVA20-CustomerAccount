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

import java.util.ArrayList;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class CustomerAccountClass {

	
	//Attributes
	private String userName;
	private String dateOfBirth;
	private String fullName;
	private String mailAddress;
	private String email;
	private String phoneNumber;
	private String password;
	
	//List of those with admin rights
	private List<String> adminStaff;

	//A whole list of audit events
	private List<AuditEvent> auditEvents;
	
	// Constructor - need to have a userName & password & date of birth to start with
	public CustomerAccountClass (String user, String initialPassword, String DOB )
	{
		userName = user;
		dateOfBirth = DOB;
		password = initialPassword;
		
		adminStaff = new ArrayList<String>();
		auditEvents = new ArrayList<AuditEvent>();
		
		//Add creation audit event
		AuditEvent audit = new AuditEvent(userName, userName, "Account created","", "");
		auditEvents.add(0, audit);
		
		//This is a hack for now, but add some user admin accounts
		adminStaff.add(0,"admin1");
		adminStaff.add(0,"admin2");
		adminStaff.add(0,"admin3");
		
	}
	
	//Checks a user is authorised to make a change
	private boolean authorisedUser (String user)
	{
		boolean retVal = false;
		if (userName == user || adminStaff.contains(user))
			retVal = true;
		return retVal;
	}
	
	private void accessDenied (String requestUser, String action)
	{
		System.out.println("Access denied!");
		
		AuditEvent newEvent = new AuditEvent(requestUser, userName, 
				"Access denied - someone attempted to add "+action, "", "");
		auditEvents.add(newEvent);
	}
	
	// Some set methods
	public boolean setNewName (String requestFromUser, String newName)
	{
		if (authorisedUser(requestFromUser))
		{
			String oldName = fullName;
			fullName = newName;
			AuditEvent newEvent = new AuditEvent(requestFromUser, userName, 
					"Üpdated user name", oldName, newName);
			auditEvents.add(newEvent);
			return true;
		}
		else
		{
			accessDenied(requestFromUser, "new name");
			return false;
		}
	}
	
	public boolean setNewAddress (String requestFromUser, String newAddress)
	{
		if (authorisedUser(requestFromUser))
		{
			String oldAddress = mailAddress;;
			mailAddress = newAddress;
			AuditEvent newEvent = new AuditEvent(requestFromUser, userName, 
					"Üpdated mail address", oldAddress, newAddress);
			auditEvents.add(newEvent);
			return true;
		}
		else
		{
			accessDenied(requestFromUser, "new address");
			return false;
		}
	}
	
	public boolean setNewEmail (String requestFromUser, String newEmail)
	{
		if (authorisedUser(requestFromUser))
		{
			String oldEmail = email;
			email = newEmail;
			AuditEvent newEvent = new AuditEvent(requestFromUser, userName, 
					"Üpdated email address", oldEmail, newEmail);
			auditEvents.add(newEvent);
			return true;
		}
		else
		{
			accessDenied(requestFromUser, "new email");
			return false;
		}
	}
	
	public boolean setNewPhone (String requestFromUser, String newPhoneNumber)
	{
		if (authorisedUser(requestFromUser))
		{
			String oldPhoneNumber = phoneNumber;;
			phoneNumber = newPhoneNumber;
			AuditEvent newEvent = new AuditEvent(requestFromUser, userName, 
					"Üpdated email address", oldPhoneNumber, newPhoneNumber);
			auditEvents.add(newEvent);
			return true;
		}
		else
		{
			accessDenied(requestFromUser, "new phone number");
			return false;
		}
	}
	
	
	public boolean setNewPassword (String requestFromUser, String newPassword)
	{
		//Only the user can change password!
		if (userName == requestFromUser )
		{
			password = newPassword;
			AuditEvent newEvent = new AuditEvent(requestFromUser, userName, 
					"User updated password", "", "");
			auditEvents.add(newEvent);
			return true;
		}
		else
		{
			accessDenied(requestFromUser, "new password");
			return false;
		}
	}
	
	public boolean printAccount (String requestFromUser)
	{
		if (authorisedUser(requestFromUser))
		{
			System.out.println("Username:" + userName);
			System.out.println("Date of birth:" + dateOfBirth);		
			System.out.println("Full name:" + fullName);
			System.out.println("Mail address:" + mailAddress);
			System.out.println("Email:" + email);
			System.out.println("Phone number:" + phoneNumber);
			
			
			System.out.println("");
			System.out.println("EVENTS");
			for(AuditEvent event:auditEvents)
			{
				event.printAuditEvent();
			}
			return true;
		}
		else
		{
			accessDenied(requestFromUser, "view details");
			return false;
		}
	}
	
}
