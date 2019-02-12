<%@ page import="com.tcs.abc.bean.Account" %>
<%@ page import="com.tcs.abc.bean.Customer" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>

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

ArrayList <Account> myList = (ArrayList<Account>)request.getAttribute("CustList");

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
							</span>
						</li>
					</ul>
				</div>
			</div>
		</nav>


<center>
<table border = "0">
<tr>
<th colspan="3">

<h2><font color='#ffffff'>Customer's Accounts</font></h2>


<font color="white"  face = "Arial" ><center><h5> Please press delete to delete Customer's respective account.</h5></center></font>
 
 <br></th>

</th>



	<div  class="table-responsive">
									 <!--  <div class="panel panel-default"> -->
									 <table class="table table-bordered table-hover" >
									
										
									
									 	 <tr class="success" align = "center"><th align = "center"><b><center><font color = "white" face = "Arial">Cust ID</center></b></th><TH><b><center><font color = "white" face = "Arial">Acc ID</b></center></TH><TH><b><center><font color = "white" face = "Arial">Acc Type</center></b></TH><TH><b><center><font color = "white" face = "Arial">Balance</center></b></TH><TH><b><center><font color = "white" face = "Arial">Acc Credited Date</center></b></TH><TH><b><center><font color = "white" face = "Arial">Last Transaction Date</center></b></TH><TH><b><center><font color = "white" face = "Arial">Delete</b></font></center></TH></tr>
										
										<%


for (Account a:myList)
{
%>
										<tr bgcolor="#edeff2"><td align = "center"><%= a.getWs_cust_id() %> </a></t><TD><%= a.getWs_acct_id() %></TD><TD><%= a.getWs_acct_type() %></TD><TD><%= a.getWs_acct_balance()  %></TD><TD><%= a.getWs_acct_crdate() %></TD><TD><%= a.getWs_acct_lasttrdate() %></TD><TD> <center><a href = "<%= request.getContextPath()%>/BankServlet?accId=<%= a.getWs_acct_id() %>&Delete=Delete">Delete</a> </center></TD></tr>
										<%
}

	
	
%>
									 </table>
									 
									 </div>
									 </div>



</FORM></TH></TR>





<!-- Javascript -->
        <script src="assets/js/jquery-1.11.1.min.js"></script>
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/js/jquery.backstretch.min.js"></script>
        <script src="assets/js/retina-1.1.0.min.js"></script>
        <script src="assets/js/scripts.js"></script>
        
        <!--[if lt IE 10]>
            <script src="assets/js/placeholder.js"></script>
        <![endif]-->

<button type="button" class="btn btn-primary active" onClick="location.href = 'http://localhost:8080/TeamA_ABC_Bank/JSP/CustomerExec.jsp';">Back</button>
<button type="button" class="btn btn-primary active" onClick="history.go(0)">Refresh</button>
</body>


</html>