package com.ecommerce.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.ecommerce.model.*;





public class ProductDao {
	
	private Connection connection;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;

	public ProductDao(Connection connection) {
		
		this.connection = connection;
	}
	// View all date in index file 
	public List<Product> getAllProducts(){
		List<Product> products = new ArrayList<Product>();
		try {
//			Connection is  in the Dbcon file 
//			 Query which needs parameters
			query = "select *from products";
			
//			 Prepare Statement
			pst = this.connection.prepareStatement(query);
			
           	// Execute SQL query
			rs = pst.executeQuery();
			
//			  Display function to show the Resultset
			while(rs.next()) {
				Product row = new Product();
				row.setId(rs.getInt("id"));
				row.setName(rs.getString("name"));
				row.setCategory(rs.getString("category"));
				row.setPrice(rs.getString("price"));
				row.setQuantity(rs.getString("quantity"));
				row.setImage(rs.getString("image"));
				row.setProductdate(rs.getString("productdate"));
				
				products.add(row);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return products;
		
	}


	


}
