package com.ZealIndia.Zeal_Ecommerce.Service;

import com.ZealIndia.Zeal_Ecommerce.Entity.ContactEnquiry;

public interface EmailService {
	void sendEnquiryEmail(ContactEnquiry enquiry);
}
