              

$(document).ready(
	function() {
				$("#userForm").submit(function() {
					//alert("hello");
					//console.log($(this).serializeArray());
					//matchpass();
					netId = $(this).find("#netId").val();
					password = $(this).find("#password").val();
					confirmpassword=$(this).find("#confirmpassword").val();
					deptId = $(this).find("#deptId").val();
					firstname = $(this).find("#name1").val();
					lastname = $(this).find("#name2").val();
					role = $(this).find("#role").val();
					teamId = $(this).find("#teamId").val();
					course=$(this).find("#course").val();
					email = $(this).find("#email").val();
					console.log(firstname+ " " +lastname);
					if(!(password==confirmpassword))
						{
						
							//$("#netId").parent().after("<div style='color:red;margin-bottom: 10px;'>Please enter email address</div>");
							alert("Password is not same");
						}
					else
						{
						
						
					//alert(firstname);
					var arr = {
						"netId" : netId,
						"password" : password,
						"deptId" : deptId,
						"firstname" : firstname,
						"lastname" : lastname,
						"role": role,
						"teamId" : teamId,
						"course" : course,
						"email": email
					};
					$.ajax({
						type : 'post',
						url : 'http://localhost:8090/ScratchAPI/webapi/user/add',
						contentType : 'application/json',
						data : JSON.stringify(arr),
						success : function(result) {
							
							if(result==="user already exist with this netId")
								{
									alert(result);
									window.location='signup.jsp';
								}
						else{
						    alert(result+ ". Click OK to Login");
							window.location='login.jsp';
						}
						},
						failure : function(result) {
							$('#addResultDiv').html('');
							$('#addResultDiv').html(result);
							//alert(result);
						}
						
						
					});}
					return false;					
				});
});

