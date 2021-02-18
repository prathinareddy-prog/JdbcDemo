package com.valuemomentum.training.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateDemo {

	public static void main(String[] args) {
		Connection con;
		Statement stmt;
		PreparedStatement pstmt;
		ResultSet rs;
		int cnt = 0;
		String sqlUpdate;
	
		try
		{
			//register jdbc driver
			//for name method of class is used to register driverclass 
			Class.forName("com.mysql.cj.jdbc.Driver");
			
//open a connection 
			System.out.println("connecting to database..");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","prathina@20");
	//should give space aftr lastname and update candidates		
	sqlUpdate ="update candidates "+"SET last_name= ? "+"where id=?";
	  pstmt=con.prepareStatement(sqlUpdate);
	// prepare data for update
	Scanner s=new Scanner(System.in);
	System.out.println("enter employee id:");
	int eid=s.nextInt();
	System.out.println("enter employee's new last name:");
String lastname=s.next();

pstmt.setString(1,lastname);
pstmt.setInt(2,eid);

int rowAffected = pstmt.executeUpdate();
System.out.println(String.format("row affected %d",rowAffected));

//reuse the prepared Statement 
lastname="Grohe";
eid=101;
pstmt.setString(1,lastname);
pstmt.setInt(2,eid);

rowAffected = pstmt.executeUpdate();
System.out.println(String.format("row affected %d",rowAffected));

con.close();

		}
		catch(Exception ce)
		{
			System.out.println(ce);
		}
	}
}