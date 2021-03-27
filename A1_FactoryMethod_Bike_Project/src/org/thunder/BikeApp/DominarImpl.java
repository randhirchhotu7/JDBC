package org.thunder.BikeApp;
class DominarImpl implements IBike
{
	@Override
	public void StartBike()
	{
		System.out.println("Start the Sportyy !!");
	}
	
	@Override
	public void RideBike()
	{
		System.out.println("Ride on sportyy !!");
	}
	
	@Override
	public void StopBike()
	{
		System.out.println("Off the sportyy Ignition engine");
	}
}