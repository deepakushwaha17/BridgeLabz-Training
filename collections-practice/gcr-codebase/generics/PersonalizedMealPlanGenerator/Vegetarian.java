package generics.PersonalizedMealPlanGenerator;

public class Vegetarian implements MealPlan{

	@Override
	public void showMealDetails() {
		System.out.println("Vegetarian Meal : ");
		System.out.println(" - Dal");
		System.out.println(" - Roti");
		System.out.println(" - Vegetables");
		System.out.println(" - Salad");
		System.out.println(" - Fruits");
	}
}
