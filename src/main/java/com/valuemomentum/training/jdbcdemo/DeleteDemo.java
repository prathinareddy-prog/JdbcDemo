package com.valuemomentum.training.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DeleteDemo {

	public static void main(String[] args) {
		Connection con;
		Statement stmt;
		ResultSet rs;
		int cnt = 0;
		
		try
		{
			//register jdbc driver
			//for name method of class is used to register driverclass 
			Class.forName("com.mysql.cj.jdbc.Driver");
			
//open a connection 
			System.out.println("connecting to database..");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","prathina@20");
			
			String sql="delete from candidates where rtrim(last_name) like\'y%g\';";
		System.out.println(" ");
		stmt = con.createStatement();
		cnt=stmt.executeUpdate(sql);
		
if(cnt>0)
{
	System.out.println("record for young is deleted");
}
else
{
	System.out.println("record not found");
}
con.close();
	}


	catch(Exception ce)
		{
			System.out.println(ce);
		}
}
}
