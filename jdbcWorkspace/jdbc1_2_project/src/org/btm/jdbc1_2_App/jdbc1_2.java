package org.btm.jdbc1_2_App;
import java.sql.*;
public class jdbc1_2 
{
	public static void main(String[] args) 
	{
		Connection con = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Class Loaded and Registered !!");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=thunder");
			System.out.println("Connection established with DB server !!");
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
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
			System.out.println("Connection established with DB server !!");
		}
	}
}
