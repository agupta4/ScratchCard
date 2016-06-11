$(document).ready(
	function() {
				$("#userForm").submit(function() {
					
					//console.log($(this).serializeArray());
					netId = $(this).find("#netId").val();
					password = $(this).find("#password").val();
					
					var arr = {
						"netId" : netId,
						"password" : password,
						
					};
					$.ajax({
						type : 'post',
						url : 'http://localhost:8090/ScratchAPI/webapi/userlogin/login',
						contentType : 'application/json',
						data : JSON.stringify(arr),
						success : function(result) {
							
							$('#addResultDiv').html('');
							//var objData = jQuery.parseJSON(data);
                           // console.log(objData);
							//$('#addResultDiv').append( data );
							$('#addResultDiv').html(result);							
							
						},
						failure : function(result) {
							$('#addResultDiv').html('');
							$('#addResultDiv').html(result);

						}
					});
					return false;	
				});			

});

