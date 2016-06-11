package org.scratchcard.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.scratchcard.Database.AuthDAO;
import org.scratchcard.Model.ChatMessage;

public class MessageService {
	private org.scratchcard.Database.AuthDAO a = new AuthDAO();
	private Map<Integer, ChatMessage> messages;
	
	public int addMessage(ChatMessage msg) throws SQLException{
		int id = a.add(msg.getMessage(), msg.getRoom(), msg.getMEM_ID(), msg.getTEAM_ID(), msg.getNickname());
		if(id > 0){return id;}
		else{return 0;}
	}
	
	public ChatMessage getMessage(String room, int memid, int teamid) throws SQLException{
		ChatMessage m = a.getMessage(memid, teamid, room);
		
		return m;
	}
	
	public Collection<ChatMessage> getAllMessages(String room, int memid, int teamid) throws Exception{
		messages = a.getAllMessage(memid, teamid, room);
		List<ChatMessage> lst = new ArrayList<>();
		for(ChatMessage m: messages.values()){
			lst.add(m);
		}
		return lst;
	}

	public Collection<ChatMessage> getAllMessage(int teamid) throws SQLException {
		// TODO Auto-generated method stub
		messages = a.MessagesPerTeam(teamid);
		List<ChatMessage> lst = new ArrayList<>();
		for(ChatMessage m: messages.values()){
			lst.add(m);
		}
		return lst;
	}
}
