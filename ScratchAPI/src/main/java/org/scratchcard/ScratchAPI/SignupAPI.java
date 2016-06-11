package org.scratchcard.ScratchAPI;

import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.json.JSONException;
import org.json.JSONObject;
import org.scratchcard.Database.Database;
import org.scratchcard.Model.Signup;



@Path("/user")
public class SignupAPI {
	
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)	
	public Response addUser(Signup us,@Context ServletContext context) throws JSONException,Exception
	{
		System.out.println("hello");
		boolean chkuser=Database.checkUserExist(us.getNetId());
		
		if(chkuser==true)
		{
			/*String message="user already exist with this netId";
            UriBuilder uri = UriBuilder.fromPath(context.getContextPath()).queryParam("message", message);         
            uri.path("signup.jsp");
            return Response.seeOther(uri.build()).build();*/
            return Response.status(200).entity("user already exist with this netId").build();
		}
		else
		{		
			int memID=Database.insertMember(us);
			return Response.status(200).entity("Successfully added user With MemberID :-  " + memID).build();
		}
	}
}
