package com.ZealIndia.Zeal_Ecommerce.Service;

import org.springframework.stereotype.Service;

import com.ZealIndia.Zeal_Ecommerce.Entity.ContactEnquiry;
import com.ZealIndia.Zeal_Ecommerce.Repository.ContactEnquiryRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ContactEnquiryServiceImpl implements ContactEnquiryService
{
	
	private ContactEnquiryRepository enquiryRepository;
    private EmailService emailService;
    
    
	@Override
	public ContactEnquiry saveEnquiry(ContactEnquiry contactEnquiry) 
	{
		System.out.println("Entered >> ContactEnquiryServiceImpl >> saveEnquiry");
		ContactEnquiry saved = enquiryRepository.save(contactEnquiry);
		
		//Send Email after saving values in database
		emailService.sendEnquiryEmail(saved);
		return saved;		
		
	}

}
