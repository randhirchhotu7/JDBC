package org.thunder.LightApp;
import java.util.Scanner;
public class LightRunner 
{
	public static void main(String[] args) 
	{	
		Scanner sc = new Scanner(System.in);
		System.out.println("Tell me what Type of light U want : ");
		String lType = sc.next();
		sc.close();
		ISwitch sw = LightFactory.getLight(lType);
		if(sw!=null)
		{
			sw.SwitchOnn();
			sw.SwitchOff();
		}
	}

}
