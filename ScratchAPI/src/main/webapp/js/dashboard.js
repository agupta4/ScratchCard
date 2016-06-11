
function test()
{
	
	window.onload=getQues();

}

var score=[5,5,5,5,5,5,5,5,5,5];
var total=0;
var sequence = new Array(10); ///this array stores the sequence of answers

function function2()
{
	
	var val;
	var ans=["A","B","D","A","E","C","D","A","C","A"];
		
    var buttons = document.getElementsByClassName("btn btn-info");
    var myTable = document.getElementById("quesTable");
   // alert(buttons.length);
    var res1="",res2="",res3="",res4="",res5="",res6="",res7="",res8="",res9="",res10="";
    
    for (var i = 0; i < buttons.length; i++)
    {   	
        buttons[i].onclick = function()
        {      	
        	val=this.value;
        	//this.disabled = true; 
            var clickAns=val.substring(0, 1);
            var question=val.substring(1);       
            if(!(ans[question-1]===(clickAns)))
            	{
            		//res=res.concat(clickAns); //take sequence of answers clicked
            		//alert(res);
            		//sequence[question-1]=res; //put in array
            		//alert(sequence);
            		switch (question) 
            		{
	            	    case "1":
	            	    	res1=res1.concat(clickAns);
	            	    	sequence[question-1]=res1;
	            	    	//alert(sequence);
	            	        break;
	            	    case "2":
	            	    	res2=res2.concat(clickAns);
	            	    	sequence[question-1]=res2;
	            	    	//alert(sequence);
	            	        break;
	            	    case "3":
	            	    	res3=res3.concat(clickAns);
	            	    	sequence[question-1]=res3;
	            	    	//alert(sequence);
	            	        break;
	            	    case "4":
	            	    	res4=res4.concat(clickAns);
	            	    	sequence[question-1]=res4;
	            	    	//alert(sequence);
	            	        break;
	            	    case "5":
	            	    	res5=res5.concat(clickAns);
	            	    	sequence[question-1]=res5;
	            	    	//alert(sequence);
	            	        break;
	            	    case "6":
	            	    	res6=res6.concat(clickAns);
	            	    	sequence[question-1]=res6;
	            	    	//alert(sequence);
	            	        break;
	            	    case "7":
	            	    	res7=res7.concat(clickAns);
	            	    	sequence[question-1]=res7;
	            	    	//alert(sequence);
	            	        break;
	            	    case "8":
	            	    	res8=res8.concat(clickAns);
	            	    	sequence[question-1]=res8;
	            	    	//alert(sequence);
	            	        break;
	            	    case "9":
	            	    	res9=res9.concat(clickAns);
	            	    	sequence[question-1]=res9;
	            	    	//alert(sequence);
	            	        break;
	            	    case "10":
	            	    	res10=res10.concat(clickAns);
	            	    	sequence[question-1]=res10;
	            	    	//alert(sequence);
	            	        break;
            		}
            		//==================================================================================
            		this.disabled = true;
            		this.style.backgroundColor = "RED";
            		//alert(score[question-1]);
            		score[question-1]=score[question-1]-1;
            		alert("Not Correct Try Next: " + score[question-1]);
            		//myTable.rows[question].cells[2].innerHTML = score[question-1];		
            	}
            
            else
            	{
	            	this.disabled = true;
	        		this.style.backgroundColor = "Green";
	        		myTable.rows[question].cells[2].innerHTML = score[question-1];
	        		total=total+score[question-1];
	            	/*if(score[question-1]==5)
	            	{
	            		//total=total+score[question-1];
	            		myTable.rows[question].cells[2].innerHTML = score[question-1];
	            	}
	            	else 
	            	{
	            		sc=score[question-1]-1
	            		//total=total+sc;
	            		myTable.rows[question].cells[2].innerHTML = sc;
	            	}*/
            		
            	}
            
        	
        };
    }
    

}
function function1()
{
	var teamid =document.getElementById("session").value;
	//alert(sessionValue);
	//total=score[0]+score[1]+score[2]+score[3]+score[4]+score[5]+score[6]+score[7]+score[8]+score[9];
	//alert(sequence);
	//alert("Total Score:- "+ total);
	//alert(total);
	$.ajax({           	
	type : 'POST',
	url : 'http://localhost:8090/ScratchAPI/webapi/answer/getVal/'+total+'/'+teamid,
	contentType : 'application/json',
	//data:JSON.stringify(total),
	data:  JSON.stringify(sequence),
	success : function(result) {
		window.location='submission.jsp';
		//alert(result);
		//window.location='login.jsp';
		//val.prop("disabled",true);
		
	},
	failure : function(result) {
		//$('#addResultDiv').html('');
		//$('#addResultDiv').html(result);
		//alert(result);
	}   		
});
}

