//Write a program to demonstrate NullPointerException. 

public class NullPointerExceptionDemo{
	public static void generateException()
	{
		String text = null;
		System.out.println("Length of text is " + text.length());
	}
	public static void handleException(){
		String text = null;
		try{
			System.out.println("Length of text is " + text.length());
		}
		catch(NullPointerException e){
			System.out.println("Caught NullPointerException : " + e.getMessage());
		}
	}
	public static void main(String[] args){
		try{
			generateException();
		}
		catch(NullPointerException e){
			handleException();
			//System.out.println("NullPointerException occurred : " + e.getMessage());
		}		
	}
}