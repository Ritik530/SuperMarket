
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
    <div class = "container">
    <div class="card-header my-3"> All Product View </div>
    <div class = "row">
    <%
        if(!products.isEmpty()){
        	for(Product p:products){%>
        		 <div class = "col-md-3 my-3">
                 <div class="card w-100" style="width: 18rem;">
                    <img class="card-img-top" src="<%= p.getImage()%>" alt="Product Image" width="400px" height="300px">
                    <div class="card-body">
                    <h5 class="card-title"><%= p.getName() %></h5>
                    <h6 class="price">Price: $<%= p.getPrice() %></h6>
                    <h6 class="category">Category: <%= p.getCategory() %></h6>
                    <h6 class="Quantity">Quantity: <%= p.getQuantity() %></h6>
                    <div class="mt-3 d-flex justify-content-between">
                        <a href="#" class="btn btn-primary">Add to Cart</a>
                        <a href="#" class="btn btn-primary">Buy</a>
                    </div>
                 </div>
               </div>
            
               </div>
        	<%}
        }
    %>
      
    
    
    </div>
    
    </div>

<%@include file="include/footer.jsp" %>
</body>
</html>