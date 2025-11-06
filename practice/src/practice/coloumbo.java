package practice;

import java.util.*;
import java.util.Scanner;


public class coloumbo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter is weight in milligrams");

		int w = scan.nextInt();
		
		System.out.println("Enter is coin stacks");

		int s = scan.nextInt();
		
		int numcoins;
		
		
		int numCoins = s * (s + 1)/2;
		
		int expectedTungsten = numCoins * 29260;
		
		int difference = w - expectedTungsten;
		
		int expectedGold = difference / 110;
		
		System.out.println("This is " + numCoins);
		
		
		
		
	}

}
