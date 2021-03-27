package org.btm.jdbc1_2_3_App;
import java.sql.*;
public class jdbc1_2_3 
{
	public static void main(String[] args) 
	{
		Connection con = null;
		Statement stmt = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Class Loaded and Registered !!");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=thunder");
			System.out.println("Connection established with DB server !!");
			
			stmt = con.createStatement();
			System.out.println("Platform Created");
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