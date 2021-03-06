package org.btm.DBinsert_App;
import java.sql.*;
public class DBinsert 
{
	public static void main(String[] args) 
	{
		Connection con = null;
		Statement stmt = null;
		String qry = "insert into btm.student values(4,'Akash',87.78)";
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Class Loaded and Registered !!");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=thunder");
			System.out.println("Connection established with DB server !!");
			
			stmt = con.createStatement();
			System.out.println("Platform Created");
			
			stmt.executeUpdate(qry);
			System.out.println("Data Inserted !!");
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			if(stmt!=null)
			{
				try 
				{
					stmt.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
			if(con!=null)
			{
				try 
				{
					con.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
			System.out.println("Closed all costly resources !!");
		}
	}
}
