package com.tesst.javamail.simplemail;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {

	public static void main(String[] args) {
		
		try
	    {
	        Properties props = System.getProperties();
	        
	          props.put("mail.transport.protocol", "smtp" );
	          props.put("mail.smtp.starttls.enable","true" );
	          props.put("mail.smtp.host","smtp.gmail.com");
	          props.put("mail.smtp.auth", "true" );
	          props.put("mail.smtp.port", "587");
	          props.put("mail.smtp.auth", "true");
	  		 props.put("mail.smtp.starttls.enable", "true");
	  		 
	  		 Authenticator auth = new SendMail().new SMTPAuthenticator();
	          Session session = Session.getInstance(props, auth);
	        
	          Message msg = new MimeMessage(session);
	        
	          System.out.println(msg);
	          msg.setFrom(new InternetAddress(""));   // Your mail id
	          msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("chaudhari.ankit61@gmail.com", false));
	          msg.setSubject("test");  //subbject of mail
	          msg.setText("This is a test mail");  // message body
	        
	          msg.setHeader("MyMail", "Mr. XYZ" );  // headers
	          msg.setSentDate(new Date());
	        
	          Transport.send(msg);
	          System.out.println("Mail Sent :)");
	    }
	     catch (Exception ex)
	    {
	      ex.printStackTrace();
	      System.out.println("Exception "+ex);
	    }
	}
	private class SMTPAuthenticator extends javax.mail.Authenticator {
	    @Override
	    public PasswordAuthentication getPasswordAuthentication() {
	        String username =  "";           // your email id (sender's email id)
	        String password = "";            // your password here
	        return new PasswordAuthentication(username, password);
	    }
	}
}
