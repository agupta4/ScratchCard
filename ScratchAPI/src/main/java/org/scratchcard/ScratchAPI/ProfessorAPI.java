package org.scratchcard.ScratchAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.scratchcard.Database.Database;
import org.scratchcard.Model.Signup;

import com.google.gson.Gson;

@Path("/prof")
public class ProfessorAPI

{
		
	@GET
	@Path("/getAllStudent")
	
	public Response getAnswer() throws JSONException,Exception 
	{
		//System.out.println("Hello");
		int j=1;
		ArrayList<Signup> student=Database.getAllStudents();
		System.out.println(student.size());
		JSONArray jsArray = new JSONArray(student);
		String json = new Gson().toJson(student);
		System.out.println(json);
		return Response.status(200).entity(json).build();
		
	
	}
}
