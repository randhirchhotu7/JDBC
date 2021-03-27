package org.thunder.LightApp;

public class LightFactory 
{
	public static ISwitch getLight(String type)
	{
		if(type.equalsIgnoreCase("Tubelight"))
		{
			return new TubelightImpl();
		}
		else if(type.equalsIgnoreCase("Ledlight"))
		{
			return new LedlightImpl();
		}
		else
		{
			System.err.println("No Light Found !!");
		}
		return null;
	}
}
