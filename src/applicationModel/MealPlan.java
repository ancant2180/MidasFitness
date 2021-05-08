package applicationModel;

import java.util.ArrayList;

public class MealPlan {
	
	private ArrayList<Food> meals = new ArrayList<Food>();
	
	
	public MealPlan() {
		
	}
	
	public void addFood(Food food) {
		meals.add(food);
	}
	
	public void removeFood(String food) {
		for(int i = 0; i < meals.size(); i++) {
			if(food == meals.get(i).getFoodName()) {
				meals.remove(i);
				break;
			}
		}
	}
	
	public double getTotalCalories() {
		double calorieCount = 0;
		Food temp = new Food();
		if(meals.size() != 0)
		{
			for(int i = 0; i < meals.size(); i++) {
				temp = meals.get(i);
				calorieCount += temp.getCalories();
			}
			return calorieCount;
		}
		return 0;
	}
	
	public double getTotalProtein() {
		double proteinCount = 0;
		Food temp = new Food();
		if(meals.size() != 0)
		{
			for(int i = 0; i < meals.size(); i++) {
				temp = meals.get(i);
				proteinCount += temp.getProtein();
			}
			return proteinCount;
		}
		return 0;
	}
	
	public String[] getFoodNames() {
		String[] names = new String[meals.size()];
		for(int i = 0; i < meals.size(); i++) {
			names[i] = meals.get(i).getFoodName();
		}
		
		
		return names;
		
	}
	

	
}
