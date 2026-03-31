package generics.PersonalizedMealPlanGenerator;

public class Meal<T extends MealPlan> {
	
	T mealPlan;
	
	public Meal(T mealPlan) {
		this.mealPlan = mealPlan;
	}
}
