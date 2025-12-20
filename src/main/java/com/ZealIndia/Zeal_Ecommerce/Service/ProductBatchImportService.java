package com.ZealIndia.Zeal_Ecommerce.Service;

import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.opencsv.CSVReader;

@Service
public class ProductBatchImportService
{
	@Autowired
	private DataSource dataSource;
	
	//Will have to change the manual table name and column names for diff tables
	// sql and 	csvPath (For diff tables)
	public int importCsvInBatch() 
	{
		int count  		= 0; 
        String sql 		= "INSERT INTO product "
        				+ "(product_name, "
        				+ "product_description, "
        				+ "product_price) "
        				+ "VALUES (?, ?, ?)";
        String csvPath 	= "static/data.csv"; // or static/products.csv
        
        try (Connection conn = dataSource.getConnection();
        	     PreparedStatement stmt = conn.prepareStatement(sql);
        	     CSVReader csvReader = new CSVReader(
        	         new InputStreamReader(new ClassPathResource(csvPath).getInputStream())
        	     )) 
        {

    	    conn.setAutoCommit(false);

    	    boolean header 	= true;
    	    int batchSize 	= 1000;
    	   	String[] data;
    	   	
    	    while ((data = csvReader.readNext()) != null) {
    	        // Skip header
    	        if (header) {
    	            header = false;
    	            continue;
    	        }

    	        // Skip malformed rows
    	        if (data.length < 3) {
    	            System.out.println("Skipping invalid row: " + String.join(",", data));
    	            continue;
    	        }

    	        stmt.setString(1, data[0].trim());
    	        stmt.setString(2, data[1].trim());

    	        try 
    	        {
    	            stmt.setDouble(3, Double.parseDouble(data[2].trim()));
    	        } 
    	        catch (NumberFormatException e) 
    	        {
    	            System.out.println("Skipping row with invalid price: " + String.join(",", data));
    	            continue;
    	        }

    	        stmt.addBatch();
    	        count++;

    	        if (count % batchSize == 0) {
    	            stmt.executeBatch();
    	        }
    	    }

    	    stmt.executeBatch();
    	    conn.commit();

    	    System.out.println("Imported " + count + " rows successfully!");
    	    return count;

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
}
