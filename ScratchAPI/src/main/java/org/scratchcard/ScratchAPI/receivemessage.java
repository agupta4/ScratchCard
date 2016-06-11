package org.scratchcard.ScratchAPI;


import org.scratchcard.Service.MessageService;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import org.scratchcard.Model.ChatMessage;

@Path("/message")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class receivemessage {
	org.scratchcard.Service.MessageService msgService = new MessageService();
	
	@POST
	@Path("/add")
	public org.scratchcard.Model.ChatMessage Input(ChatMessage m) throws SQLException{
		m.setReceived(new Date());
		int id = msgService.addMessage(m);
		System.out.println("hi");
		if(id > 0){return m;}
		else{return null;}
	}
	
	@GET
	@Path("/get/{room}/{teamid}/{memid}")
	public Collection<ChatMessage> GetMessage(@PathParam("room") String room, @PathParam("teamid") int teamid, @PathParam("memid") int memid) throws Exception{
		List<ChatMessage> m = (List<ChatMessage>) msgService.getAllMessages(room, memid, teamid);
		return m;
	}
	
	@GET
	@Path("/getMessages/{teamid}")
	public Collection<ChatMessage> PopulateContainer(@PathParam("teamid") int teamid) throws SQLException{
		List<ChatMessage> m = (List<ChatMessage>) msgService.getAllMessage(teamid);
		return m;
	}
}
