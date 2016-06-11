<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="org.scratchcard.Model.Signup"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<%Signup sess=(Signup)session.getAttribute("user");

%>
<body style="background-color:lightgrey">
	<div class="container">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				
					<div class="panel-body">
						<div class="page-header" align="center">
  							<%if(!(sess==null)) session.invalidate();
  							out.write("<h2 style=color:Red >You have logged out Successfully</h2>"); %>
  							<a href ="login.jsp"><font color="Red" style="align:right"><h4>Login Here</h4></font></a>
						</div>			
																	
					</div>
				
			</div>
			<div class="col-md-3"></div>
		</div>
	</div>	
</body>
</html>