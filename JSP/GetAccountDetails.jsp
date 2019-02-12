
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body bgcolor="#F0E68C">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ABC Bank</title>
</head>
<body>

<font color="blue"  face = "Arial" ><center><h2> <u>ABC Bank</h2></center></u></font>
<hr>
<center>
<table border = "0">
<tr>
<th colspan="3">

<font color="blue"><h2> <u>Retrieve Customer's Account</h2></u></font>

<hr>
<font color="blue"  face = "Arial" ><center><h5> Please enter either Customer's SSN or Customer ID to retrieve their account details.</h5></center></font>
</th>

<tr bgcolor = "#F0E68C">


<FORM METHOD = "POST" ACTION = "../BankServlet" >

<td><input type="radio" name="selection7" value="SSN"> Customer SSN<br> </td>
<td>
<input type="radio" name="selection4" value="ID"> Customer ID<br></td>
</tr><tr bgcolor = "#F0E68C">

<td>
</table>
<input type="text" size = "20" name = "AccountSelectionNumber" required></td>
</tr>
<br><br>
<tr><td><INPUT TYPE = "Submit" value = "Submit" name = "RetrieveAccount">
&nbsp;&nbsp;&nbsp;
<INPUT TYPE = "Reset" value = "Clear"></td></tr>
</tr>

</center>
</FORM>
</body>
</html>