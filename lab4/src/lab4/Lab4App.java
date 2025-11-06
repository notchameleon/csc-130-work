package lab4;

import stacks.ArrayStack;
import exceptionclasses.EmptyStackException;

public class Lab4App {
	public static void main (String args[]) {
		
		//A stack is when a object is holding a stack of reference classes?
		ArrayStack<Card> theStack = new ArrayStack<Card>(4);
		ArrayStack<Card> anotherStack = new ArrayStack<Card>();
		
		//ITS ALIVE, we are populating the stack? index 0 holds 18
		System.out.println("Testing expandCapcity & toString:");
		theStack.push(new Card(18));
		theStack.push(new Card(3));
		theStack.push(new Card(34));
		theStack.push(new Card(28));

		theStack.push(new Card(43));

		
		System.out.println(theStack.toString());
		
		System.out.println("Item popped: " + theStack.pop() + "\n");
		
		System.out.println("theStack now contains:\n" + theStack.toString());
		
		
		System.out.println("Testing pop on anotherStack:");
		
		try {
			anotherStack.pop();
		} catch (EmptyStackException e) {
			System.out.println(e.getMessage());
		}
		
		
		System.out.println("Item peeked: " + theStack.peek() + "\n");
		
		System.out.println("theStack now contains:\n" + theStack.toString());
		
		System.out.println("Testing peek on anotherStack:");

		
		try {
			anotherStack.peek();
		} catch (EmptyStackException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Size of theStack: " + theStack.size());
		System.out.println("theStack now contains:\n" + theStack.toString());
		
		System.out.println("Size of anotherStack: " + anotherStack.size());
		System.out.println("anotherStack now contains:\n" + anotherStack.toString());
		
		Card twoHearts = new Card (28);
		Card threeClubs = new Card (3);
		Card fiveDiamonds = new Card(18);
		Card tenDiamonds = new Card (23);
		
		
		int pos1 = theStack.search(twoHearts);
		int pos2 = theStack.search(threeClubs);
		int pos3 = theStack.search(fiveDiamonds);
		int pos4 = theStack.search(tenDiamonds);
		int pos5 = anotherStack.search(tenDiamonds);
		
		System.out.println("Searching for 2 of Hearts. It was found at position " + pos1);
		System.out.println("Searching for 3 of Clubs. It was found at position " + pos2);
		System.out.println("Searching for 5 of Diamonds. It was found at position " + pos3);
		System.out.println("Searching for 10 of Diamonds. It was found at position " + pos4);
		System.out.println("Searching for 10 of Diamonds in anotherStack. It was found at position " + pos5);
		
		anotherStack.push(new Card(51));
		anotherStack.push(new Card(7));
		anotherStack.push(new Card(21));
		anotherStack.push(new Card(37));
		anotherStack.push(new Card(29));
		anotherStack.push(new Card(43));
		anotherStack.push(new Card(16));
		anotherStack.push(new Card(1));
		
		
		System.out.println("\n"+ anotherStack.toString());

		//Create a third stack and create two other stack variables to compare which one is larger and small

		ArrayStack<Card> thirdStack = new ArrayStack<Card>();
		
		ArrayStack<Card> var1 = new ArrayStack<Card>();
		ArrayStack<Card> var2 = new ArrayStack<Card>();
		
		// Determinne which stack is larger
		ArrayStack<Card> copy1 = new ArrayStack<Card>();
        
		while (!theStack.isEmpty()) {
		    copy1.push(theStack.pop());
		}
		while (!copy1.isEmpty()) {
		    Card card = copy1.pop();
		    var1.push(card);
		    theStack.push(card); 
		}
		
		
		while (!anotherStack.isEmpty()) {
		    copy1.push(anotherStack.pop());
		}
		while (!copy1.isEmpty()) {
		    Card card = copy1.pop();
		    var2.push(card);
		    anotherStack.push(card); 
		}
		
		
		ArrayStack<Card> largerStack, smallerStack;
		if (var1.size() >= var2.size()) {
		    largerStack = var1;
		    smallerStack = var2;
		} else {
		    largerStack = var2;
		    smallerStack = var1;
		}
		
		
		int largerSize = largerStack.size();
		int smallerSize = smallerStack.size();
		Card[] largerArray = new Card[largerSize];
		Card[] smallerArray = new Card[smallerSize];
        
		
		for (int i = 0; i < largerSize; i++) {
		    largerArray[i] = largerStack.pop();
		}
		
		for (int i = 0; i < smallerSize; i++) {
		    smallerArray[i] = smallerStack.pop();
		}
		
		for (int i = 0; i < largerSize; i++) {
		    thirdStack.push(largerArray[i]);
		    
		    if (i < smallerSize) {
		        thirdStack.push(smallerArray[i]);
		    }
		}
        
        
		System.out.println("Third stack with alternating cards:");
		System.out.println(thirdStack.toString());

		int arraySize = thirdStack.size();
		Card[] cardArray = new Card[arraySize];

		for (int i = 0; i < arraySize; i++) {
		    cardArray[i] = thirdStack.pop();
		}

		System.out.println("The following cards were removed and stored in the Card array:");
		for (Card card : cardArray) {
		    System.out.println(card);
		}
    }
}