package functionalInterface;
import java.io.*;

class User implements Serializable {
 private String name;
 private int age;

 public User(String name, int age) {
     this.name = name;
     this.age = age;
 }

 @Override
 public String toString() {
     return name + " (" + age + ")";
 }
}

public class DataSerialization {
 public static void main(String[] args) throws Exception {
     User user = new User("Deepa", 22);

     FileOutputStream file = new FileOutputStream("user_backup.ser");
     ObjectOutputStream out = new ObjectOutputStream(file);
     out.writeObject(user);
     out.close();
     file.close();

     System.out.println("User object backed up successfully!");
 }
}
