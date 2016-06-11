package org.scratchcard.ScratchAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.json.JSONArray;
import org.json.JSONObject;
import org.scratchcard.Database.Database;

@Path("/answer")
public class DashboardAPI 

{
		
	@POST
	@Path("/getVal/{total}/{teamid}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void getAnswer(@PathParam ("teamid") String teamid,@PathParam ("total") String total, String sc,
			@Context ServletContext context,@Context HttpServletRequest request, @Context HttpServletResponse response) throws Exception 
	{
		
		Database.insertScore(total,teamid,sc);
		HttpSession sess=request.getSession();
		System.out.println(total);
		 sess.setAttribute("total", total);
		/* UriBuilder uri = UriBuilder.fromPath(context.getContextPath()).queryParam("role", total);
		 uri.path("dashboard.jsp");
         return Response.seeOther(uri.build()).build();*/
		
	}
}
