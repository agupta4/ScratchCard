package org.scratchcard.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.scratchcard.Model.Signup;




public class Database 
{
	private static Connection conn;
	private static PreparedStatement pstmt;
	private static ResultSet rst;
	
	
	
	public static void getConnection()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/scratchapi","root","Sonachandi#2");
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	public static boolean checkUserExist(String netId)
	{
		String netIdDb="";
		try
		{
			getConnection();
			String q="select netId from members";
			pstmt=conn.prepareStatement(q);
			rst=pstmt.executeQuery();
			while(rst.next())
			{
				netIdDb=rst.getString("netId");
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		if(netIdDb.equals(netId))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	public static ArrayList<Signup> getTeam(int teamId)
	{
		ArrayList<Signup> list=new ArrayList<Signup>();
		try
		{
			getConnection();
			String query="select netId,firstname,lastname,role,teamId,courseName,deptId,email from members where members.teamId="+teamId;
			pstmt=conn.prepareStatement( query);
			rst=pstmt.executeQuery();
			while(rst.next())
			{
				Signup user=new Signup();
				user.setNetId(rst.getString("netId"));
				user.setFirstname(rst.getString("firstname"));
				user.setLastname(rst.getString("lastname"));
				user.setRole(rst.getString("role"));
				user.setTeamId(rst.getInt("teamId"));
				user.setCourse(rst.getString("courseName"));
				user.setDeptId(rst.getInt("deptId"));
				user.setEmail(rst.getString("email"));
				list.add(user);
			}
			for(int i=0;i<list.size();i++)
	  		 {
	  			 System.out.println(list.get(i));
	  		 }
		}
		
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
			return list;
			
	}
	
	public static Signup getUserById(int memId)
	{
		
		int deptId=-1;
		int teamId=-1;
		String role="";
		String netId="";
		String firstname="";
		String lastname="";
		String email="";
		String password="";
		String course="";
		String courseName="";
		try
		{
			getConnection();
			String query="select netId,password,firstname,lastname,role,teamId,courseName,deptId,email from members where members.memId="+memId;
			pstmt=conn.prepareStatement( query);
			rst=pstmt.executeQuery();
			while(rst.next())
			{
				
				netId=rst.getString("netId");
				firstname=rst.getString("firstname");
				lastname=rst.getString("lastname");
				role=rst.getString("role");
				teamId=rst.getInt("teamId");
				deptId=rst.getInt("deptId");
				courseName=rst.getString("courseName");
				email=rst.getString("email");
				
			}
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		Signup user=new Signup();
		user.setNetId(netId);
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setCourse(courseName);
		user.setRole(role);
		user.setDeptId(deptId);
		user.setEmail(email);
		user.setTeamId(teamId);
		
		return user;
	}
	public static ArrayList<Signup> getAllStudents()
	{
		ArrayList<Signup> list=new ArrayList<Signup>();
		try
		{
			getConnection();
			String query="select memId,netId,firstname,lastname,role,teamId,courseName,deptId,email from members where members.role=? OR members.role = ?";
			
			pstmt=conn.prepareStatement( query);
			pstmt.setString(1, "lead");
			pstmt.setString(2, "student");
			rst=pstmt.executeQuery();
			while(rst.next())
			{
				Signup user=new Signup();
				user.setMemId(rst.getInt("memId"));
				user.setNetId(rst.getString("netId"));
				user.setFirstname(rst.getString("firstname"));
				user.setLastname(rst.getString("lastname"));
				user.setRole(rst.getString("role"));
				user.setTeamId(rst.getInt("teamId"));
				user.setCourse(rst.getString("courseName"));
				user.setDeptId(rst.getInt("deptId"));
				user.setEmail(rst.getString("email"));
				list.add(user);
			}
			
		}
		
		
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		
			return list;
	}
	public static int validatUser(String netId,String password)
	{
		int memId=-1;
		try
		{
			getConnection();
			pstmt=conn.prepareStatement("select * from members where netId=? and password=?");
			pstmt.setString(1, netId);
			pstmt.setString(2, password);			
			rst=pstmt.executeQuery();
			if(rst.next())
			{
				memId=rst.getInt(1);
				//System.out.println(userId);
				return memId;
			}
			else
			{
				return -1;
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return -1;
		}
		
	}
	
	public static int insertMember(Signup member)
	{
		try
		{
			
			getConnection();
			pstmt=conn.prepareStatement("insert into members(memId,netId,password,firstname,lastname,role,teamId,courseName,deptId,email)"+"values(?,?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1, null);
			pstmt.setString(2,member.getNetId());
			pstmt.setString(3,member.getPassword());
			pstmt.setString(4,member.getFirstname());
			pstmt.setString(5, member.getLastname());
			pstmt.setString(6, member.getRole());
			pstmt.setInt(7, member.getTeamId());
			pstmt.setString(8, member.getCourse());
			pstmt.setInt(9,member.getDeptId());
			pstmt.setString(10, member.getEmail());
			int i=pstmt.executeUpdate();
			if(i>0)
			{
				System.out.println("successfully member inserted");
				pstmt=conn.prepareStatement("select * from members ");
				rst=pstmt.executeQuery();
				int memberId=-1;
				while(rst.next())
				{
					memberId=rst.getInt(1);
				}
				return memberId;
			}
			else
			{
				return -1;
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return -1;
		}
		
	}
	public static void insertScore(String score,String teamId,String response)
	{
		try
		{
			getConnection();
			pstmt=conn.prepareStatement("insert into score(score,teamId,response)"+"values(?,?,?)");
			pstmt.setString(1,score);
			pstmt.setString(2,teamId);
			pstmt.setString(3,response);
			int i=pstmt.executeUpdate();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	/*Map<Integer, Message> m =new HashMap<>();
	public static ArrayList<Message> getMessages()
	{
		ArrayList<Message> list=new ArrayList<Message>();
		
		try
		{
			getConnection();
			String q="select * from messages";
			pstmt= conn.prepareStatement(q);
			rst=pstmt.executeQuery();
			Message m=new Message();
			while(rst.next())
			{
				m.setID(rst.getInt("id"));
				m.setMessage(rst.getString("message"));
				m.setAuthor(rst.getString("author"));	
				list.add(m);
			}
			
		}
		
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return list;
	}*/
	
}
