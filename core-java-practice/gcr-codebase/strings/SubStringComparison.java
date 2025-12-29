/*Write a program to create a substring from a String using the charAt() method. Also, use the String built-in method substring()
 to find the substring of the text. Finally Compare the the two strings and display the results*/
 
import java.util.Scanner;
public class SubStringComparison {
    public static String getSubString(String text , int beginIndex , int endIndex){

		String subString = "";
        for(int i = beginIndex; i < endIndex; i++){
            char ch = text.charAt(i);
			subString += String.valueOf(ch);
        }
        return subString;

    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the text : ");
        String text = input.next();
        System.out.print("Enter the begin index : ");
        int beginIndex = input.nextInt();
		System.out.print("Enter the end index : ");
        int endIndex = input.nextInt();

        String resultOfCharAt = getSubString(text, beginIndex, endIndex);
        String resultOfSubString = text.substring(beginIndex,endIndex);
		
		System.out.println("Result using charAt() method: " + resultOfCharAt);
        System.out.println("Result using substring() method: " + resultOfSubString);

        if(resultOfCharAt.equals(resultOfSubString)){
            System.out.println("Both methods gives same result.");
        }else{
            System.out.println("Both methods gives different result.");
        }
    }   
}
