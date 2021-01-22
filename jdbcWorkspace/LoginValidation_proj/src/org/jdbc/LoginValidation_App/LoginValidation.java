//	Login validation

package org.jdbc.LoginValidation_App;
import java.sql.*;
import java.util.Scanner;
public class LoginValidation 
{
	public static void main(String[] args) 
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String qry="Select username from btm.user where name=? and password=?";
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter name : ");
		String UName=sc.next();
		System.out.print("Enter password : ");
		String UPwd=sc.next();
		
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=thunder");
			pstmt=con.prepareStatement(qry);
			//Set Placeholder value //

			pstmt.setString(1,UName);
			pstmt.setString(2,UPwd);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				String userName=rs.getString(1);
				System.out.println("Welcome "+userName);
			}
			else
			{
				System.err.println("Invalid name/password !!");
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
