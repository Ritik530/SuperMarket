<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="include/header.jsp" %>
</head>
<style>
.product-form{
margin:2px; 
width:600px;
padding:20px;
background:#f9f9f9;
border:1px solid #333;
}

</style>

<body>
<%@include file="include/navbar.jsp" %>
<div class = "main" style= "margin-left: 100px;" >
     <h2>Add New Product</h2>
    <section class="form-center col-md">
          <div class="container">
             <div class = "product-form" style= "margin-left: 100px;" >
               <form action="insertdb" method="post" >

              
                <div class="form-group col-md">
                    <label for="inputname" class="form-label">Product Name</label>
                    <input type="text" class="form-control" name="productname" id="inputname" placeholder="Product Name">
                </div>
                <div class="form-group col-md">
                    <label for="inputcategory" class="form-label">Product Category</label>
                    <input type="text" class="form-control" name="productcategory" id="inputcategory" placeholder="Product Category">
                </div>

                <div class="form-group col-md">
                    <label for="inputprice" class="form-label">Product Price</label>
                    <input type="text" class="form-control" name="productprice" id="inputprice" placeholder="Product Price">
                </div>
                <div class="form-group col-md">
                    <label for="inputquantity" class="form-label">Product Quantity</label>
                    <input type="text" class="form-control" name="productquantity" id="inputquantity" placeholder="Product Quantity">
                </div>
            
            
                <div class="form-group col-md">
                     <label for="formFileMultiple" class="form-label">Product Image</label>
                     <input class="form-control" type="file" name= "productimage" id="formFileMultiple" multiple>
                 </div>
                 
                 <div>
                     <input type="submit" name="insert" id="insert"
                     class="form-submit" value="Submit">
                 
                 
                 </div>
              

             </form>

     </div>

    </div>

  </section>

</div>


<%@include file="include/footer.jsp" %>
</body>
</html>