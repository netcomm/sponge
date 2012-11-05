package com.jd.sponge;

public class SpongeService
{
	private PersistenceIntf thePersistence;
	
	public SpongeService(PersistenceIntf thePersistenceParm)
	{
		thePersistence = thePersistenceParm;
	}

	public PersistenceIntf getThePersistence()
	{
		return thePersistence;
	}

	public void setThePersistence(PersistenceIntf thePersistence)
	{
		this.thePersistence = thePersistence;
	}
}
