import java.util.Scanner;

public class LineComparisonProblem {

    //UC 1 : calculate the line length
    public static double getLength(double x1 , double y1 , double x2 , double y2){
        double length = Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
        return length;
    }

    //UC 2 : check equality of two lines
    public static void checkLinesEquality(double length1 , double length2){
        Double line1Length = length1;
        Double line2Length = length2;
        if(line1Length.equals(line2Length)){
            System.out.println("\nLength of both lines are equal.");
        } else{
            System.out.println("\nLength of both lines are not equal.");
        }
    }

    //UC 3 : compare two lines
    public static void compareLines(double length1 , double length2){
        Double line1Length = length1;
        Double line2Length = length2;
        int result = line1Length.compareTo(line2Length); 

        if(result > 0){
            System.out.println("\nLine1 is greater than Line2");
        } else if(result < 0){
            System.out.println("\nLine1 is lesser than Line2");
        }else{
            System.out.println("\nBoth lines are of equal length");
        }
    }

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Line Comparison Computation Program !");

        System.out.println("\nEnter the Line1 co-ordinates : ");
        System.out.print("Enter x1 and y1 : ");
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        System.out.print("Enter x2 and y2 : ");
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();

        System.out.println("Enter the Line2 co-ordinates : ");
        System.out.print("Enter x3 and y3 : ");
        double x3 = input.nextDouble();
        double y3 = input.nextDouble();
        System.out.print("Enter x4 and y4 : ");
        double x4 = input.nextDouble();
        double y4 = input.nextDouble();

        double length1 = getLength(x1, y1, x2, y2); // calculating the length of line1
        double length2 = getLength(x3, y3, x4, y4); // calculating the length of line2
        System.out.println("\nLength of Line1 with co-ordinates (" + x1 + " , " + y1  + ") and (" + x2  + " , " + y2 + ") is " + length1);
        System.out.println("Length of Line2 with co-ordinates (" + x3 + " , " + y3  + ") and (" + x4  + " , " + y4 + ") is " + length2);

        checkLinesEquality(length1, length2); // checking the lines equality
        compareLines(length1, length2);  // comparing two lines 

        input.close();

    }   
}
