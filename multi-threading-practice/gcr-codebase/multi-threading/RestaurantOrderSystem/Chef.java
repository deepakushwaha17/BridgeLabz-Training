package RestaurantOrderSystem;

public class Chef implements Runnable {
	private String chefName;
	private String dishName;
	private double prepTimeSeconds;
	
	public Chef(String chefName, String dishName, double prepTimeSeconds) {
		this.chefName = chefName;
		this.dishName = dishName;
		this.prepTimeSeconds = prepTimeSeconds;
	}
	
	@Override
	public void run() {
		System.out.println(chefName + " started preparing" + dishName);
		
		int[] progress = {25,50,75,100};
		double sleepTime = (prepTimeSeconds + 1000) / progress.length;
		
		for(int p : progress) {
			try {
				Thread.sleep((long) sleepTime);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}		
            System.out.println(chefName + " preparing " + dishName + ": " + p + "% complete");
		}
	}
}