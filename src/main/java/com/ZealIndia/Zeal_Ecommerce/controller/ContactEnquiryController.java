package com.ZealIndia.Zeal_Ecommerce.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ZealIndia.Zeal_Ecommerce.Entity.ContactEnquiry;
import com.ZealIndia.Zeal_Ecommerce.Service.ContactEnquiryService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/contactEnquiry")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class ContactEnquiryController {
	
	private final ContactEnquiryService enquiryService;
	
	@PostMapping("/submit")
	public ResponseEntity<String> submitEnquiry(@RequestBody ContactEnquiry ce)
	{
		 ContactEnquiry saved = enquiryService.saveEnquiry(ce);
		 System.out.println("Controller - Contact Enquiry : "+saved);
	     return ResponseEntity.ok("Enquiry submitted successfully");
	}

}
