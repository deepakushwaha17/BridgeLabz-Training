import java.util.Arrays;

public class RandomArray {

    public static int[] generate4DigitRandomArray(int size) {
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            // Generate random number between 1000 and 9999
            numbers[i] = (int) (Math.random() * 9000) + 1000;
        }
        return numbers;
    }

    public static double[] findAverageMinMax(int[] numbers) {
        if (numbers.length == 0) {
            return new double[]{0, 0, 0};
        }

        int min = numbers[0];
        int max = numbers[0];
        int sum = 0;

        for (int num : numbers) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            sum += num;
        }

        double average = (double) sum / numbers.length;

        return new double[]{average, min, max};
    }

    public static void main(String[] args) {
        int size = 5;

        int[] randomNumbers = generate4DigitRandomArray(size);
        System.out.println("Random 4-digit numbers: " + Arrays.toString(randomNumbers));

        double[] status = findAverageMinMax(randomNumbers);
        System.out.println("Average: " + status[0]);
        System.out.println("Minimum: " + status[1]);
        System.out.println("Maximum: " + status[2]);
    }
}
