//	Fetching Record from Database using Placeholder( Id=Placeholder )

package org.jdbc.FetchRecordFromIDEqualsPlaceholder_App;

import java.sql.*;
import java.util.Scanner;
public class FetchRecord 
{
	public static void main(String[] args) 
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String qry="Select * from btm.student where id=?";
		
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter Id to find from DataBase : ");
		int Idval=sc.nextInt();
		sc.close();
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=thunder");
			pstmt=con.prepareStatement(qry);
			
			//Set values for placehilder before execution //
			pstmt.setInt(1,Idval);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				String name=rs.getString(2);
				double perc=rs.getDouble(3);
				System.out.println("["+name+","+perc+"]");
			}
			else
			{
				System.err.print("No Data is Available for Id : "+Idval);
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
				} catch (SQLException e) 
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
		}
	}
}
