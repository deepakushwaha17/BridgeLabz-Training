package streams;
import java.io.*;

public class FileStreamComparison {

	private static final int BUFFER_SIZE = 4096;
	
	public static void main(String[] args) {
		String sourceFile = "D:\\Eclipse-Java-Worksapce\\collectionPractice\\src\\streams\\LargeFile.txt";
		String unbufferedDestination = "D:\\Eclipse-Java-Worksapce\\collectionPractice\\src\\streams\\UnbufferedDestinationFile.txt";
		String bufferedDestination = "D:\\Eclipse-Java-Worksapce\\collectionPractice\\src\\streams\\BufferedDestinationFile.txt";
		
		copyUsingUnbufferedStreams(sourceFile, unbufferedDestination);
        copyUsingBufferedStreams(sourceFile, bufferedDestination);

	}

	// Unbuffered File Copy
	public static void copyUsingUnbufferedStreams(String source, String destination) {
		long startTime = System.nanoTime();

		try (FileInputStream fis = new FileInputStream(source);
				FileOutputStream fos = new FileOutputStream(destination)) {

			byte[] buffer = new byte[BUFFER_SIZE];
			int bytesRead;

	        while ((bytesRead = fis.read(buffer)) != -1) {
	        	fos.write(buffer, 0, bytesRead);
	        }

		} catch (IOException e) {
			System.out.println("Error in unbuffered copy: " + e.getMessage());
		}

		long endTime = System.nanoTime();
		System.out.println("Unbuffered Stream Time: " +
	                (endTime - startTime) / 1000000 + " ms");
	}
	
	// Buffered File Copy
    public static void copyUsingBufferedStreams(String source, String destination) {
        long startTime = System.nanoTime();

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination))) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;

            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.out.println("Error in buffered copy: " + e.getMessage());
        }

        long endTime = System.nanoTime();
        System.out.println("Buffered Stream Time: " +
                (endTime - startTime) / 1000000 + " ms");
    }

	    
}
