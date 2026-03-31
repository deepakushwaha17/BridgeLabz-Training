package streams;

import java.io.*;

public class PipedStream {

    public static void main(String[] args) {

        try {
            // Create piped streams
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos); // connect to output stream

            // Writer thread
            Thread writerThread = new Thread(() -> {
                try {
                    String message = "Hello from Writer Thread!\nThis is a piped stream problem.";
                    pos.write(message.getBytes()); // write bytes
                    pos.close(); // close stream after writing
                } catch (IOException e) {
                    System.out.println("Writer error: " + e.getMessage());
                }
            });

            // Reader thread
            Thread readerThread = new Thread(() -> {
                try {
                    int data;
                    while ((data = pis.read()) != -1) {
                        System.out.print((char) data); // read byte by byte
                    }
                    pis.close(); // close after reading
                } catch (IOException e) {
                    System.out.println("Reader error: " + e.getMessage());
                }
            });

            // Start threads
            writerThread.start();
            readerThread.start();

            // Wait for threads to finish
            writerThread.join();
            readerThread.join();

            System.out.println("\nCommunication via piped streams completed.");

        } catch (IOException | InterruptedException e) {
            System.out.println("Error setting up piped streams: " + e.getMessage());
        }
    }
}
