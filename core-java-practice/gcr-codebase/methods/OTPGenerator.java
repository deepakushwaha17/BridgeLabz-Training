/*Write a program to generate a six-digit OTP number using Math.random() method. Validate the numbers are unique by generating the OTP number 10 times and ensuring all the 10 OTPs are not the same
 */

import java.util.Arrays;

public class OTPGenerator {

    // generate 6-digit OTP
    public static int generateOTP() {
        return (int)(Math.random() * 900000) + 100000; // 100000 to 999999
    }

    // check if all elements in array are unique
    public static boolean areUnique(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] otps = new int[10];

        // Generate 10 OTPs
        for (int i = 0; i < otps.length; i++) {
            otps[i] = generateOTP();
        }

        System.out.println("Generated OTPs:");
        System.out.println(Arrays.toString(otps));

        // Validate uniqueness
        boolean unique = areUnique(otps);
        System.out.println("All OTPs Unique: " + unique);
    }
}
