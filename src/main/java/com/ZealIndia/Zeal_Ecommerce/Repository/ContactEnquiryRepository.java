package com.ZealIndia.Zeal_Ecommerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ZealIndia.Zeal_Ecommerce.Entity.ContactEnquiry;

@Repository
public interface ContactEnquiryRepository extends JpaRepository<ContactEnquiry, Long>
{

}
