//Problem no .1108 : Defanging an IP Address
package leetcode;

import java.util.Scanner;

public class DefangIPAddress {

    // Method to defang IP
    public static String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        for (char ch : address.toCharArray()) {
            if (ch == '.') {
                sb.append("[.]"); // replace '.' with '[.]'
            } else {
                sb.append(ch);   // keep other characters
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an IP address: ");
        String ip = sc.nextLine();

        String defangedIP = defangIPaddr(ip);
        System.out.println("Defanged IP address: " + defangedIP);
    }
}

