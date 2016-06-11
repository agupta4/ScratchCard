package org.scratchcard.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.scratchcard.Model.ChatMessage;

public class AuthDAO {
	Connection con = null;
	public void openConnection(){
		try{  
			Class.forName("com.mysql.jdbc.Driver");  	
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/scratchapi","root","Sonachandi#2");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void closeConnection(){
		try{
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public int add(String message, String room, int MEM_ID, int TEAM_ID, String name) throws SQLException {
		// TODO Auto-generated method stub
		//Inserting message
		int id = 0;
		openConnection();
		PreparedStatement ps = con.prepareStatement("insert into msgs values(?,?,?,?,?,?,?)");
		ps.setString(1	, null);
		ps.setString(2, message);
		ps.setString(3, room);
		ps.setString(4, null);
		ps.setInt(5, MEM_ID);
		ps.setInt(6, TEAM_ID);
		ps.setString(7, name);
		int q = ps.executeUpdate();
		//Selecting id of the newly inserted message
		if(q > 0){
			ps = con.prepareStatement("Select * from msgs where message = ? and room = ? and Mem_ID = ? and TEAM_ID = ? and nickname = ?");
			ps.setString(1, message);
			ps.setString(2, room);
			ps.setInt(3, MEM_ID);
			ps.setInt(4, TEAM_ID);
			ps.setString(5, name);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				id = rs.getInt(1);
			}
		}
		closeConnection();
		return id;
	}
	public ChatMessage getMessage(int Mem_id, int Team_id, String room) throws SQLException {
		// TODO Auto-generated method stub
		openConnection();
		PreparedStatement ps = con.prepareStatement("Select * from msgs where Mem_ID = ? and TEAM_ID = ? and room = ? AND Received > (now() - Interval 59 SECOND)");
		ps.setInt(1, Mem_id);
		ps.setInt(2, Team_id);
		ps.setString(3, room);
		
		ResultSet rs = ps.executeQuery();
		ChatMessage m = new ChatMessage();
		while(rs.next()){
			m.setMessage(rs.getString(2));
			m.setRoom(rs.getString(3));
			m.setMEM_ID(rs.getInt(5));
			m.setTEAM_ID(rs.getInt(6));
			m.setReceived(rs.getDate(4));
		}
		
		closeConnection();
		return m;
	}
	public Map<Integer, ChatMessage> getAllMessage(int Mem_id, int Team_id, String room) throws SQLException {
		// TODO Auto-generated method stub
		Map<Integer, ChatMessage> msg = new HashMap<>();
		int key = 0;
		openConnection();
		PreparedStatement ps = con.prepareStatement("Select * from msgs where Mem_ID <> ? and TEAM_ID = ? and room = ? AND Received > (now() - Interval 0.6 SECOND)");
		ps.setInt(1, Mem_id);
		ps.setInt(2, Team_id);
		ps.setString(3, room);
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			ChatMessage m = new ChatMessage();
			m.setMessage(rs.getString(2));
			m.setRoom(rs.getString(3));
			m.setMEM_ID(rs.getInt(5));
			m.setTEAM_ID(rs.getInt(6));
			m.setReceived(rs.getDate(4));
			m.setNickname(rs.getString(7));
			msg.put(++key, m);
		}
		
		closeConnection();
		return msg;
	}
	public Map<Integer, ChatMessage> MessagesPerTeam(int teamid) throws SQLException {
		// TODO Auto-generated method stub
		Map<Integer, ChatMessage> msg = new HashMap<>();
		int key = 0;
		openConnection();
		PreparedStatement ps = con.prepareStatement("Select * from msgs where TEAM_ID = ? order by Received asc");
		ps.setInt(1, teamid);
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			ChatMessage m = new ChatMessage();
			m.setMessage(rs.getString(2));
			m.setRoom(rs.getString(3));
			m.setMEM_ID(rs.getInt(5));
			m.setTEAM_ID(rs.getInt(6));
			m.setReceived(rs.getDate(4));
			m.setNickname(rs.getString(7));
			msg.put(++key, m);
		}
		
		closeConnection();
		return msg;
	}

}
