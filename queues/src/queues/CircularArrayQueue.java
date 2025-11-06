package queues;

/*
* CircularArrayClass Title
* @authors Steffano & Ibrahim
* 
*/

import exceptionclasses.*;

	/**
	 * <p>Title: CircularArrayQueue Class</p>
	 *
	 * <p>Description: Provides basic CircularArray Queue functionality, including the ability
	 * to enqueue and dequeue items to/from the queue, get the front-most item,
	 * determine whether or not the queue is empty, determine the queue's size,
	 * and to get a String representation of the items in the queue.</p>
	 *
	 *
	 * @author <Steff & Ibrahim>
	 * N00982959, N00963924
	 */

	public class CircularArrayQueue<E> implements QueueADT<E>
	{

	private int front;
	private int rear;
	private E[] contents;
	private int count;

	/**
	* default constructor -- creates an empty queue.
	*/
	@SuppressWarnings("unchecked")
	public CircularArrayQueue()
	{
	front = 0;
	rear = 0;
	contents = (E[]) (new Object[100]);
	count = 0;
	}

	/**
	* parameterized constructor --
	* creates an empty queue that is initially capable of storing
	* 'size' items.
	* @param size the initial size of the queue as specified by the user
	*/
	@SuppressWarnings("unchecked")
	public CircularArrayQueue(int size)
	{
	front = 0;
	rear = 0;
	if (size > 0)
	contents = (E[]) (new Object[size]);
	else
	contents = (E[]) (new Object[100]);
	count = 0;
	}

	/**
	* enqueue --
	* stores a new item at the rear of the queue; if the queue becomes
	* full, it's size is automatically increased to accommodate additional items.
	* @param newItem a reference to the item to be stored at the rear of the queue
	*/
	public void enqueue(E newItem)
	{
		
		if (count == contents.length) // If the count is equal to contents.length
		{
			expandCapacity();
		}
		
		contents[rear] = newItem; // we are adding to the back of line.
		
		
		rear = (rear + 1) % contents.length;
		
		count++;
		


	}
	
	/**
	* deQueue -- removes the front-most item from the queue.
	* @return a reference to the object which was stored at the front of the
	* queue
	* @throws EmptyQueueException if the queue is empty
	*/
	public E dequeue() throws EmptyQueueException
	{
		
		if (isEmpty())
		{
			throw new EmptyQueueException("CircularArrayQueue collection is empty");
		}
		
		
		E current = contents[front]; // Stores front item
		
		contents[front] = null; 
		
		
		front = (front + 1) % contents.length;
		
		count--;
		
		return current; //returns front item
	}

	/**
	* front --
	* returns the item stored at the front of the queue; the queue
	* is not modified.
	* @return a reference to the object which is stored at the front of the queue
	* @throws EmptyQueueException if the queue is empty
	*/
	public E front() throws EmptyQueueException
	{
	if (isEmpty())
	throw new EmptyQueueException("CircularArrayQueue is empty!");
	else
	return contents[front];
	}

	/**
	* isEmpty -- determines whether or not the queue is empty.
	* @return true if the queue is empty; false otherwise
	*/
	public boolean isEmpty()
	{
	return count == 0;
	}

	/**
	* count -- returns the count of the number of items in the queue.
	* @return count
	*/
	public int size()
	{
	return count;
	}

	/**
	* expandCapacity --
	* a private method called upon by the enqueue method when the queue
	* becomes full; the queue size is doubled to accommodate the storage of
	* additional items.
	*/
	@SuppressWarnings("unchecked")
	private void expandCapacity()
	{
		E[] larger = (E[]) new Object[contents.length *2]; // Double the storage 
		
		for (int i = 0; i < count; i++)
		{
		
		larger[i] = contents[front]; // Start at front index of old array - Copies each element to the beginning of new array. 
		front = (front+1) % contents.length; // Increment and circle through the array.
		}
		
		front = 0; // Elements start at a beginning of new array.
		rear = count; // Next available position.
		contents = larger; // Replaces the reference of old small array
		// To the larger array.
	}

	/**
	* toString method - returns a String representing the current state of the queue.
	* @return a String containing all items in the queue
	*/
	public String toString()
	{
	String returnMe = "";
	int local = front;

	
	if (isEmpty()) {
		System.out.println("");
	}
	
	
	for ( int i = 0; i < count; i++) 
	{
		
		
		returnMe += (contents[local].toString() + "\n");
		
		local = (local + 1) % contents.length;
		
	}
	// local  = (local + 1) % contents.length;
	
	
	return returnMe;
	}
	
	
	/*
	 * search method
	 * search for an element in the quue and returns its position (1 based) 
	 * @param newItem the item to search for
	 * @return the position of the item ( 1=  front , 2 = second,) or -1 not found.
	 * 
	 */
	
	
	public int search(E newItem) 
	{
		if (isEmpty()) {
			return -1;
		}
		
		int position = 1;
		
		int current = front;
		
		for (int i = 0; i < count; i++) 
		{
			if ( contents[current] != null && contents[current].equals(newItem)) {
				return position;
			}
			
			position++;
			current = ( current + 1) % contents.length;
		}
		
		return -1;
	}
		
		
}	