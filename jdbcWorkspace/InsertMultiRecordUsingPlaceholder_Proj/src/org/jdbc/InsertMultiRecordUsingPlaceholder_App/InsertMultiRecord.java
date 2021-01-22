//	Insert Multiple value to database using place holder 

package org.jdbc.InsertMultiRecordUsingPlaceholder_App;
import java.sql.*;
public class InsertMultiRecord 
{
	public static void main(String[] args) 
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		String qry="insert into btm.student values(?,?,?)";
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=thunder");
			pstmt=con.prepareStatement(qry);
//			Set values for place holder before execution//
//			1st data
			pstmt.setInt(1,70);
			pstmt.setString(2,"Siddharth");
			pstmt.setDouble(3,77.47);
			
			//Now execute the sql query//
			pstmt.executeUpdate();
			
//			2nd data
			pstmt.setInt(1,71);
			pstmt.setString(2,"Sandy");
			pstmt.setDouble(3,87.07);
			pstmt.executeUpdate();
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
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
