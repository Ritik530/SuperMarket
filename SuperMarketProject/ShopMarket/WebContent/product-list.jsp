<%@page import ="java.util.List" %>
<%@page import ="com.ecommerce.model.Product" %>
<%@page import ="com.connection.Dbcon" %>
<%@page import ="com.ecommerce.dao.ProductDao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
ProductDao pd = new ProductDao(Dbcon.getConnection());
List<Product> products = pd.getAllProducts();
%>
<!DOCTYPE html>
<html>
<head>
<%@include file="include/header.jsp" %>
</head>
<body>
<%@include file="include/navbar.jsp" %>
 <div class = "row">
    <div class = container>
    <h3 class="text-center">List All Product </h3>
    <hr>
    <div class = "container text=left">
    <a href ="<%=request.getContextPath()%>/insertdata.jsp"> Add New Product</a>
    
    </div>
    <br>
    <table class = "table table-bordered">
      <thead>
         <tr>
            <th>ID</th>
            <th>Product Name</th>
            <th>Product category</th>
            <th>Product Price</th>
            <th>Quantity</th>   
            <th>date</th>
            <th>Delete</th>
         </tr>
      </thead>
      <tbody>
       <%
          if(!products.isEmpty()){
          	for(Product p:products){%>
          <tr>
         
      
             <td><%= p.getId() %></td>
             <td><%= p.getName() %></td>
             <td><%= p.getCategory()%></td>
             <td><%= p.getPrice() %></td>
             <td><%= p.getQuantity() %></td>
             <td><%= p.getProductdate() %></td>
             <td><a href="delete?id=<%= p.getId() %>">Delete</a></td>  
               <%}
              }
        	
       %>
          </tr>
         
      
      
      
      </tbody>
    
    
    </table>
    
    </div>
    </div>



<%@include file="include/footer.jsp" %>
</body>
</html>