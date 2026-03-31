package generics.PersonalizedMealPlanGenerator;

public class Keto implements MealPlan{

	@Override
	public void showMealDetails() {
		System.out.println("Keto Meal : ");
		System.out.println(" - Eggs");
		System.out.println(" - Cheese");
		System.out.println(" - Avcado");
		System.out.println(" - Meat");
		System.out.println(" - Milk");
	}
}
