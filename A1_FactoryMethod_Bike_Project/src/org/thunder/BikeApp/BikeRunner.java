package org.thunder.BikeApp;
import java.util.Scanner;
public class BikeRunner 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Tell me what Type of Bike U want : ");
		String BType = sc.next();
		sc.close();
		IBike bk = BikeFactory.getBike(BType); // since getBike is a static method //
		if(bk!=null)
		{
			bk.StartBike();
			bk.RideBike();
			bk.StopBike();
		}
		
	}
}
