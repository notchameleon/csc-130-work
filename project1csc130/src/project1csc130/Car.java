package project1csc130;
/*
 * Car class representing a car vehicle 
 * Cars will have color
 * @author Steff
 */
public class Car extends Vehicle {
	private String color; 
	
	/*
	 * Constructor for Car Class
	 * @param String color of car 
	 * @param int horsepower of car
	 * @param position initial position on the road/array?
	 */
	
	
	public Car(String color, int horsepower, int position) {
		super(horsepower, position);
		this.color = color;
	}
	
	
	/*
	 * Moves the car based on the direction 
	 * @param direction movement direction (-1,0,1)
	 * @param roadLength length of array?
	 * @return new position after movement attempt
	 * 
	 */
	
	@Override
	public void move(int direction) {
		previousPosition = position;

		
		if (direction == -1) {
			position--; // back
		} else if (direction == 1) {
			position++; // forward
		}
		
		}
	
	/*getColor() method
	 * Gets the color of the car.
	 * @return car color
	 */
	
	public String getColor() {
		return color;
	}
	
	
	/*
	 * toString() method
	 * String representation of car
	 * @return string with car details
	 */
	
	public String toString() {
		return "Car: Color = " + color + "\n" +
	 "hp=" + horsepower + "\n" + "pos=" + position 
	+ "\n";
	
	}
	
	
	

}
