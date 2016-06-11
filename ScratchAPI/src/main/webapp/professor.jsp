
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
<div id="addResultDiv" style="color: red"></div>
<p id="msg"></p>
<div class="container">
<div class="row">
  		<div class="col-md-1"></div>
  		<div class="col-md-10">
  		
    <h1 class="well well-sm" align="center">Student's details</h1>
	<div class="col-lg-12 well">
				<div class="row">
								
						<div class="row">
							<div class="col-sm-6 form-group">
								<div id = "button" style = "text-align:left;">
							<button class = "btn btn-primary" onclick="function1();">Get Students</button>
						</div>							</div>
						<form method="link" action="index.jsp">
							<div class="col-sm-6 form-group">
								<div id = "button" style = "text-align:left;">
							<button class = "btn btn-primary" style="float:right">Logout</button>
						</div>	
							</div>
							</form>
						</div>				
											
				</div>
					<div>
  							<table class="table table-condensed" id="userdata" >
  								<thead>
  									<tr>
  										<th>MemberId</th>
  										<th>NetId</th>
  										<th>FirstName</th>
  										<th>LastName</th>
  										<th>Role</th>
  										<th>TeamId</th>
  										<th>CourseName</th>
  										<th>DeptId</th>
  										<th>Email</th>
  									</tr>
  								</thead>
  								</table>
  								</div>
				</div>
				
	</div>
	
	</div>
	
	<div class="col-md-1"></div>
	</div>
</body>
</html>
	