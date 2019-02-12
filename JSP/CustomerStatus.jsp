<%@ page import="com.tcs.abc.bean.User" %>
<%@ page import="com.tcs.abc.bean.Customer;" %>
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

</head>
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
		
<form method="POST" action="../BankServlet">
	<%Customer customer1= (Customer)session.getAttribute("customer"); %>
<center>

<table border = "0">
<th colspan="3">

<h2><font color="white"> Please press List to list all customers in the system</h2>

</table>
</center>
	<br>
	<button type="submit" class="btn btn-warning" name="ListCustomers" value="List">List Customer</button>
	<br>
	<br>
	<button type="button" class="btn btn-primary active" onclick="history.go(-1);">Back</button>
</FORM>
<%
			}else {
		%>
			<div class="col-sm-7 text" style = "width : 1030px;">
        	 
                            <h1><font color="#ffffff"><strong>ABC</strong> Investment Bank</font></h1>
                            <div class="description">
                            	<p>
	                            	<font color="#ffffff">Please Login to access this page.</font>
	                            	<button type="button" class="btn btn-primary active" onclick="location.href = 'http://localhost:8080/TeamA_ABC_Bank/index.jsp';">Login</button>
                            	</p>
                            	
                            </div>
            </div>
            
        <%
			}
		%>
		
		<div>
			<br>
			<p><center><font color="white"> &copy; 2017 ABC Bank</font></center></p>
		</div>
		
		
<!-- Javascript -->
        <script src="assets/js/jquery-1.11.1.min.js"></script>
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/js/jquery.backstretch.min.js"></script>
        <script src="assets/js/retina-1.1.0.min.js"></script>
        <script src="assets/js/scripts.js"></script>
        
        <!--[if lt IE 10]>
            <script src="assets/js/placeholder.js"></script>
        <![endif]-->



</body>


</html>