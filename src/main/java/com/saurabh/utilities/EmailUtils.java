package com.saurabh.utilities;


import javax.servlet.http.HttpServletRequest;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EmailUtils {
	public static void sendApplicantMail(EmailDetails emailDetails) throws EmailException{
		
		
		try
        {
             Email email = new SimpleEmail();
            email.setHostName("smtp.googlemail.com");
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator("temporarywebtools2017@gmail.com","temporary"));
            email.setSSL(true);
            email.setFrom("temporarywebtools2017@gmail.com");
            email.setSubject("TestEmail");
            email.addTo("saurabh.salunkhe81@gmail.com");
            email.send();
            
            
            
        }
        catch(Exception e)
        {
         System.out.println("Error Message" + e.getMessage());
    
        }
		
	}
	
}



