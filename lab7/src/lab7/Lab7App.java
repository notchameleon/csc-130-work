package lab7;

import exceptionclasses.EmptyQueueException;
import queues.CircularArrayQueue;


/*
 * Lab7App Title
 * @authors Steffano & Ibrahim
 * N00982959, N00963924
 * 
 * Demonstrates the usage of CircularArrayQueue data structure - test all the 
 * normal behaviors of queue , enqueue - dequeue - search with its own 
 * behaviors and properties since its circulararrayqueue not a linkedqueue.
 * 
 * The queue stores product objects and modifies elements within the application class
 * 	 *Calculates total quantities and modifies product attributes within queue structure.

 * 
 */


public class Lab7App {
	public static void main ( String[] args) {
	
	CircularArrayQueue<Product> theQueue = new CircularArrayQueue<Product>(3);
	Product p1 = new Product("111" , 1 , 1.99);
	Product p2 = new Product("222" , 2 , 2.99);
	
	System.out.print("theQueue contains:"); 
	
	theQueue.enqueue(p1);
	theQueue.enqueue(p2);
	
	
	
	System.out.print("\ntheQueue contains: \n" + theQueue.toString());
	
	
	try 
	{
		System.out.println("\nDequeued Item: " + theQueue.dequeue());
	} catch (EmptyQueueException ex) 
	{
		System.out.println( ex.getMessage());
	}
	

	System.out.print("\ntheQueue contains: \n" + theQueue.toString());
	
	try 
	{
		System.out.println("\nDequeued Item: " + theQueue.dequeue());
	} catch (EmptyQueueException ex) 
	{
		System.out.println( ex.getMessage());
	}
	
	Product p3 = new Product("333" , 3 , 3.99);
	Product p4 = new Product("444" , 4 , 4.99);
	
	theQueue.enqueue(p3);
	theQueue.enqueue(p4);
	
	System.out.print("\ntheQueue contains: \n");
	System.out.print("\ntheQueue contains: \n" + theQueue.toString());
	
	Product p5 = new Product("555" , 5 , 5.99);
	Product p6 = new Product("666" , 6 , 6.99);
	
	theQueue.enqueue(p5);
	theQueue.enqueue(p6);
	
	System.out.println("\nThe size of the queue has been expanded to 6");
	
	System.out.print("theQueue contains: \n" + theQueue.toString());
	
	Product p7 = new Product("777" , 7 , 7.99);
	Product p8 = new Product("888" , 8 , 8.99);
	
	theQueue.enqueue(p7);
	theQueue.enqueue(p8);
	
	System.out.print("\ntheQueue contains: \n" + theQueue.toString());
	
	System.out.println("\nDequeue all:");
	
	try 
	{
		System.out.println("Dequeued Item: " + theQueue.dequeue());
		System.out.println("Dequeued Item: " + theQueue.dequeue());
		System.out.println("Dequeued Item: " + theQueue.dequeue());
		System.out.println("Dequeued Item: " + theQueue.dequeue());
		System.out.println("Dequeued Item: " + theQueue.dequeue());
		System.out.println("Dequeued Item: " + theQueue.dequeue());

	} catch (EmptyQueueException ex)
	{
		System.out.println( ex.getMessage());
	}
	
	System.out.print("\ntheQueue contains: \n" + theQueue.toString());
	System.out.println("\nDequeue on an empty queue:");
	
	
	try 
	{
	System.out.print("\nDequeue on empty queue:\n" + theQueue.dequeue());
	System.out.print("\nDequeue on empty queue:\n" + theQueue.dequeue());
	} catch (EmptyQueueException ex) 
	{
		System.out.println( ex.getMessage());
	}
	
	System.out.println("theQueue has been re-created and it contians:");
	
	theQueue = new CircularArrayQueue<Product>(3);
	
	
	System.out.println("theQueue has been re-created and it contains:\n" + theQueue.toString());
	
	System.out.println("The product with id 555 was found at position " + theQueue.search(new Product("555", 0 , 0)));
	 
	
	p1 = new Product("111" , 10 , 1.99);
	p2 = new Product("222" , 20 , 2.99);
	p3 = new Product("333" , 30 , 3.99);
	theQueue.enqueue(p1);
	theQueue.enqueue(p2);
	theQueue.enqueue(p3);


	System.out.print("\ntheQueue contains: \n" + theQueue.toString());
	p4 = new Product("444" , 40 , 4.99);


	try 
	{
		System.out.println("\nDequeued Item: " + theQueue.dequeue());
		System.out.print("\ntheQueue contains: \n" + theQueue.toString());
	} catch (EmptyQueueException ex) 
	{
		System.out.println( ex.getMessage());
	}
	theQueue.enqueue(p4);
	System.out.print("\ntheQueue contains: \n" + theQueue.toString());


	System.out.println("\nThe product with id 222 was found at position " + theQueue.search(p2));
	System.out.println("The product with id 555 was found at position " + theQueue.search(new Product("555", 0 , 0)));
	System.out.println("The product with id 333 was found at position " + theQueue.search(p3));
	System.out.println("The product with id 444 was found at position " + theQueue.search(p4));


	int totalQuantity = 0;

	CircularArrayQueue<Product> temporaryQueue = new CircularArrayQueue<Product>(3);

	while(!theQueue.isEmpty())
	{
		try
		{
			Product current = theQueue.dequeue();
			totalQuantity += current.getQuantity();
			temporaryQueue.enqueue(current);
		} catch (EmptyQueueException ex) 
		{
			System.out.println(ex.getMessage());
		}
	}

	while (!temporaryQueue.isEmpty())
	{
		try
		{
			theQueue.enqueue(temporaryQueue.dequeue());
		} catch (EmptyQueueException ex)
		{
			System.out.println(ex.getMessage());
		}
	}


	System.out.println("\nTotal quantity on hand: " + totalQuantity );

	try {
		Product frontProduct = theQueue.dequeue();
		if ( frontProduct != null )
		{
			frontProduct.setQuantity(10);
		}

		CircularArrayQueue<Product> tempQueue2 = new CircularArrayQueue<Product>(3);

		tempQueue2.enqueue(frontProduct);

		while(!theQueue.isEmpty())
		{
			tempQueue2.enqueue(theQueue.dequeue());
		}

		while(!tempQueue2.isEmpty())
		{
			theQueue.enqueue(tempQueue2.dequeue());
		}

	} catch (EmptyQueueException ex) 
	{
		System.out.println(ex.getMessage());
	}

	System.out.print("\ntheQueue contains: \n" + theQueue.toString());


	}

}
