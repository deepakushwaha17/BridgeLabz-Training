package streams;
import java.io.*;
import java.util.Scanner;

public class StudentDataStream {

    public static void main(String[] args) {

        String fileName = "D:\\Eclipse-Java-Worksapce\\collectionPractice\\src\\streams\\StudentInfo.txt";
        Scanner input = new Scanner(System.in);

        try {
            //Writing student data to binary file
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName,true));

            System.out.print("Enter number of students: ");
            int n = input.nextInt();
            input.nextLine(); // consume newline

            for (int i = 0; i < n; i++) {
                System.out.println("Enter details for student " + (i + 1) + ":");

                System.out.print("Roll Number (int): ");
                int roll = input.nextInt();
                input.nextLine(); // consume newline

                System.out.print("Name: ");
                String name = input.nextLine();

                System.out.print("GPA (double): ");
                double gpa = input.nextDouble();
                input.nextLine(); // consume newline

                // Write data using DataOutputStream
                dos.writeInt(roll);   
                dos.writeUTF(name);    
                dos.writeDouble(gpa);
            }

            dos.close(); // close after writing
            System.out.println("Student data written successfully to StudentInfo file.");

            // Reading student data from binary file
            DataInputStream dis = new DataInputStream(new FileInputStream(fileName));

            System.out.println("\nReading student data from file:");
            try {
                while (true) { // read until EOFException
                    int roll = dis.readInt();
                    String name = dis.readUTF();
                    double gpa = dis.readDouble();

                    System.out.println("Roll: " + roll + ", Name: " + name + ", GPA: " + gpa);
                }
            }catch (EOFException e) {
                // End of file reached
            }
            dis.close(); // close after reading

        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        } 
    }
}