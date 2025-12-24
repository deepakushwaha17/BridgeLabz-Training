//Write a program to input marks and 3 subjects physics, chemistry and maths. Compute the percentage and then calculate the grade as per the following guidelines 

import java.util.Scanner;

public class CalculateGradePercentage{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the physics mark : ");
		int physicsMark = input.nextInt();
		System.out.print("Enter the chemistry mark : ");
		int chemistryMark = input.nextInt();
		System.out.print("Enter the maths mark : ");
		int mathsMark = input.nextInt();
		
		int totalMark = physicsMark + chemistryMark + mathsMark;
		double percent = (double)totalMark*100 / 300;
		if(percent >= 80.0){
			System.out.print("Grade A , Remark : Level 4, above agency-normalized standards , Percentage is " + percent);
		}
		else if(percent >= 70.0){
			System.out.print("Grade B , Remark : Level 3, at agency-normalized standards , Percentage is " + percent);
		}
		else if(percent >= 60.0){
			System.out.print("Grade C , Remark : Level 2, below, but approaching agency-normalized standards , Percentage is " + percent);
		}
		else if(percent >= 50.0){
			System.out.print("Grade D , Remark : Level 1, well below agency-normalized standards , Percentage is " + percent);
		}
		else if(percent >= 40.0){
			System.out.print("Grade E , Remark : Level 1-, too below agency-normalized standards , Percentage is " + percent);
		}
		else{
			System.out.print("Grade R , Remark : Remedial standards , Percentage is " + percent);
		}
		input.close();
		
	}
}
		
		