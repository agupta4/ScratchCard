package org.scratchcard.Model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Signup 
{
	private int memId;
	private int deptId;
	private int teamId;
	private String role;
	private String netId;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private String course;
	private String courseName;
	
	
	public Signup()
	{
		
	}
	public Signup(String netId,String password,int deptId,String firstname,String lastname,String role,int teamId,String course,String email)
	{
		super();
		this.netId=netId;
		this.firstname=firstname;
		this.lastname=lastname;
		this.email=email;
		this.password=password;
		
		this.role=role;
		this.deptId=deptId;
		this.course=course;
		this.teamId=teamId;
	}
	
	
	
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getMemId() {
		return memId;
	}
	public void setMemId(int memId) {
		this.memId = memId;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getNetId() {
		return netId;
	}
	public void setNetId(String netId) {
		this.netId = netId;
	}
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
}

