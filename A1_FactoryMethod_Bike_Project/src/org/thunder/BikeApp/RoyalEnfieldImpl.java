package org.thunder.BikeApp;
class RoylEnfieldImpl implements IBike
{
	@Override
	public void StartBike()
	{
		System.out.println("Start the Bullet !!");
	}
	
	@Override
	public void RideBike()
	{
		System.out.println("Ride the Bullet !!");
	}
	
	@Override
	public void StopBike()
	{
		System.out.println("Off the Ignition engine of Bullet !!");
	}
}

