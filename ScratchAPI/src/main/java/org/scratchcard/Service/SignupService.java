package org.scratchcard.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.scratchcard.Database.Database;
import org.scratchcard.Database.Test;
import org.scratchcard.Model.Signup;



public class SignupService 
{
	private Map<String,Signup> members=Test.getMembers();
	
	public SignupService()
	{
		members.put("HD335273", new Signup(1,"HD335273","amy","amy","amrinder.1102@gmail.com","password","compScience","Lead",1,1));
	}
	
	public List<Signup> getAllMembers()
	{
		/*Signup s1=new Signup(1,"HD335273","amy","amy","amrinder.1102@gmail.com","password","compScience","Lead",1,1);
		Signup s2=new Signup(2,"HD335274","amy","amy","amrinder.1102@gmail.com","password","compScience","Student",1,1);
		List<Signup> list= new ArrayList<Signup>();
		list.add(s1);
		list.add(s2);
		return list;*/
		return new ArrayList<Signup>(members.values());
	}
	
	/*public Signup getMember(String netId)
	{
		return members.get(netId);
	}*/
	
	/*public Signup addMember(Signup member)
	{
		member.setMemId(members.size()+1);
		members.put(member.getNetId(), member);
		System.out.println(member.getMemId());
		return member;
	}*/
	public int addMember(Signup member)
	{
		int i=Database.insertMember(member);
		return i;
	}
}
