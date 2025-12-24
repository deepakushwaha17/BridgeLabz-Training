//Sam’s mark in Maths is 94, Physics is 95 and Chemistry is 96 out of 100. Find the average percent mark in PCM

public class CalculatePercentage{
    public static void main(String[] args){
	    int mathMark = 94 , physicsMark = 95 , chemistryMark = 96;
		int totalMark = mathMark + physicsMark + chemistryMark;
		double percentage = totalMark / 3;
		System.out.println("Sam's average mark in PCM is " +percentage);
	}
}