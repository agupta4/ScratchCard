package org.scratchcard.Database;

import java.util.HashMap;
import java.util.Map;

import org.scratchcard.Model.Signup;

public class Test 
{
private static Map<String,Signup> members= new HashMap<>();
	
	
	
	public static Map<String,Signup> getMembers()
	{
		return members;
	}
}
