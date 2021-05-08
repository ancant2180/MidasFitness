package applicationModel;
/**
 * Exercise is a java class that identifies the integral parts to an exercise.  Every Exercise has a name, the amount of sets, and reps.
 * There are also variables that determine if the exercise is a strength exercise or if it is timed.  Additionally, the strength weight
 * and time in seconds can also be identified.  This class was made with the intention of quickly pulling information for certain exercises,
 * as characterized by the multiple getter and setter functions.
 *
 * @author Aaron Nicholas Cantu dth885
 * @author Jasmyn Charles vhh036
 * @author Bryce Hinkley mzl963
 * UTSA CS 3443 - Final Project
 * Spring 2021
 *
 */
public class Exercise {
	private double calBurnPerRepSecond;	//The amount of calories that are burned in the exercise
	private String exerciseName; 		//The name of the exercise
	private int set; 					//The amount of sets in the exercise
	private int rep;					//The amount of reps in the exercise

	private boolean isStrength;			//Boolean value to determine if the exercise is a strength exercise
	private double strengthWeight;		//The weight used in the strength workout, 0 is body weight or non-applicable

	private boolean isTimed;			//Boolean value to determine if the exercise is a timed exercise
	private int timeSeconds;			//The time in seconds


	//Constructor
	public Exercise() {
	}
	
	/**
	 * Getter
	 * @return
	 */
	public double getCals() {
		return this.calBurnPerRepSecond;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getName() {
		return this.exerciseName;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getSet() {
		return this.set;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getRep() {
		return this.rep;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean findifStrength() {
		return this.isStrength;
	}
	
	/**
	 * 
	 * @return
	 */
	public double getStrengthWeight() {
		return this.strengthWeight;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean findifTimed() {
		return this.isTimed;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getSeconds() {
		return this.timeSeconds;
	}

}
