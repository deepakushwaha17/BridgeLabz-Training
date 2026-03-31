package generics.PersonalizedMealPlanGenerator;

public class MealPlanGenerator {

	public static <T extends MealPlan> void generatePlan(T meal) {
		System.out.println("\nGenerating Personalized Meal Plan....");
		meal.showMealDetails();
	}
}
