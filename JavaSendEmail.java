
package emailapp;

import java.util.LinkedList;
import java.util.Properties;
import java.util.Scanner;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaSendEmail extends Email{

	public JavaSendEmail(String firstName, String lastName) {
		// TODO Auto-generated constructor stub
		

	}
	
	static Email em=new Email();
	

	public static void sendMail(String recepient) {
		Properties properties=new Properties();
		properties.put("mail.smtp.auth","true");
		properties.put("mail.smtp.starttls.enable","true");
		properties.put("mail.smtp.host","smtp.gmail.com");
		properties.put("mail.smtp.port","587");
		
		String username="mail_id";// use your mail-id
		String password="password";//Give your own password
		
		Session session = Session.getInstance(properties,new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username,password);
			}
		});
		
		Message message=prepareMessage(session,username,recepient);
		try {
			Transport.send(message);
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Email Sent Successfully to "+recepient);
	}
	private static Message prepareMessage(Session session,String username,String recepient) {
		Message message=new MimeMessage(session);
		
		String text="";
		LinkedList<String> msg=new LinkedList<String>();
		Scanner s=new Scanner(System.in);

		for(int i=0;i<500;i++) { 
			msg.add(s.next());
			if(msg.get(i).equals("."))
				break;
			text+=" "+msg.get(i);
			
			}
		System.out.println("\nMessage: "+text);
		System.out.println("+-----------------------------------------------------------------------------------------------------------------+");
		System.out.println();
		System.out.println("Peparing to Send Email...");

		try {
			message.setFrom(new InternetAddress(username));
			message.setRecipient(Message.RecipientType.TO,new InternetAddress(recepient));
			message.setSubject("[---TEST EMAIL---]");
			message.setText(text);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return message;
	}
}
