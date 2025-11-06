package customQueue;

public class CustomLinkedQueue<E> {
	private static class Node<E> {
		E data; 
		Node<E> next;
		
		Node(E data) {
			this.data = data;
			this.next = null;
		}
	}
	
	//Queue class 
	
	private Node<E> head;
	private Node<E> tail;
	private int size;
	
	public CustomLinkedQueue() 
	{
		head = null;
		tail = null;
		size = 0;
	}
	
	public void enqueue(E element) 
	{
		Node<E> newNode = new Node<E>(element);
		
		if (isEmpty())
		{
			head = newNode;
		} else {
			tail.next = newNode;
		}
		tail = newNode;
		size++;
	}
	
	public E dequeue() 
	{
		if (isEmpty())
		{
			throw new IllegalStateException("Queue is empty");
		}
		
		
		E element = head.data;
		
		head = head.next;
		
		if (head == null) 
		{
			tail = null;
		}
		size--;
		return element;
	}
	
	
	
	
	public E peek ()
	{
		if (isEmpty())
		{
			throw new IllegalStateException("Queue is empty");
		}
		return head.data;
	}
	
	public boolean isEmpty() 
	{
		return size == 0;
	}
	
	
		
	}
	
	
	
	
	
