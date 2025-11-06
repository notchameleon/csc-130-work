package project1csc130;

/*
 * 
 * 
 * Bus Class
 * Bus will have weight
 * @author Steff
 */

public class Bus extends Vehicle {
	private int weight;
	
	
	/*
	 * Bus constructor
	 * @param weight- vehicles weight
	 * @param horsepower vehicle power
	 * @param position starting point?
	 */
	
	public Bus (int weight , int horsepower, int position) {
		super(horsepower, position);
		this.weight = weight;
	}
	
	
	/*
	 * move() method
	 * it moves the positioning of the bus
	 * 
	 */ 
	@Override
	public void move(int direction) {
		//Same logic as car.
		previousPosition = position;
		
		 if (direction == -1) {
	            position--;
	        } else if (direction == 1) {
	            position++;
	        }
	
	}
	
	/*
	 * getWeight() 
	 * @return int weight. 
	 */
	
	public int getWeight() {
		return weight;
	}
	
	
	
	
	/*
	 * toString() 
	 * @return String representation of a bus.
	 * 
	 */
	public String toString() {
		return "Bus: Weight =" + weight + "\n" +
				 "hp=" + horsepower + "\n" + "pos =" + position 
				+ "\n";
	}
	
	
	
	
	
	
}
