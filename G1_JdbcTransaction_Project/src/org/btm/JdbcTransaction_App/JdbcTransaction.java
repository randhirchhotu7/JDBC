package org.btm.JdbcTransaction_App;

import java.sql.*;
import java.util.*;

public class JdbcTransaction 
{
	public static void main(String[] args) 
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		String inqry1 = "insert into BTM.Student1 values(?,?,?,?)";
		String inqry2 = "insert into BTM.Student2 values(?,?,?)";
		Scanner sc = new Scanner(System.in);
		System.out.println("enter ID??");
		int id =sc.nextInt();
		System.out.println("Enter name");
		String name=sc.next();
		System.out.println("Enter dept");
		String dept=sc.next();
		System.out.println("enter perc");
		double perc=sc.nextDouble();
		System.out.println("Enter place");
		String place=sc.next();
		sc.close();

		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=tiger");
			//disable AutoCommit()//
			con.setAutoCommit(false);
			pstmt=con.prepareStatement(inqry1);
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, dept);
			pstmt.setDouble(4,perc);
			pstmt.executeUpdate();
			System.out.println("Student1 complete");
			pstmt1=con.prepareStatement(inqry2);
			pstmt1.setInt(1, id);
			pstmt1.setString(2, name);
			pstmt1.setString(3, place);
			pstmt1.executeUpdate();
			System.out.println("Student2 complete");
			con.commit();
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			try 
			{
				con.rollback();
				System.out.println("rolled out");
			} catch (SQLException e1)
			{
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		finally 
		{
			if (pstmt1 != null) 
			{
				try 
				{
					pstmt.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
			if (pstmt != null) 
			{
				try 
				{
					pstmt.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
			if (con != null) 
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
			System.out.println("aal costly resources closed");
		}

	}

}
