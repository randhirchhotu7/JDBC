package org.thunder.LightApp;

class LedlightImpl implements ISwitch
{
	@Override
	public void SwitchOnn()
	{
		System.out.println("Turn on the LedLight!!");
	}
	@Override
	public void SwitchOff()
	{
		System.out.println("Plz TurnOff the LedLight !!");
	}
}