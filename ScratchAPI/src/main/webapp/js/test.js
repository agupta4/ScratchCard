function validate()
					{
						
						if(document.userForm.netId.value=="")
							{
								alert("Please provide the NetID");
								document.userForm.netId.focus();
								return false;
							}
						if(document.userForm.password.value=="")
							{
								alert("Please provide the Password");
								document.userForm.password.focus();
								return false;
							}
						if(document.userForm.confirmpassword.value=="")
						{
							alert("Please Confirm the Password");
							document.userForm.confirmpassword.focus();
							return false;
						}
						if(document.userForm.deptId.value=="")
						{
							alert("Please provide the Department ID");
							document.userForm.deptId.focus();
							return false;
						}
						if(document.userForm.name1.value=="")
						{
							alert("Please provide the First Name");
							document.userForm.name1.focus();
							return false;
						}
						if(document.userForm.name2.value=="")
						{
							alert("Please provide the Last Name");
							document.userForm.name2.focus();
							return false;
						}
						if(document.userForm.role.value=="")
						{
							alert("Please provide the Role");
							document.userForm.role.focus();
							return false;
						}
						if(document.userForm.teamId.value=="")
						{
							alert("Please provide the TeamID");
							document.userForm.teamId.focus();
							return false;
						}
						if(document.userForm.course.value=="")
						{
							alert("Please provide the Course");
							document.userForm.course.focus();
							return false;
						}
						if(document.userForm.email.value=="")
						{
							alert("Please provide the Email");
							document.userForm.email.focus();
							return false;
						}
						
						return true;
					}