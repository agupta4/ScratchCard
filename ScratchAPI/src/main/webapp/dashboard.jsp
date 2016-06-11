<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList"%>
<%@page import="org.scratchcard.Model.Signup"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale = 1.0">
<title>Welcome to scratch Card</title>
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="css/Chatbot.css" rel="stylesheet">
	<script src ="bootstrap/js/jquery-1.11.3.min.js"></script>
	<script src ="bootstrap/js/bootstrap.js"></script>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script src="js/dashboard.js"></script>
	
	<%
	String hash="";
	String date="";
	String cont="";
	Signup h=(Signup)session.getAttribute("user");
		String s=h.getFirstname();
		out.print("Welcome "+ h.getFirstname() + " "+ h.getLastname());
		out.print("    "+"Team Id:- " + h.getTeamId());
		out.print("    "+"Role:- " + h.getRole());
		int teamId=h.getTeamId();
		int memid=h.getMemId();

		
%>

<script type = "text/javascript">
var ques = 10;
var tableRow = "";
var prevmsg = "";
var name;
var room = '';
var MEM_ID = <%=memid%>;
var TEAM_ID = <%=teamId%>;

function defineRoom(){
	room = $("#chatroom option:selected").val();
	name = $('#nickname').val();
}

$(document).ready(function(){
	$nickname = $('#nickname');
	$('.chat-wrapper').hide();
	$nickname.focus();
	
	$(function(){
		$("#textbox").keypress(function(event){
			if(event.which == 13){
				$("#send").click();
				event.preventDefault();
			}
		});
	});
	$('#enterRoom').click(function(evt){
		evt.preventDefault();
		defineRoom();
		$(".chat-signin").hide();
		$(".chat-wrapper").show();
		$("#msg").html('<h4 class="glyphicon glyphicon-comment">' +name.toUpperCase()+ '</h4>');
		PopulateContainer();
		checkforMsgs();
	});
	//Sending message to the container and in the database
	$("#send").click(function(){
		//Implementing chat bot
		var usrmsg = $("#textbox").val();
		var array = {
			"message": usrmsg,
			"MEM_ID": MEM_ID,
			"TEAM_ID": TEAM_ID,
			"nickname": name,
			"room" : room
		};
		$.ajax({
			type: 'post',
			url: 'http://localhost:8090/ScratchAPI/webapi/message/add',
			contentType: 'application/json',
			data: JSON.stringify(array),
			success:function(result){
				$("#textbox").val("");
				prevmsg = $("#cont").html();
				$("#cont").html(prevmsg+ "<br><br><span style = 'float: right; color:#6F7DE1;'>" +usrmsg+ "</span>");
				$("#cont").scrollTop($("#cont").prop("scrollHeight"));
			},
			failure: function(result){
				$("#textbox").val("");
				console.log(result);
				prevmsg = $("#cont").html();
				$("#cont").html(prevmsg+ "<br><br><span style = 'color: Red; float: right;'><i>Error in sending the message</i><span>" );
				$("#cont").scrollTop($("#cont").prop("scrollHeight"));
			}
		});

	});

});


function checkforMsgs(){
	var temp = "";
	$.ajax({
		type: 'get',
		url:'http://localhost:8090/ScratchAPI/webapi/message/get/'+room+'/'+TEAM_ID+'/'+MEM_ID,
		async:true,
		cache:false,
		timeout: 10000,
		dataType: "json",
		success:function(data){
			if(data){	//Decoding json data
				var len = data.length;
				var text = "";
				if(len>0){
					for(var i = 0; i < len; i++){
						if(data[i].message != null){
							if(data[i].message !== text){
								text = data[i].message;
								prevmsg = $("#cont").html();
								$("#cont").html(prevmsg+ "<br><br><span style= 'color: #BC243C; margin-left: 5px'><i>" +data[i].nickname+ "</i></span>:<span style = 'color:#6F7DE1'>" +text+ "</span>");
								$("#cont").scrollTop($("#cont").prop("scrollHeight"));
								temp = data[i].message;
							}
						}
					}
				}
			}
			setTimeout(checkforMsgs, 500);
		},
		error: function(XMLHttpRequest, textStatus, errorThrown){
			setTimeout(
                    checkforMsgs, /* Try again after.. */
                    15000); /* milliseconds (15seconds) */
		}
	});
}

//Populate Container on selection of room

function PopulateContainer(){
	$.ajax({
		type:'get',
		url: 'http://localhost:8090/ScratchAPI/webapi/message/getMessages/' +TEAM_ID,
		dataType: 'json',
		success: function(data){
			if(data){
				var len = data.length;
				var text = "";
				$("#cont").html("");
				if(len > 0){
					for(var i = 0; i < len; i++){
						if(data[i].message != null){
							if(data[i].nickname == name){
								text = data[i].message;
								prevmsg = $("#cont").html();
								$("#cont").html(prevmsg+ "<br><br><span style = 'float: right; color:#6F7DE1;'>" +text+ "</span>");
								$("#cont").scrollTop($("#cont").prop("scrollHeight"));
							}
							else{
								text = data[i].message;
								prevmsg = $("#cont").html();
								$("#cont").html(prevmsg+ "<br><br><span style= 'color: #BC243C; margin-left: 5px'><i>" +data[i].nickname+ "</i></span>:<span style = 'color:#6F7DE1'>" +text+ "<span>");
								$("#cont").scrollTop($("#cont").prop("scrollHeight"));
							}
						}
					}
				}
			}
		},
		failure: function(data){
			alert("Error in retreiving message");			
		}
	});
}


