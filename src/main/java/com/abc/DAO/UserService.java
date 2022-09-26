package com.abc.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.abc.dto.UserDto;

public class UserService
{
	private static final String SQL_SELECT_QUERY = "SELECT * FROM userinfo WHERE USERNAME=? AND PASSWORD=?";
	Connection connection = null;
	PreparedStatement pstmt = null;
	Statement stmt =null;
	ResultSet resultset=null;
	
	
	public UserService()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql:///abc","root","root123");
			pstmt=connection.prepareStatement(SQL_SELECT_QUERY);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public boolean checklogin(String username,String password)
	{
		
		try
		{
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			resultset=pstmt.executeQuery();
			
			if(resultset.next())
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return false;
		
	}
	public boolean registerData(UserDto user)
	{
		try
		{
			String SQL_INSERT_QUERY = "INSERT INTO userinfo(username,password,usermail,usermobile) VALUES("+user.getUsername()+","+user.getPassword()+","+user.getUsermail()+","+user.getUsermobile()+")";
		     int rowCount=stmt.executeUpdate(SQL_INSERT_QUERY);
		  if(rowCount>0)
		  {
			  return true;
		  }
		  else
		  {
			  return false;
		  }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
		
	}
	
	
	

}
