package generics.PersonalizedMealPlanGenerator;
import java.util.Scanner;

public class PersonalizedMealPlan {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("\n====== Personalized Meal Plan Generator ======");
		System.out.println("----Meal Categories----");
		System.out.println("1. Vegetarian");
		System.out.println("2. Vegan");
		System.out.println("3. Keto");
		System.out.println("4. High-Protein");

		System.out.print("Enter category to get personalized meal: ");
		int choice = input.nextInt();
		
		switch(choice) {
			case 1:
				MealPlanGenerator.generatePlan(new Vegetarian());
				break;
			case 2:
				MealPlanGenerator.generatePlan(new Vegan());
				break;
			case 3:
				MealPlanGenerator.generatePlan(new Keto());
				break;
			case 4:
				MealPlanGenerator.generatePlan(new HighProtein());
				break;
			default:
				System.out.println("Invalid choice!");
		}
		input.close();
	}

}
