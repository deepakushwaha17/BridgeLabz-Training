package dsaProblems;

import java.util.Scanner;

public class StringConcatenationComparison {
	public static void concatenateString(String string, int n) {
		StringBuffer buffer = new StringBuffer();
		StringBuilder builder = new StringBuilder();
		String str ="";
		
		long startTime , endTime;
		
		// testing String performance
		startTime  = System.nanoTime();
		for(int i = 0 ; i < n ; i++) {
			str=str.concat(string);
		}
		endTime = System.nanoTime();
		System.out.println("String ConcatTime : " +(endTime-startTime)/1000000.0 + "ms");
		
		
		// testing StringBuilder performance
		startTime  = System.nanoTime();
		for(int i = 0 ; i < n ; i++) {
			builder.append(string);
		}
		endTime = System.nanoTime();
		System.out.println("StringBuilder ConcatTime : " +(endTime-startTime)/1000000.0 + "ms");
		
		// testing StringBuffer performance
		startTime  = System.nanoTime();
		for(int i = 0 ; i < n ; i++) {
			buffer.append(string);
		}
		endTime = System.nanoTime();
		System.out.println("StringBuffer ConcatTime : " +(endTime-startTime)/1000000.0 + "ms");
	}

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the operation count : ");
		int n = input.nextInt();
		System.out.print("Enter the text : ");
		String text = input.next(); 
		
		concatenateString(text,n);
		input.close();
	}

}