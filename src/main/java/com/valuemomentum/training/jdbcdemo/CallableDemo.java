package com.valuemomentum.training.jdbcdemo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CallableDemo {

	Connection con;
	CallableStatement cstmt;
	ResultSet rs;

  void createConnection()
	{
	 try
		{
			//register jdbc driver
			//for name method of class is used to register driverclass 
			Class.forName("com.mysql.cj.jdbc.Driver");
			
//open a connection 
			System.out.println("connecting to database..");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","prathina@20");
		
		}
		catch(Exception ce)
			{
				System.out.println(ce);
			}
	}
	
	
	
	public void getSkills(int candidateId)
	{
		try
		{
			//stored procedurename is get_candidate_skill
			String query="{call get_candidate_skill(?)}";
			cstmt=con.prepareCall(query);
			cstmt.setInt(1, candidateId);
			
			rs=cstmt.executeQuery();
			while(rs.next())
			{
				System.out.println(String.format("%s - %s", 
						rs.getString("first_name")+" "+rs.getString("last_name"),
						rs.getString("skill")));
			}
		
	}
	
		catch(Exception ce)
		{
			System.out.println(ce);
		}
}
	
	public static void main(String[] args) {
	CallableDemo cd1=new CallableDemo();
	cd1.createConnection();
	cd1.getSkills(133);
	

	}
	
	}

