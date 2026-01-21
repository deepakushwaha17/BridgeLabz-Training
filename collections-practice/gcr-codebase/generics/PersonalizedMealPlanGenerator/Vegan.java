package generics.PersonalizedMealPlanGenerator;

public class Vegan implements MealPlan{

	@Override
	public void showMealDetails() {
		System.out.println("Vegan Meal : ");
		System.out.println(" - Quinoa");
		System.out.println(" - Beans");
		System.out.println(" - Nuts");
		System.out.println(" - Tofu");
		System.out.println(" - Fruits");
	}
}
