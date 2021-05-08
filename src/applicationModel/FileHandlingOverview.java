package applicationModel;

import java.io.*;
import java.util.Calendar;

public class FileHandlingOverview {
    //Constructor (NEW)
    public FileHandlingOverview(){ }

    public void addWorkout(String wkoutName,double minutes) throws IOException {
        boolean needsChangeDate = !dateIsCorrect("dailyActivityW.csv");
        FileWriter printer = new FileWriter("dailyActivityW.csv", dateIsCorrect("dailyActivityW.csv"));
        BufferedWriter bw = new BufferedWriter(printer);

        FileHandlingWorkouts workoutsCSV = new FileHandlingWorkouts();
        System.out.println("Checkpoint 1 addWorkout to Overview...");



        String workout ="";
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "exercises.csv"));
            String line = reader.readLine();
            while (line != null) {
                if(line.contains(wkoutName))
                    workout = line;
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        bw.write("\n"+workoutsCSV.findWorkoutName(wkoutName)+","+((workoutsCSV.findWorkoutCal(wkoutName)*1)+""));


        bw.close();
    }

    public void addFood(String foodName,int servings) throws IOException {
        boolean needsChangeDate = !dateIsCorrect("dailyActivityF.csv");
        FileWriter printer = new FileWriter("dailyActivityF.csv", dateIsCorrect("dailyActivityF.csv"));
        BufferedWriter bw = new BufferedWriter(printer);

        FileHandlingFood foodCSV = new FileHandlingFood();
        System.out.println("Checkpoint 1 addFood to Overview...");

        String foodline ="";
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "food.csv"));
            String line = reader.readLine();
            while (line != null) {
                if(line.contains(foodName))
                    foodline = line;
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Checkpoint 2 addFood to Overview...");
        if(needsChangeDate)
            bw.write(""+Calendar.getInstance().get(Calendar.DAY_OF_YEAR));
        bw.write("\n"+(foodCSV.findFoodName(foodName)));
        bw.write(","+(foodCSV.findFoodCal(foodName)*(servings+0.0)));
        bw.write(","+(foodCSV.findFoodPro(foodName)*(servings+0.0)));
        bw.write(","+(foodCSV.findFoodCarbs(foodName)*(servings+0.0)));
        bw.write(","+(foodCSV.findFoodSug(foodName)*(servings+0.0)));
        bw.write(","+(foodCSV.findFoodFat(foodName)*(servings+0.0)));

        System.out.println("Checkpoint 3 addFood to Overview...");

        bw.close();
    }

    private boolean dateIsCorrect(String fileName) throws IOException {

        int date = Calendar.getInstance().get(Calendar.DAY_OF_YEAR);

        String content = "";
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            content = reader.readLine();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(date==Integer.parseInt(content)){
            return true;
        }else{
            return false;
        }

    }

    //Copy of the userToCSV function
    public String readFoodsFromCSV(){
        String content = "";
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "dailyActivityF.csv"));
            String line = reader.readLine();
            line = reader.readLine();
            while (line != null) {
                content = content+line+"\n";
                //System.out.println(line);
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(content);
        return content;
    }

    public String readWorkoutsFromCSV(){
        String content = "";
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "dailyActivityW.csv"));
            String line = reader.readLine();
            line = reader.readLine();
            while (line != null) {
                content = content+line+"\n";
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(content);
        return content;
    }

    public double calculateCaloriesWorkout(){
        double count = 0.0;

        String content = "";
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "dailyActivityW.csv"));
            String line = reader.readLine();
            line = reader.readLine();
            while (line != null) {
                content = line;
                String[] tokens = content.split(",");
                count =+ Double.parseDouble(tokens[1]);
                //System.out.println(line);
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(count);

        return count;
    }
    //Types based on place in line. Check FileHandlingFood functions with the tokens, then the index of token for the result
    //Never use 0, will result in type mismatch
    //1 for example gives calories.
    public double calculateNutrientFoods(int type){
        double count = 0.0;

        String content = "";
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "dailyActivityF.csv"));
            String line = reader.readLine();
            line = reader.readLine();
            while (line != null) {
                content = line;
                String[] tokens = content.split(",");
                count =+ Double.parseDouble(tokens[type]);
                //System.out.println(line);
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(count);

        return count;
    }

    public double calculateDailyExpenditure(){
        double calNeeds = calculateCaloriesWorkout()-calculateNutrientFoods(1);
        System.out.println(calNeeds);
        return calNeeds;
    }

}
