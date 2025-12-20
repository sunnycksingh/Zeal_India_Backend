package com.ZealIndia.Zeal_Ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ZealIndia.Zeal_Ecommerce.Service.ProductBatchImportService;

@RestController
@RequestMapping("/api/importcsv")
public class ImportCSVIntoDBController 
{
	@Autowired
	private ProductBatchImportService importService;
	
	//      http://localhost:8080/api/importcsv/productsdemo
	@PostMapping("/productsdemo")
    public ResponseEntity<String> importProductsToDB() 
	{
		System.out.println("File : ImportCSVIntoDBController: Entry Point");
       // String filePath = "C:/Users/.../Zeal_design_1/public/products.csv"; 
		int totalRows = importService.importCsvInBatch();
	    return ResponseEntity.ok("Imported " + totalRows + " products successfully.");
    }
	
	
	
	
}
