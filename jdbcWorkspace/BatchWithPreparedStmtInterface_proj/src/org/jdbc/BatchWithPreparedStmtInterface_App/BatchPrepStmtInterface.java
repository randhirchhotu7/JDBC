package org.jdbc.BatchWithPreparedStmtInterface_App;

import java.sql.*;
public class BatchPrepStmtInterface
{
	public static void main(String[] args)
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		PreparedStatement pstmt2=null;
		String inqry="insert into btm.employee values(11,'Shashi',65000.00)";
		String delqry="delete from btm.student2 where id=1 ";
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=thunder");
			pstmt=con.prepareStatement(inqry);
			//	Add DML query to Batch //
			pstmt.addBatch();
			int arr1[]=pstmt.executeBatch();
			for(int i : arr1)
			{
				System.out.print(i+" ");
			}
			
			System.out.println();
			pstmt2=con.prepareStatement(delqry);
			pstmt2.addBatch();
			int arr2[]=pstmt2.executeBatch();
			for(int j : arr2)
			{
				System.out.print(j+" ");
			}
		}
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(pstmt2!=null)
			{
				try 
				{
					pstmt2.close();
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