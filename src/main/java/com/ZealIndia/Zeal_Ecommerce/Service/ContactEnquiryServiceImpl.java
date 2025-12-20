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
	
	@Override
	public ContactEnquiry saveEnquiry(ContactEnquiry contactEnquiry) 
	{
		System.out.println("Entered >> ContactEnquiryServiceImpl >> saveEnquiry");
		return enquiryRepository.save(contactEnquiry);
	}

}
