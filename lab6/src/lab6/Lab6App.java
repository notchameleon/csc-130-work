package lab6;

import exceptionclasses.EmptyQueueException;
import queues.LinkedQueue;



/*
 * Title: Lab 6 – LinkedQueue Operations
 * Authors: Ibrahim and Steffano
 * ID: N00982959, N00963924
 *
 * Description:
 * Demonstrates queue operations using Product objects, including enqueue, dequeue, front,
 * search, removeLast, and isEmpty, size, with exception handling for empty queues.
 * 
 */

public class Lab6App {
	public static void main(String[] args) {
		LinkedQueue<Product> theQueue = new LinkedQueue<Product>();

		System.out.println("theQueue contains:\n" + theQueue.toString());

		if (theQueue.isEmpty()) {
			System.out.println("Calling the isEmpty method: theQueue is empty");
		} else {
			System.out.println("Calling the isEmpty method: theQueue is NOT empty");
		}

		Product p1 = new Product("111", 10, 1.99);
		Product p2 = new Product("222", 20, 2.99);
		Product p3 = new Product("333", 30, 3.99);
		Product p5 = new Product("555", 30, 3.99);
		Product p123 = new Product("123", 10, 1.99);

		theQueue.enqueue(p1);
		theQueue.enqueue(p2);
		theQueue.enqueue(p3);

		System.out.println("\ntheQueue contains\n" + theQueue.toString());

		if (theQueue.isEmpty()) {
			System.out.println("Calling the isEmpty method: theQueue is empty");
		} else {
			System.out.println("Calling the isEmpty method: theQueue is NOT empty");
		}

		/*
		 * Why do we need a try catch block when EmptyQueueException is a checked
		 * exception
		 * 
		 */

		// Step 12: Call front method and display the item
		try {
			Product frontItem = theQueue.front();
			System.out.println("\nThe front-most item: " + frontItem.toString());
		} catch (EmptyQueueException e) {
			System.out.println("When calling front: " + e.getMessage());
		}

		System.out.println("\ntheQueue contains:\n" + theQueue.toString());

		System.out.println("The size of theQueue is " + theQueue.size() + "\n");

		// Call first time the dequeue method.

		try {
			Product dequeuedItem = theQueue.dequeue();
			System.out.println("The dequeued item: " + dequeuedItem.toString());
		} catch (EmptyQueueException e) {
			System.out.println("When calling dequeue: " + e.getMessage());
		}

		System.out.println("\ntheQueue contains:\n" + theQueue.toString());

		// Call second time the second dequeue item.

		try {
			Product dequeuedSItem = theQueue.dequeue();
			System.out.println("The dequeued item: " + dequeuedSItem.toString());
		} catch (EmptyQueueException e)

		{
			System.out.println("When calling dequeue: " + e.getMessage());
		}

		System.out.println("\ntheQueue contains:\n" + theQueue.toString());

		// Call third time the third dequeue item.

		try {
			Product dequeuedTItem = theQueue.dequeue();
			System.out.println("The dequeued item: " + dequeuedTItem.toString());
		} catch (EmptyQueueException e)

		{
			System.out.println("When calling dequeue: " + e.getMessage());
		}

		System.out.println("\ntheQueue contains:\n" + theQueue.toString());

		// Call the fourth time on empty dequeue method.

		try {
			System.out.println(theQueue.dequeue());
		} catch (EmptyQueueException e) {
			System.out.println("On dequeue: LinkedQueue collection is empty");
		}

		// Call the front method on empty queue.

		try {
			System.out.println(theQueue.front());
		} catch (EmptyQueueException e)

		{
			System.out.println("\nWhen calling front: Queue is empty\n");
		}

		System.out.println("The size of theQueue is " + theQueue.size() + "\n");

		// Search for non existent item in a queue.

		System.out.println("The product with id 555 is at position " + theQueue.search(p5) + "");

		// Add the products back to the queue again.
		theQueue.enqueue(p1);
		theQueue.enqueue(p2);
		theQueue.enqueue(p3);

		System.out.println("\ntheQueue contains:\n" + theQueue.toString());

		System.out.println("The product with id 111 is at position " + theQueue.search(p1) + "");
		System.out.println("The product with id 555 is at position " + theQueue.search(p5) + "");
		System.out.println("The product with id 222 is at position " + theQueue.search(p2) + "");
		System.out.println("The product with id 333 is at position " + theQueue.search(p3) + "");

		try {
			Product lastProduct = theQueue.removeLast();
			System.out.println("\nLast product removed: " + lastProduct.toString());
		} catch (EmptyQueueException e) {
			System.out.println("on removeLast: " + e.getMessage());
		}

		System.out.println("\ntheQueue contains:\n" + theQueue.toString());

		theQueue.enqueue(p123);

		System.out.println("Enqueued product with id of 123");
		System.out.println("\ntheQueue contains:\n" + theQueue.toString());

		// Step 34
		try {
			Product lastProduct = theQueue.removeLast();
			System.out.println("\nLast product removed: " + lastProduct.toString());
		} catch (EmptyQueueException e) {
			System.out.println("Last product removed: " + e.getMessage());
		}

		System.out.println("\ntheQueue contains:\n" + theQueue.toString());

		try {
			Product lastProduct = theQueue.removeLast();
			System.out.println("\nLast product removed: " + lastProduct.toString());
		} catch (EmptyQueueException e) {
			System.out.println("Last product removed: " + e.getMessage());
		}

		System.out.println("\ntheQueue contains:\n" + theQueue.toString());

		try {
			Product lastProduct = theQueue.removeLast();
			System.out.println("\nLast product removed: " + lastProduct.toString());
			System.out.println("\ntheQueue contains:\n" + theQueue.toString());
		} catch (EmptyQueueException e) {
			System.out.println("on removeLast: " + e.getMessage());
		}

		try {
			Product lastProduct = theQueue.removeLast();
			System.out.println("\nLast product removed: " + lastProduct.toString());
			System.out.println("\ntheQueue contains:\n" + theQueue.toString());
		} catch (EmptyQueueException e) {
			System.out.println("on removeLast: " + e.getMessage());
		}

		theQueue.enqueue(p1);

		System.out.println("\ntheQueue contains:\n" + theQueue.toString());

	}
}
