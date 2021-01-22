package org.jdbc.BatchWithStmtInterface_App;

import java.sql.*;

public class Batch_StmtInterface 
{
	public static void main(String[] args)
	{
		Connection con=null;
		Statement stmt=null;
		String inqry="insert into btm.student2 values(2,'Rahul','Mech',60.33)";
		String upqry="update btm.employee set salary=40000 where id = 1";
		String delqry="delete from btm.employee where salary=30000";
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=thunder");
			stmt=con.createStatement();
			//	Add DML query to Batch //
			stmt.addBatch(inqry);
			stmt.addBatch(delqry);
			stmt.addBatch(upqry);
			//Execute Batch//
			int arr[]=stmt.executeBatch();
			for(int i : arr)
			{
				System.out.print(i+" ");
			}
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
			
			
		}
	}
}
