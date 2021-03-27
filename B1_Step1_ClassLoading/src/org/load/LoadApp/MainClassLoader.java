package org.load.LoadApp;
public class MainClassLoader 
{
	public static void main(String[] args) 
	{
		try 
		{
			Class.forName("org.load.LoadApp.Student");
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
	
}
