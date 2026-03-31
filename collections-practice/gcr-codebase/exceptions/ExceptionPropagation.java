package exceptions;

public class ExceptionPropagation {

	public static int method1() {
		int result = 10/0;
		return result;
	}
	
	public static int method2() {
		return method1();
	}
	public static void main(String[] args) {
		try {
			int result = method2();
			System.out.println("Result: "+result);
		}
		catch(ArithmeticException e) {
			System.out.println("Handled exception in main");
		}

	}

}
