package com.valuemomentum.training.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BatchDemo {
	Connection con;
	Statement stmt;
	ResultSet rs;
	
	public static void main(String[] args)throws Exception
	{
		//for name method of class is used to register driverclass 
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//open a connection 
		System.out.println("connecting to database..");
		Connection	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","prathina@20");
		
		//create a statement object using connection obj
		Statement	stmt = con.createStatement();
		
		//create batch
		stmt.addBatch("insert into candidate_skills values(100,6)");
		stmt.addBatch("update skills set name='Ajax' where id=3");
		stmt.addBatch("delete from candidates where id=80");
		
		
		//disable auto_commit mode
		con.setAutoCommit(false);
		try
		{
			stmt.executeBatch();
			con.commit();
			System.out.println("batch is successfully executed");
			
		}
		catch(Exception e)
		{
			try
			{
				con.rollback();
				System.out.println("batch is failed");
			System.out.println("exception is"+e);
		}
			
			
			catch (Exception e1)
			{
				System.out.println("exception is"+e1);
			}
	}
		
		//end of outer catch
		//cleanup
		stmt.close();
con.close();
}
}

