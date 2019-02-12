<%@ page import="com.tcs.abc.bean.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body bgcolor="#F0E68C">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ABC Bank</title>

<!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/font-awesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="assets/css/form-elements.css">
        <link rel="stylesheet" href="assets/css/style.css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

        <!-- Favicon and touch icons -->
        <link rel="shortcut icon" href="assets/ico/favicon.png">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png">

<style>
	.form-horizontal{
    display:block;
    width:70%;
    margin:0 auto;
}

	.label{
		color:white;
		text-align: left;
		font-size: 25px;
		font-family: "Times New Roman", Times, serif;
	}
	
	p.ex1 {
		font-size: 12px;
		font-family: "Times New Roman", Times, serif;
	}
	
	div.col-sm-6 form-box{
		
		
    }
</style>

</head>
<script language = "javascript">
  function validate(){
	var ssn=document.getElementById("ssn").value;
	var id=document.getElementById("id").value;
	var name=document.getElementById("name").value;
	var age=document.getElementById("age").value;
	var address1=document.getElementById("address1").value;
	var address2=document.getElementById("address2").value;
	var city=document.getElementById("city").value;
	var state=document.getElementById("state").value;
	
	if(ssn =="" )
	{alert('Please enter SSNID');return false;}
	
	if(id=="" )
	{alert('Please enter Customer Id ');return false;}
	
	if(name =="" )
	{alert('Please enter name');return false;}
	
	if(age=="" )
	{alert('Please enter age ');return false;}
	
	if(address1 =="" )
	{alert('Please enter address1');return false;}
	
	if(address2=="" )
	{alert('Please enter address2 ');return false;}
	
	if(city =="" )
	{alert('Please enter city');return false;}
	
	if(state=="" )
	{alert('Please enter state ');return false;}
	
	
	
	if(ssn.length<=8){
		{alert('SSN: Please enter 9 numeric characters ');return false;}
		
	} 
	
	if(ssn.length>9){
		{alert('SSN: Please enter 9 numeric characters ');return false;}
		
	} 
	
	if(id.length<=8){
		{alert('Customer Id: Please enter 9 numeric characters ');return false;}
		
	} 
	
	if(id.length>9){
		{alert('Customer Id: Please enter 9 numeric characters ');return false;}
		
	}
	
	if(isNaN(ssn)){
 		{alert('SSN: Please enter numeric values only! '); return false;}
	}
 		
 	if(isNaN(id)){
 	 		{alert('Customer Id: Please enter numeric values only! '); return false;}

 	}
 	
 	if(isNaN(age)){
	 		{alert('Age: Please enter numeric values only! '); return false;}

	}
 	
		return true;
	}
