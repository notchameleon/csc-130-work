package queues;
import exceptionclasses.EmptyQueueException;

/**
 * <p>Title: The LinkedQueue Class</p>
 *
 * <p>Description: Defines the properties and behaviors of a linked queue.</p>
 *
 * @author Steffano, Ibrahim 
 */
 
public class LinkedQueue<E> implements QueueADT<E>
{
	private Node<E> front, rear; //references to the first and last nodes

	/**
	 * default constructor - creates an empty queue
	 */
	public LinkedQueue()
	{
		front = rear = null;
	}
	
	/**
	enqueue() - Adds the specified thing item to be added to the rear of the queue.
	FIFO, the first element is added, then rear links to the node  with the enqueued elements.
	 */
	public void enqueue (E newItem)
	{
		Node<E> current = new Node<E>(newItem); // we are adding to the back of line.
		
		//When Queue is empty (adds the first element)
		if (isEmpty()) 
		{
			front = current;
			rear = current;
		} else
		{ //  When Queue has one element (adding second element)
			
			rear.setNext(current); // Link current rear to new node
			rear = current; // Update rear to point to new node
		}
		
	}

	/**
	 * dequeue method - removes the item at the front of the queue
	 * @return a reference to the item removed from the front of the queue
	 * @throws an EmptyQueueException if the queue is empty
	 * 
	 * theQUeue.dequeue()
	 */
	public E dequeue() throws EmptyQueueException
	{
		if (front == null && rear == null) // checks if the queue is empty.
		{ 
 			throw new EmptyQueueException("Queue is empty");
		
		}
		
		E returnItem = front.getItem();
		
		front = front.getNext();
		if (front == null)
			rear = null;
		
		return returnItem;
	
	
	}

	/**
	 * front method - returns a reference to the item at the front of the queue
	 * without removing it from the queue
	 * @return a reference to the item at the front of the queue
	 * @throws an EmptyQueueException if the queue is empty  
	 */
	public E front() throws EmptyQueueException 
	{
		if (isEmpty())
		{
			throw new EmptyQueueException("Queue is empty");
		}
		return front.getItem();
	}

	/**
	 * isEmpty method - determines whether or not the queue is empty
	 * @return true if the queue is empty; false if the queue is not empty
	 */
	public boolean isEmpty()
	{
		boolean loc = false;
		
		if (front == null && rear == null) 
		{ // checks if the queue is empty.
			loc = true;
			return loc;
		} 
		else 
		{
			return loc;
		}
	}

	/**
	 * size method - returns a count of the number of items in the queue
	 * @return the number of items in the queue
	 */
	public int size()
	{
		if( isEmpty()) {
			return 0;
		}
		
		Node<E> current = front;
		int count = 0;
		
		while (current != null) {
			count++;
			current = current.getNext();
		}
		
		
		return count;
	}
	
	/**
	 * toString method - returns a String representing the state of the queue
	 * @return a string containing all items in the queue
	 */
	public String toString()
	{
		if (isEmpty()) 
		{
			return "";
		}
		
		Node<E> current = front;
		String returnMe = "";
		
		while (current != null) 
		{
		returnMe += current.getItem().toString() + "\n";
		current = current.getNext();
		//come back to later to solve for null issue
		}
		return returnMe;
	}
	
	/*
	 * search() method - finds specific item int 1-based position.
	 * The method traverses the queue from front to rear, checks each of the reference item, = 1 or to 2.  
	 * 
	 * @param newItem accepts a type of item to search for in queue. 
	 * @return a number based indexed if 1 to search for a 1 based position.
	 * then number based indexed if 2 to search for a 2 based position.
	 */
	
	
	public int search(E newItem) {
		
		
		if (isEmpty())
		{
			return -1;
		}
		
		
		Node<E> current = front;
		int position = 1;
		
		while(current != null)
		{
			if (current.getItem().equals(newItem)) 
			{
			return position;
		}
			position++;
			current = current.getNext();
			
	}	
		
	return -1; // Item not found 
	
	}
	/*
	 * 
	 * removeLast() method - removes and return the last thing
	 * added to queue (takes  the thing at  the rear  of the queue)
	 * then updates the rear reference to null.
	 * @throws EmptyQueueException if the queue is empty.
	 * @return 
	 */
	
	
	public E removeLast() throws EmptyQueueException 
	{
		if (isEmpty()) // checks if the queue is empty.
		{ 
 			throw new EmptyQueueException("Queue is empty");
		
		}
		
		//Special case 1
		
		if (front == rear)
		{
			E returnItem = rear.getItem();
			
			front = null;
			rear = null;
			return returnItem;
		}
			
		
		Node<E> current = front;
		//Traverses the node before rear- 
		//it must be the front before it gets to the rear.
		while (current.getNext() != rear) 
		{
			current = current.getNext();
		}
		
		E returnItem = rear.getItem();
		rear = current;
		rear.setNext(null);
		
		return returnItem;
	
	}
	
}
	
	
	
	
	

	

