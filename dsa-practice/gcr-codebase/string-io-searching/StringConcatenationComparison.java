package dsaProblems;

import java.util.Scanner;

public class StringConcatenationComparison {
	public static void concatenateString(String string) {
		StringBuffer buffer = new StringBuffer();
		StringBuilder builder = new StringBuilder();
		
		long startTime , endTime;
		
		// testing StringBuilder performance
		startTime  = System.nanoTime();
		for(int i = 0 ; i < 1000000 ; i++) {
			builder.append(string);
		}
		endTime = System.nanoTime();
		System.out.println("StringBuilder ConcatTime : " +(endTime-startTime) + "ns");
		
		// testing StringBuffer performance
		startTime  = System.nanoTime();
		for(int i = 0 ; i < 1000000 ; i++) {
			buffer.append(string);
		}
		endTime = System.nanoTime();
		System.out.println("StringBuffer ConcatTime : " +(endTime-startTime) + "ns");
	}

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the text : ");
		String text = input.next(); 
		
		concatenateString(text);
		input.close();
	}

}