</script>
<body>
		<%
			User u= (User) session.getAttribute("LoginAccExec");
			if(u!=null) {
		%>
<!-- Top menu -->
		<nav class="navbar navbar-inverse navbar-no-bg" role="navigation">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#top-navbar-1">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="CustomerExec.jsp">Team A Banking System!</a>
				</div>
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="top-navbar-1">
					<ul class="nav navbar-nav navbar-right">
						<li>
							<span class="li-text">
								Connect directly with us
							</span> 
							<a href="#"><strong>NOW!</strong></a> 
							<span class="li-text">
								Our social media contacts: 
							</span> 
							<span class="li-social">
								<a href="#"><i class="fa fa-facebook"></i></a> 
								<a href="#"><i class="fa fa-twitter"></i></a> 
								<a href="#"><i class="fa fa-envelope"></i></a> 
								<a href="#"><i class="fa fa-skype"></i></a>
								<button type="button" class="btn btn-primary active" onclick= "location.href = 'http://localhost:8080/TeamA_ABC_Bank/JSP/SuccessfullLogOut.jsp';">Log Out</button>
							</span>
						</li>
					</ul>
				</div>
			</div>
		</nav>



<!--  <div class="container">

<table align="center">

<form class="form-horizontal">
	<div class="col-xs-4">
	<div class="form-group form-group-sm">
		<label class="control-label" for="ssn">SSN</label>
    	<input type="text" class="form-control" name = "ssn" placeholder="Customer SSN:" required="true">
  	</div>
  	</div>
</form>

</table>
-->
			<div class="container-fluid">
  				<div class="row">
  					<div class="col-md-6 col-md-offset-3 form-box">
					<!--  <div class="col-sm-6 form-box">-->
                        	<div class="form-top">
                        		<div class="form-top-left">
                        			<h3>Create Customer</h3>
                            		<p>Key in customer details:</p>
                        		</div>
                        		<div class="form-top-right">
                        			<i class="fa fa-pencil"></i>
                        		</div>
                            </div>
                            <div class="form-bottom">
			                   
			                    <form data-toggle="validator"  method="post" action="<%=request.getContextPath()%>/BankServlet">
					
								  <div class="form-group">
								  	 <div class="form-inline row">
     								 <div class="form-group col-sm-6">	
								    <label for="ssn" class="control-label">Customer SSN<font color="red">*</font></label>
								    <input id="ssn" name="ssn" type="text" placeholder="Customer SSN:" style="width: 300px;" pattern="(.){9,9}" maxlength="9" required="true" />
								    <div class="help-block"><p class="ex1">Enter 9 Numbers only</p></div>
								    </div>
								    </div>
								  </div>
								  
								  <div class="form-group">
								  	 <div class="form-inline row">
     								 <div class="form-group col-sm-6">	
								    <label for="id" class="control-label">Customer ID<font color="red">*</font></label>
								    <input id="id" name="id" type="text" placeholder="Customer ID:" style="width: 300px;" maxlength="9" pattern="(.){9,9}"  required="true" />
								    <div class="help-block"><p class="ex1">Enter 9 Numbers only</p></div>
								    </div>
								    </div>
								  </div>
								  
								  <div class="form-group">
								  	 <div class="form-inline row">
     								 <div class="form-group col-sm-6">	
								    <label for="name" class="control-label">Name<font color="red">*</font></label>
								    <input id="name" name="name" type="text" placeholder="name:" style="width: 300px;" data-minlength="9"  maxlength="20" />
								    <div class="help-block"><p class="ex1"></p></div>
								    </div>
								    </div>
								  </div>
								  
								  <div class="form-group">
								  	 <div class="form-inline row">
     								 <div class="form-group col-sm-6">	
								    <label for="age" class="control-label">Age<font color="red">*</font></label>
								    <input id="age" name="age" type="number" placeholder="age" style="width: 300px;" pattern="(.){2,3}"  required="true" />
								    </div>
								    </div>
								  </div>
								  
								  <div class="form-group">
								  	 <div class="form-inline row">
     								 <div class="form-group col-sm-6">	
								    <label for="address1" class="control-label">First Address<font color="red">*</font></label>
								    <input id="address1" name="address1" type="text" placeholder="First Address" style="width: 300px;" required="true" />
								    </div>
								    </div>
								  </div>
								  
								  <div class="form-group">
								  	 <div class="form-inline row">
     								 <div class="form-group col-sm-6">	
								    <label for="address2" class="control-label">Second Address<font color="red">*</font></label>
								    <input id="address2" name="address2" type="text" placeholder="Second Address" style="width: 300px;" required="true" />
								    </div>
								    </div>
								  </div>
								  
								  <div class="form-group">
								  	 <div class="form-inline row">
     								 <div class="form-group col-sm-6">	
								    <label for="city" class="control-label">City<font color="red">*</font></label>
								    <input id="city" name="city" type="text" placeholder="city" style="width: 300px;" required="true" />
								    </div>
								    </div>
								  </div>
								  
								  <div class="form-group">
								  	 <div class="form-inline row">
     								 <div class="form-group col-sm-6">	
								    <label for="state" class="control-label">State<font color="red">*</font></label>
								    <input id="state" name="state" type="text" placeholder="state" style="width: 300px;" data-minlength="9" required="true" />				  
								    </div>
								    </div>
								  </div>
								  
								  <div>
								  		<input type="submit" class="btn btn-warning"  value="Create" name = "Create" onClick="return validate();"/>
	 									<input type="Reset" class="btn btn-warning" value="Reset" name = "Reset"/>
	 							</div>
								  
								  </div>
	</div>
 </div>
 </div>
<br>


<button type="button" class="btn btn-primary active" onclick="history.go(-1);">Back</button>
<!--  
</FORM>


<table border = "0">
<tr>
<th colspan="3">

<font color="blue"><h2> <u>Create Customer</h2></u></font>
<hr>
</th>

<tr bgcolor = "#F0E68C">
<tr>
<FORM METHOD = "POST" onsubmit="return validate()"  = "../BankServlet" >
<td><b>Customer SSN: <b></td>
<td>
<input type="text" size = "20" name = "ssn" required></td>


</tr><td><b>Customer ID: <b></td>
<td>
<input type="text" size = "20" name = "id" required></td>
</tr><tr bgcolor = "#F0E68C">
<td><b>Customer Name: <b></td>
<td>
<input type="text" size = "20" name = "name" required></td>
</tr>
<tr bgcolor = "#F0E68C">
<td><b>Age: <b></td>
<td>
<input type="text" size = "20" name = "age" required></td>
</tr>
<tr bgcolor = "#F0E68C">
<td><b>Address Line 1: <b></td>
<td>
<input type="text" size = "20" name = "address1" required></td>
</tr>
<tr bgcolor = "#F0E68C">
<td><b>Address Line 2: <b></td>
<td>
<input type="text" size = "20" name = "address2" required></td>
<tr><td></td><tr bgcolor = "#F0E68C">
<td><b>City: <b></td>
<td>
<input type="text" size = "20" name = "city" required></td>
<tr><td></td><tr bgcolor = "#F0E68C">
<td><b>State: <b></td>
<td>



 
<input type="text" size = "20" name = "state" required></td>
<tr><td></td><td><INPUT TYPE = "Submit" value = "Create" name = "Create">
&nbsp;&nbsp;&nbsp;
<INPUT TYPE = "Reset" value = "Clear"></td></tr>
</tr>

</center>
</FORM>
-->

	<%
			}else {
		%>
			<div class="col-sm-7 text" style = "width : 1030px;">
        	 
                            <h1><font color="#ffffff"><strong>ABC</strong> Investment Bank</font></h1>
                            <div class="description">
                            	<p>
	                            	<font color="#ffffff">Please Login to access this page.</font>
	                            	<button type="button" class="btn btn-primary active" onclick="location.href = 'http://localhost:8080/TeamA_ABC_Bank/index.jsp';">Login</button><br>
                            	</p>
                            	
                            </div>
            </div>
            
        <%
			}
		%>


<!-- Javascript -->
        <script src="assets/js/jquery-1.11.1.min.js"></script>
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/js/jquery.backstretch.min.js"></script>
        <script src="assets/js/retina-1.1.0.min.js"></script>
        <script src="assets/js/scripts.js"></script>
        
        <!--[if lt IE 10]>
            <script src="assets/js/placeholder.js"></script>
        <![endif]-->
        <div><center>
<p><font color="white"> &copy; 2017 ABC Bank</font></p></center>
</div>
</html>