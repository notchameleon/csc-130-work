package project1csc130;

/*
 * 
 * Abstract base class representing a generic type vehicle
 * This class is supposed to have common features with Cars and buses.
 * @Steff
 */


public abstract class Vehicle {
	
	
	protected int horsepower;
	protected int position;
	protected int previousPosition; // Stores the position before the movement attempt
	protected boolean isActive; // Indicates status of a Vehicle Object in Road[]  Array
	
	
	/*
	 * Vehicle constructor
	 * @param horsepower vehicle power
	 * @param position starting point?
	 */
	
	public Vehicle(int horsepower, int position) {
		this.horsepower = horsepower;
		this.position = position;
		this.previousPosition = position;
		this.isActive = true;
	}
	
	/*
	 * getHorsepower() method
	 * @return  horsepower value
	 * 
	 */
	
	public int getHorsepower() {
		return horsepower;
	}
	
	
	/*
	 * getPreviousposition() method
	 * Gets the previous positoin before the last move
	 * @return previousposition index 
	 */
	
	public int getPreviousposition()
	{
		return previousPosition;
	}
	
	/*
	 * isActive method() 
	 * Returns if the position of the vehicle
	 * is either active or not.
	 * 
	 */
	
	public boolean isActive() {
		return isActive;
	}
	
	/*
	 * setActive() 
	 * Returns true or false
	 * 
	 */
	public void setActive(boolean active)

	{
		 this.isActive = active;
	}
	
	public int getPosition() {
		return position;
	}
	
	
	/*
	 * setPosition() method
	 * Sets the position of the vehicle
	 * @param int position new position index
	 * 
	 */
	
	public void setPosition(int position) { 
		this.position = position; 
	}
	
	/*
	 * toString() method
	 * String representation of vehicle
	 * @return String with vehicle type and attributes
	 * 
	 */
	
	//Our Child classes will implement new toString methodds. Thats why it like that?
	@Override
	public abstract String toString();
	
	
	/* isActive() method
	 * Checks if movement is valid within road boundaries
	 * @param newPosition new position
	 * @param
	 * 
	 */
	
	
	
	/**
	 * move() 
     * Moves the vehicle in the specified direction supposed to have different logic
     * but car and bus have same logic movements.
     * my eror
     */
	
	public abstract void move(int direction);

}