function getQues(){
	var table = document.getElementById("quesTable");
	for(c = ques+1; c > 0; c--){
		if(c == 1){
			var row = table.insertRow(0);
		    var cell1 = row.insertCell(0);
		    var cell2 = row.insertCell(1);
		    var cell3 = row.insertCell(2);
		    cell1.innerHTML = "Question No.";
		    cell2.innerHTML = "Answers";
		    cell3.innerHTML = "Score";
		}else{
		    var row = table.insertRow(0);
		    var cell1 = row.insertCell(0);
		    var cell2 = row.insertCell(1);
		    var cell3 = row.insertCell(2);
		    cell1.innerHTML = c-1;
		    cell2.innerHTML = "<div class = 'btn-group'>" +
		    "<button type = 'button'  value='A"+cell1.innerHTML+"'  style = 'width:100px' class = 'btn btn-info' enable onclick='function2()'>A</button>"+
		    "<button type = 'button'  value='B"+cell1.innerHTML+"'  style = 'width:100px' class = 'btn btn-info' enable onclick='function2()'>B</button>"+
		    "<button type = 'button'  value='C"+cell1.innerHTML+"'  style = 'width:100px' class = 'btn btn-info' enable onclick='function2()'>C</button>"+
		    "<button type = 'button'  value='D"+cell1.innerHTML+"'  style = 'width:100px' class = 'btn btn-info' enable onclick='function2()'>D</button>"+
		    "<button type = 'button'  value='E"+cell1.innerHTML+"'  style = 'width:100px' class = 'btn btn-info' enable onclick='function2()'>E</button>"+
		    "</div>";
		    cell3.innerHTML = "<span id = 'span"+c+"'></span>";
			
		}
	}
}

 
function getQuesDisabeled(){
	var table = document.getElementById("quesTable");
	for(c = ques+1; c > 0; c--){
		if(c == 1){
			var row = table.insertRow(0);
		    var cell1 = row.insertCell(0);
		    var cell2 = row.insertCell(1);
		    var cell3 = row.insertCell(2);
		    cell1.innerHTML = "Question No.";
		    cell2.innerHTML = "Answers";
		    cell3.innerHTML = "Score";
		}else{
		    var row = table.insertRow(0);
		    var cell1 = row.insertCell(0);
		    var cell2 = row.insertCell(1);
		    var cell3 = row.insertCell(2);
		    cell1.innerHTML = c-1;
		    cell2.innerHTML = "<div class = 'btn-group'>" +
		    "<button type = 'button' style = 'width:100px' class = 'btn btn-info' disabled>A</button>"+
		    "<button type = 'button' style = 'width:100px' class = 'btn btn-info' disabled>B</button>"+
		    "<button type = 'button' style = 'width:100px' class = 'btn btn-info' disabled>C</button>"+
		    "<button type = 'button' style = 'width:100px' class = 'btn btn-info' disabled>D</button>"+
		    "<button type = 'button' style = 'width:100px' class = 'btn btn-info' disabled>E</button>"+
		    "</div>";
		    cell3.innerHTML = "<span id = 'span"+c+"'></span>";
			
		}
	}
}

