package com.valuemomentum.training.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TransactionDemo {

	public static void main(String[] args) throws Exception
	{
		//for name method of class is used to register driverclass 
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				//open a connection 
				System.out.println("connecting to database..");
				Connection	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","prathina@20");
				System.out.println("driver is loaded");
				//create a statement object using connection obj
				Statement	stmt = con.createStatement();
		//disable auto_commit mode
				con.setAutoCommit(false);
				try
				{
				int i1=stmt.executeUpdate("insert into candidate_skills values(100,3)" );
				int i2=stmt.executeUpdate("update skills set name='Ruby' where id=1");
			    int i3=stmt.executeUpdate("delete from candidates where id=34");
	
				con.commit();
				System.out.println("transaction success");
				}//end of try
				catch(Exception e)
				{
					try
					{
						con.rollback();
						System.out.println("transaction is failed");
			
				}
					catch (Exception ex)
					{
					System.out.println(ex);}
						stmt.close();
						con.close();
					System.out.println("connection is closed");
					}
			

}
}

