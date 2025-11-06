package lab5;
import stacks.LinkedStack;
import exceptionclasses.EmptyStackException;

/*
 * 
 * Title: Lab 5 – Stack Operations
 * Authors: Ibrahim and Steffano
 * ID: N00982959, N00963924
 *
 * Description:
 * Demonstrates stack operations using Card objects, including push, pop, peek,
 * search, remove, and reverse, with exception handling for empty stacks.
 * 
 */


public class Lab5App {
	
	public static void main (String args[] ) {
		
	
	LinkedStack<Card> theStack = new LinkedStack<Card>();
	LinkedStack<Card> anotherStack = new LinkedStack<Card>();
	
	
	theStack.push(new Card(18));
	theStack.push(new Card(3));
	theStack.push(new Card(34));
	theStack.push(new Card(28));
	theStack.push(new Card(9));
	theStack.push(new Card(36));
	
	
	System.out.println("theStack now contains:\n" + theStack.toString() );
	
	System.out.println("The topmost item: " + theStack.peek() );
	

	try {
		anotherStack.peek();
	
	} catch (EmptyStackException messenge) {
		System.out.println(messenge.getMessage() + "\n");
	}
	

	
	System.out.println("The size of theStack:" + theStack.size());
	System.out.println("The size of theStack:" + anotherStack.size());
	
	System.out.println("theStack now contains:\n" + theStack.toString());
	
	System.out.println("anotherStack now contains:\n");
	
	System.out.print("Searching for the 10 of hearts. It was found at position: ");
	System.out.println(theStack.search(new Card(36)));
	System.out.print("Searching for the 2 of hearts. It was found at position: ");
	System.out.println(theStack.search(new Card(28)));
	System.out.print("Searching for the 5 of Diamonds. It was found at position: ");
	System.out.println(theStack.search(new Card(18)));
	System.out.print("Searching for the Ace of Diamonds. It was found at position: ");
	System.out.println(theStack.search(new Card(14)));
	System.out.print("Searching for the Ace of Diamonds in anotherStack. It was found at position: ");
	System.out.println(anotherStack.search(new Card(14)));

	// Removing Specific Cards (all 2s)
	System.out.println("\nAfter Removing all the 2s, theStack now contains: ");
	LinkedStack<Card> tempStack = new LinkedStack<>();
	Card target = new Card(28);

	// Move cards to tempStack while skipping target
	while (!theStack.isEmpty()) {
			Card top = theStack.pop();
			if (!top.equals(target)) {
					tempStack.push(top);
			}
		}

			// Restore order to theStack
	while (!tempStack.isEmpty()) {
			theStack.push(tempStack.pop());
			if (tempStack.isEmpty()) {
				break;
			}
		}

			System.out.println(theStack.toString());

			// Reverse the Stack
	while (!theStack.isEmpty()) {
			Card top = theStack.pop();
			tempStack.push(top);
			if (theStack.isEmpty()) {
				break;
			}
		}

			System.out.println("After reversing theStack it now contains: ");
			theStack = tempStack;
			System.out.println(theStack.toString());
		}

	}
