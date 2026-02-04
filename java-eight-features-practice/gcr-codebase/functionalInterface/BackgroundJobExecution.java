package functionalInterface;

public class BackgroundJobExecution {

	public static void main(String[] args) {
		Runnable task = () ->{
			System.out.println("Background task running...");
		};
		new Thread(task).start();
	}
}