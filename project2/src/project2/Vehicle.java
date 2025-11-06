package project2;

/*
 * Abstract class represents a vehicle in traffic simulation
 * Common attributes and behaviors of Vehicles
 * int hp, isActive
 */

public abstract class Vehicle {
	protected int hp;
	protected boolean isActive;
	
	
	
	/*
	 * Parameterized constructor
	 * @param HP, a new horsepower data assigned to the value hp;
	 */
	public Vehicle(int HP) 
	{
		hp = HP;	
		this.isActive = true;
	}
	
	/*
	 * getHp() - int
	 * retrieves the value of horsepower
	 * @return hp - horsepower of vehicle
	 */
	
	public int getHp() 
	{
		return hp;
	}
	
	/*
	 * isActive() - boolean
	 * determine whether the vehicle state
	 * is either
	 * active in the road array
	 * @return true if vehicle is in the array, false not.
	 */
	public boolean isActive() 
	{
		return isActive;
	}
	
	/*
	 * 
	 * setActive() - void
	 * sets and changes if the vehicle is active 
	 * or inactive
	 * @param activity - boolean determines true or false)
	 * 
	 */
	
	public void setActive(boolean activity) 
	{
		isActive = activity;
	}
	
	/*
	 * Returns a string representation of the vehicle/
	 * @return string representation 
	 */
	
	@Override
	public abstract String toString();
	
}
