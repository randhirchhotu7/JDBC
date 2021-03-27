package org.btm.DBmultiInsert_App;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class DBmultiInsert 
{
	public static void main(String[] args) 
	{
		Connection con = null;
		Statement stmt = null;
		String qry1 = "insert into btm.student values(5,'Rajat',37.56)";
		String qry2 = "insert into btm.student values(6,'jack',80.00)";
		String qry3 = "insert into btm.student values(7,'raja',71.77)";
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Class Loaded and Registered !!");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=thunder");
			System.out.println("Connection established with DB server !!");
			
			stmt = con.createStatement();
			System.out.println("Platform Created");
			
			stmt.executeUpdate(qry1);
			stmt.executeUpdate(qry2);
			stmt.executeUpdate(qry3);
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
