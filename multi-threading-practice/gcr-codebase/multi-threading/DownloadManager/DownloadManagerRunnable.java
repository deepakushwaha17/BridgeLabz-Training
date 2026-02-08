package DownloadManager;

import java.util.Random;

class FileDownloaderRunnable implements Runnable {
	
	private String fileName;
	FileDownloaderRunnable (String fileName){
		this.fileName = fileName;
	}
	
	@Override
	public void run() {
		Random random = new Random();
		for(int i = 0; i <= 100; i+=5) {
			try {
				Thread.sleep(500 + random.nextInt(500));
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("[" + Thread.currentThread().getName() + "] Downloading " + fileName + ": " + i + "%");
		}
	}
}

public class DownloadManagerRunnable {

	public static void main(String[] args) throws InterruptedException{
		Thread t1 = new Thread(new FileDownloaderRunnable("Document.pdf"),"Thread-1");
		Thread t2 = new Thread(new FileDownloaderRunnable("Image.jpg"),"Thread-2");
		Thread t3 = new Thread(new FileDownloaderRunnable("Video.mp4"),"Thread-3");

		t1.start();
		t2.start();
		t3.start();
		
		t1.join();
		t2.join();
		t3.join();
		
		System.out.println("\nAll downloads complete!");
	}

}
