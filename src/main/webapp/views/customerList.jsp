<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registered Customer Details List</title>
<link rel="stylesheet" href="/resources/static/css/style1.css">
</head>
<body>

<div align="center">
Welcome ${customer.fname} ${customer.lname }
<div align="right"><a href="logout">Log out
<%
out.print(request.getSession().getAttribute("user"));
%></a></div>
<hr>
    <h1>Customer List </h1>
    <img src="/resources/static/images/indeximg.jpg"><br><br>

    <br/><br/>
    <table border="1" cellpadding="10">
        <thead>
            <tr>
                <th>PhoneNo.</th>
                <th>Email Id</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="product" items="${listProducts}">
        

							<!-- construct an "delete" link with customer id -->
							<c:url var="deleteLink" value="/delete">
								<c:param name="id" value="${product.id}" />
							</c:url>
        
            <tr>
                <td>${customer.phoneNo}</td>
                <td>${customer.emailId}</td>
                <td>${customer.firstName}</td>
                <td>${customer.lastName}</td>
                <td>
                   	<!-- display the update link --> 
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