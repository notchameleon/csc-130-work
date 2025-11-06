package project1csc130;

public class EmptyStackException extends RuntimeException {
		public EmptyStackException() {
			super("ArrayStack collection is empty.\n");
			}
		
		public EmptyStackException(String messenge)
		{
			super(messenge);
		}

}
