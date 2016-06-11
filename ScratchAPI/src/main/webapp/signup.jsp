
<html>
<head>
<meta charset="UTF-8">
<title>Signup</title>
<link rel="stylesheet" type="text/css" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet" href="css/form-elements.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="js/signup.js"></script>
</head>

<body style="background-image: url('image/1.jpg');">
<h3 style =color:red><%if(request.getParameter("message") != null){out.write(request.getParameter("message"));}  %></h3>
<div id="addResultDiv" style="color: red"></div>
<form id="userForm" name="userForm">
<p id="msg"></p>
<div class="container">
<div class="row">
  		<div class="col-md-2"></div>
  		<div class="col-md-8">
    <h1 class="well well-sm" align="center">Registration Form</h1>
	<div class="col-lg-12 well">
	<div class="row">
				
					<div class="col-sm-12">
						<div class="row">
							<div class="col-sm-6 form-group">
								<label>Net Id</label>
								<input type="text" placeholder="Enter NetId..." class="form-control" name="netId" id="netId" required>
							</div>
							<div class="col-sm-6 form-group">
								<label>Password</label>
								<input type="password" placeholder="Enter Password..." class="form-control" name="passowrd" id="password" required>
							</div>
						</div>	
						<div class="row">
							<div class="col-sm-6 form-group">
								<label>Confirm Password</label>
								<input type="password" placeholder="Confirm Password..." class="form-control" name="confirmpassowrd" id="confirmpassword" required>
							</div>
							<div class="col-sm-6 form-group">
								<label>DepartmentId</label>
								<input type="text" placeholder="Enter Department Id..." class="form-control" name="deptId" id="deptId" required>
							</div>
							
						</div>	
						
						<div class="row">
							<div class="col-sm-6 form-group">
								<label>First Name</label>
								<input type="text" placeholder="Enter First Name..." class="form-control" name="firstname" id="name1" required>
							</div>
							<div class="col-sm-6 form-group">
								<label>Last Name</label>
								<input type="text" placeholder="Enter Last Name..." class="form-control" name="lastname" id="name2" required>
							</div>
						</div>						
				<div class="row">
					
							<div class="col-sm-6 form-group">
						<label>Role</label>
						<input type="text" placeholder="Enter Role..." class="form-control" name="role" id="role" required>
					</div>
					
					<div class="col-sm-6 form-group">
								<label>Team Id</label>
								<input type="text" placeholder="Enter Team Id..." class="form-control" name="teamId" id="teamId" required>
					</div>
				</div>	
				<div class="row">
					<div class="col-sm-6 form-group">
								<label>Course</label>
								<input type="text" placeholder="Course..." class="form-control" name="course" id="course" required>
					</div>	
					<div class="col-sm-6 form-group">
						<label>Email Address</label>
						<input type="text" placeholder="Enter Email Address..." class="form-control" name="email" id="email" required>
					</div>	
				</div>
						<input type="submit" class="btn btn-primary" value="Signup"/>					
				</div>
				</div>
	</div>
	</div>
	<div class="col-md-2"></div>
	</div>
	</div>
</form> 
</body>
</html>
	