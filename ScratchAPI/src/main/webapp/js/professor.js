function function1()
{
	//alert("hello")
	$.ajax({           	
	type : 'GET',
	url : 'http://localhost:8090/ScratchAPI/webapi/prof/getAllStudent',
	contentType : 'application/json',
	success : function(result) {
		var json = $.parseJSON(result);	
		drawTable(json);
		console.log("hi");
	},
	failure : function(result) {
		//$('#addResultDiv').html('');
		//$('#addResultDiv').html(result);
		alert(result);
	}   		
});
}

function drawTable(json) {
	//alert(result.length);
    for (var i = 0; i < json.length; i++) {
    	
        drawRow(json[i]);
    }
}

function drawRow(rowData) {
    var row = $("<tr />")
    $("#userdata").append(row); //this will append tr element to table... keep its reference for a while since we will add cels into it
    row.append($("<td>" + rowData.memId + "</td>"));
    row.append($("<td>" + rowData.netId + "</td>"));
    row.append($("<td>" + rowData.firstname + "</td>"));
    row.append($("<td>" + rowData.lastname + "</td>"));
    row.append($("<td>" + rowData.role + "</td>"));
    row.append($("<td>" + rowData.teamId + "</td>"));
    row.append($("<td>" + rowData.course + "</td>"));
    row.append($("<td>" + rowData.deptId + "</td>"));  
    row.append($("<td>" + rowData.email + "</td>"));
    
    
}