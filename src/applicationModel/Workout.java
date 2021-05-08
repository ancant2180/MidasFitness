package applicationModel;
import java.util.ArrayList;
/**
 * Workout is a java class that contains an ArrayList of Exercises items and gives properties about the cumulative
 * macronutrients.
 *
 * @author Aaron Nicholas Cantu dth885
 * @author Jasmyn Charles vhh036
 * @author Bryce Hinkley mzl963
 * UTSA CS 3443 - Final Project
 * Spring 2021
 *
 */
public class Workout {

	private ArrayList<Exercise> exercises = new ArrayList<Exercise>();

	public Workout() {

	}

	/**
	 * Takes an exercise from Exercise class and adds to arrayList
	 * 
	 * @param exercise Exercise from Exercise class
	 */
	public void addExercise(Exercise exercise) {
		exercises.add(exercise);
	}

	/**
	 * Searches arrayList for matching exercise name and removes it
	 * 
	 * @param exercise String value representing exercise name
	 */
	public void removeExercise(String exercise) {
		for(int i = 0; i < exercises.size(); i++) {
			if(exercise == exercises.get(i).getName()) {
				exercises.remove(i);
				break;
			}
		}
	}

	/**
	 * Pushes exercise names from an arrayList into a String array
	 * 
	 * @return names a list of exercise names 
	 */
	public String[] getExerciseNames() {
		String[] names = new String[exercises.size()];
		for(int i = 0; i < exercises.size(); i++) {
			names[i] = exercises.get(i).getName();
		}
		return names;
	}

	/**
	 * Checks if a workout is biased towards strength exercises by iterating through arrayList
	 * 
	 * @return boolean
	 */
	public boolean determineifStrengthBiased() {
		int yes = 0;
		int no = 0;

		for(int i = 0; i < exercises.size(); i++) {
			if(exercises.get(i).findifStrength()) {
				yes++;
			}
			else {
				no++;
			}
		}
		if(yes > no) {
			return true;
		}
		return false;

	}

	/**
	 * Calculates and returns total calories burned in a workout
	 * 
	 * @return calorieCount The total calories burned summed together
	 */
	public double getTotalCalories() {
		double calorieCount = 0;
		Exercise temp = new Exercise();
		if(exercises.size() != 0)
		{
			for(int i = 0; i < exercises.size(); i++) {
				temp = exercises.get(i);
				calorieCount += temp.getCals();
			}
			return calorieCount;
		}
		return 0;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public int getNumExs() {
		return this.exercises.size();
	}

}
