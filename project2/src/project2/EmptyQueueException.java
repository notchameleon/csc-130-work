package project2;

public class EmptyQueueException extends Exception {
	
	public EmptyQueueException() 
	{
		super("The Queue is empty");
	}
	
	
	public EmptyQueueException(String message)
	{
		super(message);
	}

}