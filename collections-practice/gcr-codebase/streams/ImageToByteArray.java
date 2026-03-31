package streams;

import java.io.*;

public class ImageToByteArray {

    public static void main(String[] args) {

        String sourceImage = "D:\\Eclipse-Java-Worksapce\\collectionPractice\\src\\streams\\OriginalImage.jpg";   // Source image file
        String destinationImage = "D:\\Eclipse-Java-Worksapce\\collectionPractice\\src\\streams\\CopyImage.jpg";         // Destination image file

        FileInputStream fis = null;
        ByteArrayOutputStream baos = null;
        FileOutputStream fos = null;

        try {
            //Read image into byte array
            fis = new FileInputStream(sourceImage);
            baos = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024]; // read 1 KB at a time
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }

            byte[] imageBytes = baos.toByteArray(); // image as byte array
            System.out.println("Image converted to byte array. Size: " + imageBytes.length + " bytes");

            // Write byte array back to new image
            fos = new FileOutputStream(destinationImage);
            ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);

            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            System.out.println("Byte array written back to CopyImage.jpg file.");

        } catch (IOException e) {
            System.out.println("Error processing image: " + e.getMessage());
        }
    }
}
