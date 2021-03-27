package org.btm.DBallOperation_App;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBallOperation 
{
	public static void main(String[] args) 
	{
		Connection con = null;
		Statement stmt = null;
		String qry1 = "insert into btm.student values(14,'Rohan',67.77)";
//		String qry2= "update btm.student set name='Kamal' where id=3";
//		String qry3 = "delete from btm.student where id=1";
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Class Loaded and Registered !!");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=thunder");
			System.out.println("Connection established with DB server !!");
			
			stmt = con.createStatement();
			System.out.println("Platform Created");
			
			stmt.executeUpdate(qry1);
//			stmt.executeUpdate(qry2);
//			stmt.executeUpdate(qry3);
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