function testSession()
{<% String str1=(String)request.getParameter("role"); %>
	var s="<%=str1%>"; 
	console.log(s);
	//alert(s);
	
	if(s==="lead")
		{
			
		 getQues();
		}
	else
		{
		getQuesDisabeled();
		}
}
</script>



</head>


<body onload="testSession()">
<input type="hidden" id="session" value="<%=h.getTeamId()%>"></input>
<div class = "container">
	<div class = "row">
		<div class = "col-md-1"></div>
		<div class = "col-md-10">
			<div id = "tabs">
				<ul class = "nav nav-tabs">
					<li class = "active"><a data-toggle = "tab" href = "#tab1">Questions</a></li>
					<li><a data-toggle = "tab" href = "#tab2">Discussion</a></li>
					<li><a data-toggle = "tab" href = "#tab3">Team</a></li>
				</ul>
				<div class = "tab-content">
					<div id = "tab1" class = "tab-pane fade in active">
							<table id = "quesTable" class="table table-striped table-bordered" style = "width: 100%; text-align:center">
							
							</table>
						<div id = "totalscore" style = "display:none">Section for Total Score</div>
						<div id = "button" style = "text-align:center;">
							<button class = "btn btn-primary" onclick="function1();">Submit</button>
						</div>
					</div>
					<div class = "tab-pane fade" id = "tab2">
						<div id = "header" style = "text-align:center">
							<h1>Team Discussion</h1>
						</div>
						<div class = "chat-signin">
						<nav class="navbar navbar-default">
  							<div class="container-fluid">
		   						<div class="navbar-header">
		      						<a class="navbar-brand" href="#">ChatRoom Selection</a>
		    					</div>
					    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					            <form id="form-signin" class="navbar-form navbar-right" role="form">
					                        <div class="input-group">
					                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
					                            <input id="nickname" type="text" class="form-control" value="" placeholder="Nickname">                                        
					                        </div>
					
					                        <div class="input-group">
					                        <span class = "input-group-addon"><i class="glyphicon glyphicon-comment"></i></span>
											<select id = "chatroom" class="form-control" size = "1">
											<option>No Selection</option>
											<option><%=teamId %></option>
													
											</select>                                       
								            </div>
					                        <button type="submit" id = "enterRoom" class="btn btn-primary">Enter room</button>
					                   </form>
					     
					    </div>
					  </div>
					</nav>
					</div>
						<div class = "chat-wrapper">
						<div id = "msg">
						
						</div>
							<div id = "cont" style= "overflow: scroll">
								<section>
								    <div>
								        <canvas id="canvas" width="800" height="400">
								         This text is displayed if your browser 
								         does not support HTML5 Canvas.
								        </canvas>
								    </div>
								
								<script type="text/javascript">
								var canvas;  
								var ctx;
								var x = 400;
								var y = 200;
								var dx = 0;
								var dy = 2;
								var WIDTH = 800;
								var HEIGHT = 400; 
								
								function circle(x,y,r) {
								  ctx.beginPath();
								  ctx.arc(x, y, r, 0, Math.PI*2, true);
								  ctx.fill();
								}
								
								function rect(x,y,w,h) {
								  ctx.beginPath();
								  ctx.rect(x,y,w,h);
								  ctx.closePath();
								  ctx.fill();
								}
								
								 
								function clear() {
								  ctx.clearRect(0, 0, WIDTH, HEIGHT);
								}
								
								function init() {
								  canvas = document.getElementById("canvas");
								  ctx = canvas.getContext("2d");
								  return setInterval(draw, 10);
								}
								
								
								function draw() {
								  clear();
								  ctx.fillStyle = "#FAF7F8";
								  rect(0,0,WIDTH,HEIGHT);
								  ctx.fillStyle = "Grey";
								  ctx.font = "20px Arial";
								  ctx.fillText("Fetching Messages...", 310, 250);
								  ctx.fillStyle = "#6F7DE1";
								  circle(x, y, 10);
								
								  if (x + dx > WIDTH || x + dx < 0)
								    dx = -dx;
								  if (y + dy > 200 || y + dy < 100)
								    dy = -dy;
								
								  x += dx;
								  y += dy;
								}
								
								init();
								</script>
								
								  </section>		
							</div>
						<div id = "controls">
							<textarea rows="2" id = "textbox" placeholder = "Enter your message here..."></textarea>
							<button id = "send" type = "button" class = "btn btn-primary" style = "margin: 2px">Send</button>
						</div>
						</div>
						
					</div>
					<div class = "tab-pane fade" id = "tab3">
						<h1>Team</h1>
					</div>
				</div>		
		</div>
		<div class = "col-md-1"></div>
	</div>
</div>

</div>
</body>
</html>