package com.ZealIndia.Zeal_Ecommerce.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.ZealIndia.Zeal_Ecommerce.Entity.ContactEnquiry;

@Service
public class EmailServiceImpl implements EmailService
{
	@Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String fromEmail;

    private static final Logger log = LoggerFactory.getLogger(EmailServiceImpl.class);
    
    @Async
    @Override
    public void sendEnquiryEmail(ContactEnquiry enquiry) {

    	 log.info("Starting email send | type=CONTACT_ENQUIRY | email={}",
                 enquiry.getEmail());
    	try
    	{
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setFrom(fromEmail);
	        message.setTo("explorebeyondd@gmail.com"); // receiver //DB
	        message.setSubject("New Contact Enquiry - " + enquiry.getEnquiryType());
	
	        message.setText(buildEmailBody(enquiry));
	
	        mailSender.send(message);
	        
	        log.info("Email sent successfully | type=CONTACT_ENQUIRY | email={}",
                    enquiry.getEmail());
	        
    	}
    	catch (Exception ex) {
            log.error("Failed to send email | type=CONTACT_ENQUIRY | email={} | reason={}",
                      enquiry.getEmail(),
                      ex.getMessage(),
                      ex);
           
        }
    }

    private String buildEmailBody(ContactEnquiry e) {
        return """
                New enquiry received:

                Enquiry Type: %s
                Product Group: %s

                Name: %s %s
                Email: %s
                Phone: %s

                Company: %s
                City: %s
                Country: %s

                Message:
                %s
                """.formatted(
                e.getEnquiryType(),
                e.getProductGroup(),
                e.getFirstName(),
                e.getLastName(),
                e.getEmail(),
                e.getPhone(),
                e.getCompanyName(),
                e.getCity(),
                e.getCountry(),
                e.getMessage() == null ? "N/A" : e.getMessage()
        );
    }
}
