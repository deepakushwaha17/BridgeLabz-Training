package dsaProblems;
import java.io.*;

public class FileReadingComparison {

    public static void readWithFileReader(String filePath) throws IOException {
        FileReader fr = new FileReader(filePath);
        int c;
        long start = System.nanoTime();
        while((c = fr.read()) != -1) {
            // just reading
        }
        long end = System.nanoTime();
        fr.close();
        System.out.println("FileReader Time: " + (end-start)/1000000.0 + " ms");
    }

    public static void readWithInputStreamReader(String filePath) throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath));
        int c;
        long start = System.nanoTime();
        while((c = isr.read()) != -1) {
            // just reading
        }
        long end = System.nanoTime();
        isr.close();
        System.out.println("InputStreamReader Time: " + (end-start)/1000000.0 + " ms");
    }

    public static void main(String[] args) {
        String filePath = "D:\\Eclipse-Java-Worksapce\\dsaPractice\\src\\dsaProblems\\LargeFile.txt"; 
        try {
            readWithFileReader(filePath);
            readWithInputStreamReader(filePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
