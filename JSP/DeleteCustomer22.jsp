<%@ page import="com.tcs.abc.bean.Customer;" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body bgcolor="#F0E68C">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ABC Bank</title>
</head>
<body>

<form method="POST" action="BankServlet">
<%
Customer customer1= (Customer)session.getAttribute("customer"); %>

<center>
<table border = "0">
<tr>
<th colspan="3">

<font color="blue"><h2> <u>Please confirm customer details to delete their account: </h2></u></font>
<hr>
<center><table style="width:80%" border ='1'>
 
  <tr>
    <td><font face="verdana" color="blue" size = "2">Customer SSN:</td>
    <td> <%= customer1.getWs_ssn() %> </td> 
  
  </tr>
  <tr>
    <td><font face="verdana" color="blue" size = "2">Customer ID:</td>
    <td><%= customer1.getWs_cust_id() %> </td>
    
  </tr>
    <tr>
    <td><font face="verdana" color="blue" size = "2">Age:</td>
    <td> <%= customer1.getWs_age() %></td>
    
  </tr>
    <tr>
    <td><font face="verdana" color="blue" size = "2">Address:</td>
    <td> <%= customer1.getWs_adrs() %> </td>
  
  </tr>
</center>
</th>
</table>
<td><input type="hidden" size = "20" value = <%=customer1.getWs_cust_id() %> name = "custid" required></td>
<table style="width:90%" border ='0'>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<tr>
				<td align="center"><input type="submit" name="DeleteCustomerLatest" value="Delete"></td>
			</tr>
</tr>
</table>
</center>
</FORM>

<h4><a href="/CaseStudy/JSP/DeleteCustomer.jsp"><p align="left">Back</a> </h4></left>
</body>


</html>