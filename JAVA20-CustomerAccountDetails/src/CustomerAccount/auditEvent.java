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

public class auditEvent {

	//Attributes
	private String description;
	private long timestamp;
	private String userName;
	private String changedBy;
	private String previousValue;
	private String newValue;
	
	public auditEvent (String changedByUser, String user, 
			String details, String previous, String update)
	{
		userName = user;
		changedBy = changedByUser;
		description = details;
		previousValue = previous;
		newValue = update;
		timestamp = System.currentTimeMillis();
	}
	
	public void printAuditEvent()
	{
		System.out.println("AUDIT EVENT");
		System.out.println("   "+description);
		System.out.println("   "+"User:" + userName);
		if (previousValue != "")
		{
			System.out.println("   "+"Previous value:" + previousValue);
			System.out.println("   "+"New value:" + previousValue);
		}
		System.out.println("   "+"Timestamp:" + timestamp);
		System.out.println("   "+"Change performed by:" + changedBy);
	}
	
	
}
