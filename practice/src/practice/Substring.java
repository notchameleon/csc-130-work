package practice;
import java.util.Arrays;
import java.util.Scanner;
import java.util.*;


public class Substring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scnr = new Scanner(System.in);
		
		System.out.println("Enter a string");
		
		String s = scnr.nextLine();
		
		int n = s.length();
		
		int[] array = new int[n];
		
		for (int i = 0; i < n; i++)
		{
			array[i] = s.charAt(i) - '0';
		}
		
		//Left boundaries index of nearest element > current on left
		
		int[] left = new int[n];
		Arrays.fill(left, -1);
		
		
		Deque<Integer> stack = new ArrayDeque<>();
		
		
		for (int i = 0; i < n; i++)
		{
			while (!stack.isEmpty() && array[stack.peek()] <= array[i])
			{
				stack.pop();
			}
			
			if (!stack.isEmpty())
			{
				left[i] = stack.peek();
			}
			
			stack.push(i);
			
		}
		
		
		// Find Right boundaries: index of nearest element >= current on right
		
		int[] right = new int[n];
		
		Arrays.fill(right, n);
		stack.clear();
		
		
		
		for (int i = n - 1; i >= 0; i--)
		{
			
			while (!stack.isEmpty() && array[stack.peek()] < array[i])
			{
				stack.pop();
			}
			
			if (!stack.isEmpty())
			{
				right[i] = stack.peek();
			}
		
			stack.push(i);
			
			
		}
		
		//Calculate total sum of max values
		
		
		long totalSum = 0;
		
		for (int i = 0; i < n; i++) 
		{
			long leftCount = i - left[i];
			long rightCount = right[i] - i;
			
			totalSum += (long) array[i] * leftCount * rightCount;
		}
		
		//Calulate average 	
		
		long totalSubstrings = (long) n * (n + 1) / 2;
		
		
		outputFraction(totalSum, totalSubstrings);
		
		
		scnr.close();

	}
	
	
	public static void outputFraction(long numerator, long denominator)
	{
		
		
		if ( numerator == 0 )
		{
			System.out.println(0);
			return;
		}
		
		
		long whole = numerator / denominator;
		
		long remainder = numerator % denominator;
		
		
		if ( remainder == 0 ) {
			System.out.println(whole);
		} else {
			long gcd = gcd ( remainder , denominator);
			
			remainder /= gcd;
			denominator /= gcd;
			
			if ( whole == 0 )
			{
				System.out.println(remainder + "/" + denominator);
			} else {
				System.out.println(whole + " " + remainder + "/" + denominator);
			}
			
		}
	}
		
		private static long gcd(long a , long b) 
		{
			while (b != 0)
			{
				long temp = b;
				
				b = a % b;
				a = temp;
			}
			return a;
		
	}

}
