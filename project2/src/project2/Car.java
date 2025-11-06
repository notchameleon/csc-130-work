package project2;


/*
 * Represents a car vehicle with color attribute
 * extends Vehicle abstract class
 * 
 * @author steff
 */

public class Car extends Vehicle {
	private String color;
	
	/*
	 * Constructor a car with specified color and horsepower
	 * 
	 * @param Color the color of car
	 * @param hp the horsepower of the car
	 */
	
	public Car(String color, int hp) 
	{
		super(hp);
		this.color = color;
	}
	
	
	/*
	 * Returns the color of the car
	 * @return color color of car
	 */
	
	public String getColor()
	{
		return color;
	}
	
	/*
	 * Retruns a string representation of the car
	 * @return the String representatino of car
	 */
	
	public String toString() 
	{
		return "Car (color of car=" + color + ", hp =" + hp + ")";
	}
	
	
	
	
}
