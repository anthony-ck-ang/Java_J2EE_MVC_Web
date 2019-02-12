<%@ page import="com.tcs.abc.bean.User" %>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Account Executive Page</title>

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

	</script>
    <body>
		<%
			User u= (User) session.getAttribute("LoginAccExec");
			if(u!=null) {
		%>
		<!-- Top menu -->
		<nav class="navbar navbar-inverse navbar-no-bg" role="navigation" style="margin-left: 100px;margin-right: 225px;">
			<div class="container" >
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#top-navbar-1">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">ABC Banking System!</a>
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

        <!-- Top content -->
       		<div>
       			<table align = "left">
					<tr><td><u><font color = "white"><b></b></font></u></td></tr>
					<tr><td WIDTH="100"></td><td><font color = "white"><font color = "white" face = "Arial">Welcome <b><%=u.getUsername() %> (Accounts Executive)!</font></td></tr>
					<tr><td></td></tr>
				</table>
			</div>
        <!--  <div class="top-content">
        	 <div class="col-sm-7 text" style = "width : 1030px;">-->
        	 
                            <!--<h1><strong>ABC</strong> Investment Bank</h1>
                             <div class="description">
                            	<p>
	                            	World Class Banking system!
	                            	
                            	</p>
                            	
                            </div>-->
            <div class="inner-bg" style=" padding-top: 30px; padding-bottom: 30px;">
                <div class="container" style="margin-left: 420px;">
                    <div class="row">
                    	
                    	
                    	<form method="post" action="BankServlet" align = 'center' style = "width: 505px;">
                    	
								<div  class="table-responsive">
									 <div class="panel panel-default"> 
									 <table class="table table-bordered table-hover" col width="1320"> 
									
										 <tr class="success"><td  align = "center"><font color="#ffffff" ><b><font color = "white" face = "Arial">Account Executive's Raison d'être</b></font> </td></tr>
									
									 	<tr bgcolor="#edeff2" ><td align = "center"><a href="http://localhost:8080/TeamA_ABC_Bank/JSP/CreateCustomer.jsp">Create Customer</a></td></tr>
										<tr bgcolor="#edeff2"><td align = "center"><a href="http://localhost:8080/TeamA_ABC_Bank/JSP/UpdateCustomer.jsp">Update Customer</a></td></tr>
										<tr bgcolor="#edeff2"><td align = "center"><a href="http://localhost:8080/TeamA_ABC_Bank/JSP/DeleteCustomer.jsp">Delete Customer</a></td></tr>
										<tr bgcolor="#edeff2"><td align = "center"><a href="http://localhost:8080/TeamA_ABC_Bank/JSP/CreateAccount.jsp">Create New Account for Customer</a></td></tr>
									 	<tr bgcolor="#edeff2"><td align = "center"><a href="http://localhost:8080/TeamA_ABC_Bank/JSP/DeleteAccount.jsp">Delete Account for Customer</a></td></tr>
									 	<tr bgcolor="#edeff2"><td align = "center"><a href="http://localhost:8080/TeamA_ABC_Bank/JSP/CustomerStatus.jsp">View Customer Status</a></td></tr>
									 	<tr bgcolor="#edeff2"><td align = "center"><a href="http://localhost:8080/TeamA_ABC_Bank/JSP/AccountStatus.jsp">View Account Status</a></td></tr>
									 	<tr bgcolor="#edeff2"><td align = "center"><a href="http://localhost:8080/TeamA_ABC_Bank/JSP/FindCustMain.jsp">Search for Customers</a></td></tr>
									 	
									 
									 </table>
									 
									 </div>
									 </div>
								
							</form>
                       
                           <!--  <div class="top-big-link">
                            	<a class="btn btn-link-1" href="#">Button 1</a>
                            	<a class="btn btn-link-2" href="#">Button 2</a>
                            </div> -->
                        </div>
                        <div class="col-sm-5 form-box">
                        	<!-- <div class="form-top">
                        		<div class="form-top-left">
                        			<h3>Log In</h3>
                            		<p>Key in your Log in details:</p>
                        		</div>
                        		<div class="form-top-right">
                        			<i class="fa fa-pencil"></i>
                        		</div>
                            </div> -->
                            <!-- <div class="form-bottom">
			                   
			                    <form data-toggle="validator" role="form" method="post" action="../BankServlet">
								  <div class="form-group">
								  <div class="form-inline row">
     								 <div class="form-group col-sm-6">	
								    <label for="inputName" class="control-label">Username</label>
								    <input type="text" onClick=" return checkUnameLength(this)"data-minlength="8"class="form-control" name = "uName" id="inputName" placeholder="Enter your username here" required>
								    <input id="username" name="uName" type="text" placeholder="Enter your Username here" style="width: 200px;" data-minlength="8" required />
								    
								    <div class="help-block">Minimum of 8 characters</div>
								  </div>
								  </div>
								  </div>
								  <div class="form-group">
								  	 <div class="form-inline row">
     								 <div class="form-group col-sm-6">	
								    <label for="inputPassword" class="control-label">Password</label>
								<input type="password" data-minlength="10" onClick="return checkPwdLength(this)"class="form-control" name = "uPass"id="inputPassword" placeholder="Password" required>
								    <input id="password" name="uPass" type="password" placeholder="Enter your password here" style="width: 200px;"  data-minlength="10" required />

								    <div class="help-block">Minimum of 10 characters</div>
								    </div>
								    </div>
								  </div> -->
								  <!-- <div class="form-group has-feedback">
								    <label for="inputTwitter" class="control-label">Twitter</label>
								    <div class="input-group">
								      <span class="input-group-addon">@</span>
								      <input type="text" pattern="^[_A-z0-9]{1,}$" maxlength="15" class="form-control" id="inputTwitter" placeholder="1000hz" required>
								    </div>
								    <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
								    <div class="help-block with-errors">Hey look, this one has feedback icons!</div>
								  </div>
								  <div class="form-group">
								    <label for="inputEmail" class="control-label">Email</label>
								    <input type="email" class="form-control" id="inputEmail" placeholder="Email" data-error="Bruh, that email address is invalid" required>
								    <div class="help-block with-errors"></div>
								  </div> -->
								  
								     <!--  <div class="form-group col-sm-6">
								        <input type="password" class="form-control" id="inputPasswordConfirm" data-match="#inputPassword" data-match-error="Whoops, these don't match" placeholder="Confirm" required>
								        <div class="help-block with-errors"></div>
								      </div> -->
								  
								  <!-- <div class="form-group">
								    <div class="radio">
								      <label>
								        <input type="radio" name="underwear" required>
								        Boxers
								      </label>
								    </div>
								    <div class="radio">
								      <label>
								        <input type="radio" name="underwear" required>
								        Briefs
								      </label>
								    </div>
								  </div> -->
								  <!-- <div class="form-group">
								    <div class="checkbox">
								      <label>
								        <input type="checkbox" id="terms" data-error="Before you wreck yourself" required>
								        Check yourself
								      </label>
								      <div class="help-block with-errors"></div>
								    </div>
								  </div> -->
<!-- 								  <div class="form-group"> -->
<!-- 								    <input type="submit" class="btn btn-primary" onClick= "return checkLength()" value="Log In" name = "Login"> -->
<!-- 								  </div> -->
<!-- 								</form> -->
		                    
                        </div>
                    </div>
                </div>
            </div>
            
        <%
			}else {
		%>
			<div class="col-sm-7 text" style = "width : 1030px;">
        	 
                            <h1 style="
    margin-left: 400px;">
                            ><font color="#ffffff"><strong>ABC</strong> Investment Bank</font></h1>
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
<p><font color="white"> &copy; 2017 ABC Bank</font></p>
</html>