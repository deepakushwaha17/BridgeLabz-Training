package generics.PersonalizedMealPlanGenerator;

public class HighProtein implements MealPlan{

	@Override
	public void showMealDetails() {
		System.out.println("High-Protein Meal : ");
		System.out.println(" - Chicken");
		System.out.println(" - Eggs");
		System.out.println(" - Lentils");
		System.out.println(" - Meat");
		System.out.println(" - Paneer");
	}
}
