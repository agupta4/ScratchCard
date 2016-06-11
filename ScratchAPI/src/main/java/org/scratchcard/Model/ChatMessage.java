package org.scratchcard.Model;

import java.util.Date;

public class ChatMessage {
	private String message;
	private String room;
	private int MEM_ID;
	private int TEAM_ID;
	private Date received;
	private String nickname;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getReceived() {
		return received;
	}
	public void setReceived(Date received) {
		this.received = received;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public int getMEM_ID() {
		return MEM_ID;
	}
	public void setMEM_ID(int mEM_ID) {
		MEM_ID = mEM_ID;
	}
	public int getTEAM_ID() {
		return TEAM_ID;
	}
	public void setTEAM_ID(int tEAM_ID) {
		TEAM_ID = tEAM_ID;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
}
