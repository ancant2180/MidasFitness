package applicationModel;

public class Food {
	
	private double carbs;
	private double protein;
	private double fat;
	private double calories;
	private double sugar;
	private String foodName;
	

	
	public Food() {

	}
		
	
	public void setCalories(double calories) 
	{
		this.calories = calories;
	}	
	public void setCarbs(double carbs) {
		this.carbs = carbs;
	}
	
	public void setFat(double fat) {
		this.fat = fat;
	}
	
	public void setSugar(double sugar) {
		this.sugar = sugar;
	}
	
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	
	public void setProtein(double protein) {
		this.protein = protein;
	}
	
	//getters
	public String getFoodName()
	{
		return this.foodName;
	}
	public double getCalories() {
		return this.calories;
	}
	
	public double getProtein() {
		return this.protein;
	}
	
	public double getCarbs() {
		return this.carbs;
	}
	
	public double getSugar() {
		return this.sugar;
	}
	
	public double getFat() {
		return this.fat;
	}

}
