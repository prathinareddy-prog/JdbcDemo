package com.valuemomentum.training.jdbcdemo;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.Statement;



public class ScrollableDemo {

		public static void main(String[] args) {
		 
		
			Connection con;
			Statement stmt;
			ResultSet rs;

			try
			{
				//register jdbc driver
				//for name method of class is used to register driverclass 
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				//open a connection 
				System.out.println("connecting to database..");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","prathina@20");
				//bydefault it will be unscrollable
		          stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//scrollable resultset	
			rs=stmt.executeQuery("select * from skills");
			//reading from bottom to top
			rs.afterLast();
			
			while(rs.previous())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2));
				
			}
			System.out.println("**************");
			//moves cursor to 3rd record
			rs.absolute(3);
			System.out.println(rs.getInt(1)+" "+rs.getString(2));
			System.out.println("**************");
			//move cursor to 2nd record using relative()
			rs.relative(-1);
			System.out.println(rs.getInt(1)+" "+rs.getString(2));
			System.out.println("**************");
			
			int i=rs.getRow();//get cursor position
			System.out.println("cursor position"+i);
			
			//cleanup
			rs.close();
			stmt.close();
			con.close();

}
		catch(Exception e )
		{
			System.out.println(e);
		}
	
		}}

