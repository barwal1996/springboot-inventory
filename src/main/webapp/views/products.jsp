<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Manager</title>
<link rel="stylesheet" href="./resources/static/css/style1.css">
</head>
<body>

<div align="center">
Welcome ${dealer.fname} ${dealer.lname }  -${dealer.address.city}
<div align="right"><a href="logout">Log out
<%
out.print(request.getSession().getAttribute("user"));
%></a></div>
<hr>
    <h1>Product List</h1>
    <img src="/resources/static/images/indeximg.jpg"><br><br>
    <hr>
    <a href="/new">Create New Product</a>
    <br/><br/>
    <table border="1" cellpadding="10">
        <thead>
            <tr>
                <th>Product ID</th>
                <th>Name</th>
                <th>Brand</th>
                <th>Made In</th>
                <th>Price</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="product" items="${listProducts}">
        
         <!-- construct an "update" link with customer id -->
							<c:url var="updateLink" value="/edit">
								<c:param name="id" value="${product.id}" />
							</c:url>

							<!-- construct an "delete" link with customer id -->
							<c:url var="deleteLink" value="/delete">
								<c:param name="id" value="${product.id}" />
							</c:url>
        
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.brand}</td>
                <td>${product.madein}</td>
                <td>${product.price}</td>
                <td>
                   	<!-- display the update link --> 
									<a href="${updateLink}">Update</a>
									| <a href="${deleteLink}"
									onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
                </td>
               
            </tr>
             </c:forEach>
        </tbody>
    </table>
</div>   
</body>
</html>