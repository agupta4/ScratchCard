
<html>
<head>
<meta charset="UTF-8">
<title>Professor Page</title>
<link rel="stylesheet" type="text/css" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet" href="css/form-elements.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="js/professor.js"></script>
</head>

<body style="background-image: url('image/1.jpg');">

<%
    String h=(String)session.getAttribute("total");
	
%>
<div id="addResultDiv" style="color: red"></div>
<p id="msg"></p>
<div class="container">
<div class="row">
  		<div class="col-md-1"></div>
  		<div class="col-md-10">
  		<form method="link" action="index.jsp">
    <h1 class="well well-sm" align="center" style="color :green">Test Is Submitted Successfully</h1>
	<div class="col-lg-12 well">
	
				<div class="row">
							<div class="col-sm-6 form-group">
								<h3>Your Final Score for this test is:-<%out.println(h);%></h3>
							</div>
							<div class="col-sm-6 form-group">
								<button class = "btn btn-primary" style="float:right;" >Logout</button>
							</div>
						</div>				
				</div>
				</form>
				
	</div>
	</div>
	
	<div class="col-md-1"></div>
	</div>
</body>
</html>
	