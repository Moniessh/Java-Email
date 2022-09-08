package emailapp;

import java.util.*;

interface Password{
	String password(int length);
}


public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	public  String email;
	private int    mailboxCapacity=500;
	private int    defaultPasswordLength=10;
	private int	   year;
	private String alternateEmail;
	private String domainName="citchennai.net";
	
	Formatter t1 = new Formatter();
	Formatter t2 = new Formatter();

	Scanner s=new Scanner(System.in);
	
	public void Email1(String firstName, String lastName) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.year=setYear();
		this.department=setDepartment();
//		System.out.println("Department: "+this.department);
		this.password=randomPassword(defaultPasswordLength);
		email=firstName.toLowerCase()+""+lastName.toLowerCase()+department+year+"@"+domainName;
	}
	
	
	
	public String setDepartment() {
		System.out.println("New Personal: "+firstName+" "+lastName+"\n");
		t1.format("%58s", "DEPARTMENTS");
		System.out.print("-------------------------------------------------------------------------------------------------------------------\n");
		System.out.println(t1);
		System.out.print("-------------------------------------------------------------------------------------------------------------------");
		
		t2.format("\n %35s %1s \n %35s %1s \n %35s %1s \n %35s %1s \n %35s %1s","1","Information Technology","2","Computer Science","3","Bio-Medical Engineering","4","Electrical and Electronics Engineering","0","None");
		System.out.println(t2);
		System.out.println("-------------------------------------------------------------------------------------------------------------------");
		System.out.println("Enter the department: ");
		int depChoice=s.nextInt();
		switch(depChoice) {
		case 1: return "it";
		case 2: return "cse";
		case 3: return "bme";
		case 4: return "eee";
		case 0: return "";
		default: {
			System.out.println("Enter Valid Option");
			return "";
			}
		}		
	}
	
	public int setYear() {
		System.out.println("Enter the Year of Admission: ");
		int year=s.nextInt();
		return year;
	}
	
	public String setDepartment(String a) {
		System.out.println("New Personal: "+firstName+" "+lastName+"\nDEPARTMENTS\n1 Information Technology\n2 Computer Science\n3 Bio-Medical Engineering\n4 Electrical and Electronics Engineering \n0 None\nEnter the department: ");
		int depChoice=s.nextInt();
		switch(depChoice) {
		case 1: return "it";
		case 2: return "cse";
		case 3: return "bme";
		case 4: return "eee";
		case 0: return "";
		default: System.out.println("Enter Valid Option");return a;
		
		}		
	}
	
	private String randomPassword(int length) {
		String passwordSet="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@$%";
		char[] password=new char[length];
		for(int i=0;i<length;i++) {
			int rand=(int)(Math.random()*passwordSet.length());
			password[i]=passwordSet.charAt(rand);
		}
		return new String(password);
	}
	
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity=capacity;
	}
	public void setAlternateEmail(String altmail) {
		this.alternateEmail=altmail;
	}
	public void changePassword(String password) {
		this.password=password;
	}
	public int getMaiboxCapacity() {
		return mailboxCapacity;
	}
	public String getAlternateEmail() {
		return alternateEmail;
	}
	public String getPassword() {		
		return password;
	}
	
	public String show() {
		return "DISPLAY NAME: "+firstName+" "+lastName+"\nCOMPANY EMAIL: "+email+"\nYour password is: "+password+"\nMAILBOX CAPACITY: "+mailboxCapacity+"mb";
	}
	

	public void checkMailAcc() {
		
		System.out.println("\nEnter your Mail-Id: ");
		String mailid=s.next();
		System.out.println();
		
		System.out.println("+-----------------------------------------------------------------------------------------------------------------+");
		if(mailid.equals(email)) {
			System.out.println("  COMPOSE: \t \t \t \t \t \t \t \t \t  [Enter . seperately  to send]");	
				}
		else {
			System.out.println(mailid+" does not exist.");
			checkMailAcc();
		}
		System.out.println("+-----------------------------------------------------------------------------------------------------------------+");
		System.out.println("To "+email+":");
		}
}

