package com.db.insert;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.ecommerce.model.Product;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	// Driver Code
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		switch(action) {
		case "/insertdb":
			doPost(request, response);
			break;
		case "/delete":
			deleteproduct(request,response);
			break;
		default:
			listproduct(request, response);
			break;
		}
	}
	
	protected void listproduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> products = new ArrayList<Product>();
		request.setAttribute("products", products);
		RequestDispatcher dispatcher = request.getRequestDispatcher("product-list.jsp");
		dispatcher.forward(request, response);
		
	}
	
	
//	Delete data in the database
	
	protected void deleteproduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    int id = Integer.parseInt(request.getParameter("id"));
			RequestDispatcher dispatcher = null;
			Connection con = null;
			try {
//				 Register Driver Class
				Class.forName("com.mysql.cj.jdbc.Driver");
				
//				Connection to your database
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce_cart","onserver","onserver");
				
//				Connection to your database
//				A PreparedStatement is a pre-compiled SQL statement
				PreparedStatement pst = con.prepareStatement("delete from products where id=?");
//				  Set Parameters
				pst.setInt(1, id);
			

//		         Execute SQL query
				int rowCount = pst.executeUpdate();
//				 path is a string specifying the pathname to the resource
				dispatcher = request.getRequestDispatcher("product-list.jsp");
				if(rowCount  > 0) {
					request.setAttribute("Status", "success");
				}else {
					request.setAttribute("Status", "failed");
				}
				dispatcher.forward(request,response);
				
				
			}
			catch (Exception e){
				e.printStackTrace();
				}finally {
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			
		
		
		
	}
	
//	insert all data in database

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String name = request.getParameter("productname");
		String category = request.getParameter("productcategory");
		String price = request.getParameter("productprice");
		String quantity = request.getParameter("productquantity");
		String image = request.getParameter("productimage");
		RequestDispatcher dispatcher = null;
		Connection con = null;
		try {
//			 Register Driver Class
			Class.forName("com.mysql.cj.jdbc.Driver");
			
//			Connection to your database
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce_cart","onserver","onserver");
			
//			Connection to your database
//			A PreparedStatement is a pre-compiled SQL statement
			PreparedStatement pst = con.prepareStatement("insert into products(name,category,price,quantity,image) values (?,?,?,?,?)");
//			  Set Parameters
			pst.setString(1, name);
			pst.setString(2, category);
			pst.setString(3, price);
			pst.setString(4, quantity);
			pst.setString(5, image);
			
			

//	         Execute SQL query
			int rowCount = pst.executeUpdate();
//			 path is a string specifying the pathname to the resource
			dispatcher = request.getRequestDispatcher("index.jsp");
			if(rowCount  > 0) {
				request.setAttribute("Status", "success");
			}else {
				request.setAttribute("Status", "failed");
			}
			dispatcher.forward(request,response);
			
			
		}
		catch (Exception e){
			e.printStackTrace();
			}finally {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		
	}
	

}
