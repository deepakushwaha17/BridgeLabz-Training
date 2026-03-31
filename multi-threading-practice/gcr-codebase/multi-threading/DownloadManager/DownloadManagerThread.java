package DownloadManager;

import java.util.Random;

class FileDownloaderThread extends Thread {
	
	private String fileName;
	FileDownloaderThread (String fileName){
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

public class DownloadManagerThread {

	public static void main(String[] args) throws InterruptedException{
		
		FileDownloaderThread t1 = new FileDownloaderThread("Document.pdf");
		FileDownloaderThread t2 = new FileDownloaderThread("Image.jpg");
		FileDownloaderThread t3 = new FileDownloaderThread("Video.mp4");
		
		t1.setName("Thread-1");
		t2.setName("Thread-2");
		t3.setName("Thread-3");
		
		t1.start();
		t2.start();
		t3.start();
		
		t1.join();
		t2.join();
		t3.join();
		
		System.out.println("\nAll downloads complete!");
	}

}