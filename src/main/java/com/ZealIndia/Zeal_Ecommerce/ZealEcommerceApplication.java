package com.ZealIndia.Zeal_Ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableJpaAuditing
@EnableAsync
public class ZealEcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZealEcommerceApplication.class, args);
		System.out.println("Main Application - Zeal");
		//Controller → DTO → Mapper → Entity → Repository → DB
	}

}
