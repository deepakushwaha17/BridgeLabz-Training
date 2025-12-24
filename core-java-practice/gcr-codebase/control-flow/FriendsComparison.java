//Create a program to find the youngest friends among 3 Amar, Akbar, and Anthony based on their ages and the tallest among the friends based on their heights.

import java.util.Scanner;

public class FriendsComparison {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter age of Amar : ");
        int amarAge = input.nextInt();
		System.out.print("Enter age of Akbar : ");
        int akbarAge = input.nextInt();
		System.out.print("Enter age of Anthony : ");
        int anthonyAge = input.nextInt();

        System.out.print("Enter height of Amar : ");
        int amarHeight = input.nextInt();
		System.out.print("Enter height of Akbar : ");
        int akbarHeight = input.nextInt();
		System.out.print("Enter height of Anthony : ");
        int anthonyHeight = input.nextInt();
		
		//Finding youngest friend
		if(amarAge < akbarAge && amarAge < anthonyAge){
		    System.out.println("Youngest Friend is Amar and age is " + amarAge);
		}
		else if(akbarAge < anthonyAge && akbarAge < amarAge){
			System.out.println("Youngest Friend is Akbar and age is " + akbarAge);
		}
		else{
			System.out.println("Youngest Friend is Anthony and age is " + anthonyAge);
		}

		//Finding tallest friend
		if(amarHeight > akbarHeight && amarHeight > anthonyHeight){
		    System.out.println("Tallest Friend is Amar and height is " + amarHeight);
		}
		else if(akbarHeight > anthonyHeight && akbarHeight > amarHeight){
			System.out.println("Tallest Friend is Akbar and height is " + akbarHeight);
		}
		else{
			System.out.println("Tallest Friend is Anthony and height is " + anthonyHeight);
		}
        input.close();
    }
}
