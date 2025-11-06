package project2;


/*
 * A generic linkedlist queue implementation
 * Provides FIFO operations on storing elements
 * 
 * @author steff;)
 * 
 */
public class LinkedQueue<T>{
	private Node<T> front;
	private Node<T> rear;
	
	/*
	 * Construct a empty linkedqueue
	 */
	
	public LinkedQueue() 
	{
		front = null;
		rear = null;
	}
	
	/*
	 * enqueue() - void
	 * enqueues an item to the rear of the queue
	 * @param T element element to enqueue in front of the rear.
	 */
	
	public void enqueue(T element) 
	{
		Node<T> newNode =  new Node<T>(element);
		
		if (isEmpty())
		{
			front = newNode;
			rear = newNode;
		} 
		
		else 
		
		{
			rear.setNext(newNode);
			rear= newNode;
		}
	}
	
	
	
	/*
	 * dequeue() = T
	 * Removes the front position element .
	 * @throws EmptyQueueException
	 */
	
	public T dequeue() throws EmptyQueueException 
	{
		if (isEmpty())
		{
			throw new EmptyQueueException("Cannot dequeue from empty queue");
		}
		
		T data = front.getData();
		front = front.getNext();
		
		if (front == null)
		{
			rear = null;
		}
		
		return data;
	}
		
	
	/*
	 * Checks whether the queue is empty
	 * 
	 * @return true if queue is empty, false otherwise
	 */
	
	public boolean isEmpty() 
	{
		return front == null;
	
	
	
	}

	
	
}
