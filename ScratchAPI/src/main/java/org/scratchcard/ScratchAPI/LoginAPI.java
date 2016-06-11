package org.scratchcard.ScratchAPI;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;

import org.json.JSONException;
import org.json.JSONObject;
import org.scratchcard.Database.Database;
import org.scratchcard.Model.Signup;


import org.scratchcard.Model.User;
@Path("/userlogin")
public class LoginAPI {
	
	@POST
	@Path("/login")
	
	@Produces(MediaType.TEXT_HTML)
	public Response loginUser(@FormParam("form-username") String netId,
            @FormParam("form-password") String password, @Context ServletContext context,@Context HttpServletRequest request, @Context HttpServletResponse response) throws JSONException,Exception
	{
		
		
		if(netId == null || netId.isEmpty())
        {
            //return Response.ok().entity("First name is mandatory dude").build();
            //return Response.status(400).entity("Enter NetID").build();
			String message="Enter the NetId";
			
           // URI uri = UriBuilder.fromPath("http://localhost:8090/scratchAPI/login.jsp")
                   // .queryParam("message", message)
                   // .build();
			UriBuilder uri = UriBuilder.fromPath(context.getContextPath()).queryParam("message", message);
			uri.path("login.jsp");
            return Response.seeOther((uri).build()).build();
            
        }
        
        if(password == null || password.isEmpty())
        {
        	String message="Enter the Password";
            UriBuilder uri = UriBuilder.fromPath(context.getContextPath()).queryParam("message", message);
                    //.queryParam("message", message)
                    //.build();
            		uri.path("login.jsp");		
            return Response.seeOther((uri).build()).build();
        }
        else
        {
        	int memId=Database.validatUser(netId, password);
        	//System.out.println(memId);
        	
        	if(memId>-1)
        	{
        		 HttpSession sess=request.getSession();
        		 Signup user=Database.getUserById(memId);
        		 String role=user.getRole();
        		 int teamId=user.getTeamId();
        		 //System.out.println(user.getTeamId());
        		// ArrayList<Signup> list=new ArrayList<Signup>();
        		 //list=Database.getTeam(teamId);
        		 sess.setAttribute("user", user);
        		 sess.setAttribute("role", role);
        		 sess.setMaxInactiveInterval(20*60);
        		 if(role.equals("lead") || role.equals("student") )
        		 {
        			 UriBuilder uri = UriBuilder.fromPath(context.getContextPath()).queryParam("role", role);
            		 uri.path("dashboard.jsp");
                     return Response.seeOther(uri.build()).build();
        		 }
        		 else
        		 {
        			 UriBuilder uri = UriBuilder.fromPath(context.getContextPath()).queryParam("role", role);
            		 uri.path("professor.jsp");
                     return Response.seeOther(uri.build()).build();
        		 }
        		
        	}
        	else
        	{
        		
        		String message="Enter Valid NetId/Password";
                UriBuilder uri = UriBuilder.fromPath(context.getContextPath()).queryParam("message", message);
                       
                uri.path("login.jsp");
                return Response.seeOther(uri.build()).build();
               // return Response.seeOther(uri).build();
        	}
        }      	
        			
	}
}
