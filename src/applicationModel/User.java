package applicationModel;
import java.io.IOException;
import java.util.Scanner;



public class User {

	private String name;
	private char sex;
	private int age;
	private double weight;				//kg
	private double weightTarget;		//kg
	private double height;				//cm
	private double activityLevel; 		

	private double BMI;			//Body Mass Index
	private double BMR;			//Basal metabolic rate
	private double TDEE;		//Total daily energy expenditure

	private int lifestyle;
	private char weightlifting;
	private int weightChangePerWeekInt;
	private double weightChangePerWeekDouble;

	private FileHandlingUser temp = new FileHandlingUser();
	FileHandlingUser accessCSV = new FileHandlingUser();

	public User() {
		
	}

	private double calculateBMR()
	{
		if(sex == 'M')
			this.BMR = ((13.7 * this.weight) + (5 * this.height) - (6.8 * this.age) );
		if(sex == 'F')
			this.BMR = ((13.7 * this.weight) + (5 * this.height) - (6.8 * this.age) );
		return this.BMR;
	}

	private double calculateTDEE()
	{
		this.TDEE = getActivityLevel() * getBMR();
		return this.TDEE;
	}
	
	public void setChange(Double val){
		weightChangePerWeekDouble = val;
	}

	public void setWeightChangePerWeek(int val){
		weightChangePerWeekInt = val;
	}
	public void setWeightChangePerWeekDouble(double val){
		weightChangePerWeekDouble = val;
	}

	public void setLifestyle(int val){
		lifestyle = val;
	}
	public void setWeightlifting(char val){
		weightlifting = val;
	}
	
	public void setToCSV() throws IOException {
		accessCSV.writeUserToCSV(name, sex, weight, weightTarget, lifestyle, weightlifting, weightChangePerWeekInt, height, age, getCalorieGoal(), getProteinGoal(), getFatGoal(), getCarbGoal(), getChange());
	}
	public double getActivityLevel() {
		return this.activityLevel;
	}
	
	private double calculateBMI()
	{
		double meters, metersSquared;
		meters = this.height/100;
		metersSquared = meters * meters;
		this.BMI = (this.weight/metersSquared);
		return this.BMI;
	}


	public void setAge(String age) {
		this.age = Integer.parseInt(age);
	}

	public void setHeight(String val) {
		this.height = Double.parseDouble(val);

	}

	public void setActivityLevel() {
		int index = temp.readLifestyle();
		double[] activityList = {1.2, 1.375, 1.55, 1.725, 1.9};
		this.activityLevel = activityList[index];
	}

	public void setName(String val) {
		this.name = val;
	}

	public void setSex(char sex) {
		this.sex = sex;

	}

	public void setWeight(String val) {
		this.weight = Double.parseDouble(val);

	}

	public void setWeightTarget(String val) {
		this.weightTarget = Double.parseDouble(val);

	}

	public double getHeight(){
		return height;
	}
	
	public double getWeight() {
		return weight;
	}

	public double getWeightTarget() {
		return weightTarget;

	}

	public double getBMI() {
		calculateBMI();
		return this.BMI;
	}

	public double getBMR() {
		calculateBMR();
		return this.BMR;
	}

	public double getTDEE() {
		calculateTDEE();
		return this.TDEE;
	}

	public char getSex() {
		return sex;
	}
	
	public double getChange(){

		return weightChangePerWeekDouble;
	}

	
    public double getCalorieGoal() {  //Get the Calorie goal based on user data
        double goal = getTDEE(); 	//Basic TDEE, if none of the following criteria is met (User wants to maintain), this will be passed

        if(getWeightTarget() > getWeight()) { // If they want to gain weight
            if (getChange() == 0.25){
                goal += 275;
            }
            else if(getChange() == 0.5) {
                goal += 550;
            }
            else if(getChange() == 0.75) {
                goal += 825;
            }
            else if(getChange() == 1.0) {
                goal += 1100;
            }
        }

        if(getWeightTarget() < getWeight()) { // If they want to lose weight
            if (getChange() == 0.25){
                goal -= 275;
            }
            else if(getChange() == 0.5) {
                goal -= 550;
            }
            else if(getChange() == 0.75) {
                goal -= 825;
            }
            else if(getChange() == 1.0) {
                goal -= 1100;
            }
            if(goal < 1300) { //Cannot fall below 1200 Daily calories (Mealplans have tolerance of +- 100), so this is a fail safe
                goal = 1300;
            }
        }

        return goal;

    }

	public double getProteinGoal() {
		return ((this.getCalorieGoal()) * 0.2)/4;  //Rate is 20% of Goal Calories / 4 to convert to grams
	}

	public double getCarbGoal() {
		return ((this.getCalorieGoal()) * 0.5)/4;  //Rate is 50% of Goal Calories / 4 to convert to grams
	}

	public double getFatGoal() {
		return ((this.getCalorieGoal()) * 0.3)/9;  //Rate is 30% of Goal Calories / 9 to convert to grams
	}

	public String getName() {
		return this.name;
	}
	
	public int getWeightChangePerWeek(){
		return weightChangePerWeekInt;
	}
	public int getWeightlifting(){
		return weightlifting;
	}
	public int getLifestyle(){
		return lifestyle;
	}

}

