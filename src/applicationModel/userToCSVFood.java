package applicationModel;
import java.io.IOException;
import java.util.Scanner;  // Import the Scanner class


public class userToCSVFood {

    private String name;
    private double calories;
    private double protein;
    private double carbs;
    private double fats;



    /**
     * Constructor, initializes a FileHandling2 object upon object creation
     * @throws IOException
     */
    public userToCSVFood() throws IOException {
        FileHandlingFood foodToFile = new FileHandlingFood();

    }

    /**
     * Prompts user input within the console to add to the .csv file
     * @param foodToFile 
     * @throws IOException
     */
    public void promptUserInput(FileHandlingFood foodToFile) throws IOException {
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter food name: ");
        String foodName = obj.nextLine();  // Read user input
        System.out.println("\nCalories: ");
        double calories = Double.parseDouble(obj.nextLine());  // Read user input
        System.out.println("\nProtein: ");
        double protein = Double.parseDouble(obj.nextLine());
        System.out.println("\nCarbs: ");
        double carbs = Double.parseDouble(obj.nextLine());
        System.out.println("\nSugar: ");
        double sugar = Double.parseDouble(obj.nextLine());
        System.out.println("\nFats: ");
        double fats = Double.parseDouble(obj.nextLine());

        foodToFile.writeToCSV(foodName,calories,protein,carbs,sugar,fats);

    }


}