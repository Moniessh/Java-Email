package emailapp;
import java.util.*;
public class EmailApp {

	public static void main(String[] args) {
		
		
		
		System.out.println("First Name: ");
		Scanner s=new Scanner(System.in);
		String firstName=s.next();
		System.out.println("Last Name: ");
		String lastName=s.next();
		
		Email eml = new Email();
		
		
		eml.Email1(firstName, lastName);
		System.out.println(eml.show());
		eml.checkMailAcc();

		
		JavaSendEmail.sendMail(eml.email);
	}

}
