package org.thunder.BikeApp;
public class BikeFactory 
{
	public static  IBike getBike(String type)
	{
		if(type.equalsIgnoreCase("RoyalEnfield"))
		{
			return new RoylEnfieldImpl();
		}
		else if(type.equalsIgnoreCase("Dominar"))
		{
			return new DominarImpl();
		}
		else 
		{
			System.err.println("Sorry !! No such Bike Available !!");
		}
		return null;
	}

}
