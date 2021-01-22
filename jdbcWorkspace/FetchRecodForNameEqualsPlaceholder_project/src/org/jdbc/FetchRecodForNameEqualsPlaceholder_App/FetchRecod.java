//	Fetching Record from Database using Placeholder( Name = Placeholder )

package org.jdbc.FetchRecodForNameEqualsPlaceholder_App;

import java.sql.*;
import java.util.Scanner;

public class FetchRecod 
{
	public static void main(String[] args) 
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String qry="select * from btm.student where Name=?";
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a Name to search in the database : ");
		String qrName=sc.next();
		sc.close();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=thunder");
			pstmt=con.prepareStatement(qry);
			//Set value of placeholder //
			pstmt.setString(1,qrName);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				int id=rs.getInt(1);
				double perc=rs.getDouble(3);
				System.out.println("["+id+","+perc+"]");
			}
			else
			{
				System.err.print("Entered name "+qrName+" is not available in database !!");
			}
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			if(rs!=null)
			{
				try 
				{
					rs.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
			if(pstmt!=null)
			{
				try 
				{
					pstmt.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}if(con!=null)
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
		}
	}
}
