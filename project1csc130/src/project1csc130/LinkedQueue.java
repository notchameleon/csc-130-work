package project1csc130;



/*
 * Linked list of a queue.
 */

public class LinkedQueue <T>{
	private Node<T> front;
	private Node<T> rear;
	
	private int size; 
	
	/*
	 * default constructor - creates an empty queue
	 * sets front and rear = null. &
	 * size = 0.
	 * 
	 */
	
	public LinkedQueue() 
	{
		front = rear = null;
		size = 0;
	}
	
	/*
	 * enqueue() - void
	 * Adds speicified element into the rear of the queue.
	 * @param element - item to add inside of it.
	 */
	
	
	public void enqueue(T element) 
	{
		Node<T> loc = new Node<T>(element);
		
		
		//When Queue is empty (adds first element - both pointerrs are referenced to queue.)
		if (isEmpty())
		{
			front = loc;
			rear = loc;
		} else // When Queue has an element inside.
		{
			rear.setNext(loc);
			rear = loc;
		}
		size++;
	}
	
	
	/*
	 * dequeue() - T
	 * Removes specififed element from the front of the queue.
	 * @returns the element of the front
	 * @throws EmptyQueueException if queue is empty
	 */
	
	public T dequeue() throws EmptyQueueException
	{
		if (isEmpty())
		{
			throw new EmptyQueueException("Cannot dequeue from empty queue");
		}
		
		T data = front.getItem();
		front = front.getNext();
		
		if (front == null) 
		{
			rear = null;
		}
		size--;
		return data;
	}
	
	/*
	 * peek() - T
	 * Returns the specified element from the front of the queue.
	 * @returns the element of the front queue.
	 * @throws EmptyQueueException if queue is empty - it cant take a peek into it.
	 */


	public T peek() throws EmptyQueueException
	{
		if (isEmpty())
		{
			throw new EmptyQueueException("Cannot dequeue from empty queue");
		}
		
		return front.getItem();
	}
	
	/*
	 * isEmpty()
	 * Checks if queue is empty
	 * return true if queue is empty.
	 */

	public boolean isEmpty() 
	{
		return front == null;
	}
	
	
	/*
	 * size()
	 * Returns the number of elements in queue
	 * @return size of queue
	 */
	
	public int size() 
	{
		return size;
	}
}