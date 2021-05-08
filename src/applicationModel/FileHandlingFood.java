package applicationModel;
import java.io.*;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
/**
*
*
* @author Aaron Nicholas Cantu dth885
* @author Jasmyn Charles vhh036
* @author Bryce Hinkley mzl963
* UTSA CS 3443 - Final Project
* Spring 2021
*
*/

public class FileHandlingFood {

    //Constructor
    public FileHandlingFood(){ }

    //Creates the default file contents (OLD)
    public void createDefault() throws IOException {
        File foodFile = new File("food.csv");
        FileWriter printer = new FileWriter(foodFile);

        printer.write("Name,Calories,Protein,Carbs,Sugar,Fat");
        printer.write("\n");
        printer.write("Egg,72,6.3,0.4,0,4.8");
        printer.write("\n");
        printer.write("Bacon,80,5,0,2,7");
        printer.write("\n");
        printer.write("Bread,120,4,22,3,1.5");
        printer.write("\n");
        printer.write("Butter(1Tbs),50,0,0,0,6");
        printer.write("\n");
        printer.write("HamSteak,120,13,2,2,6");
        printer.write("\n");
        printer.write("Porkchop,130,23,0,0,4.5");
        printer.write("\n");
        printer.write("Pizza,285,12,36,3.8,10");
        printer.write("\n");
        printer.write("Broccoli(chopped),31,2.6,6,1.5,0.3");
        printer.write("\n");
        printer.write("Potato,110,3,26,1,0.2");
        printer.write("\n");
        printer.write("SweetPotato,112,2,26.2,5.4,0.1");
        printer.write("\n");
        printer.write("Milk,130,8,12,12,5");
        printer.write("\n");
        printer.write("SoyMilk(Vanilla),100,6,9,7,3.5");
        printer.write("\n");
        printer.close();

    }


    //Uses the filewriter and bufferedwriter to write to the .csv file without erasing the content already there. (NEW)
    public void writeToCSV(String name,double calories,double protein, double carbs,double fat, double sugar) throws IOException {

        FileWriter printer = new FileWriter("food.csv",true);
        BufferedWriter bw = new BufferedWriter(printer);
        bw.write(name+","+calories+","+protein+","+carbs+","+sugar+","+fat);
        bw.newLine();
        bw.close();


    }

    //Reads the whole content. (NEW)
    /**
     * 
     * 
     * @return
     */
    public String readFromCSV(){
        String content = "";
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "food.csv"));
            String line = reader.readLine();
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
        System.out.println(content);
        return content;
    }

    public String readLineFromCSV(int linePlace){
        String content = "";
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "food.csv"));
            String line = reader.readLine();
            for(int i = 0;i>linePlace;i++){
                line = reader.readLine();
            }
            content=line;
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(content);
        return content;
    }

    //System.out.println(line);
    // read next line



    //Reads the content of a line, searching for a string within a line. Meaning, we can search for names as well as nutrient content. (NEW)
    public String findFoodItem(String val){
        String food ="";
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "food.csv"));
            String line = reader.readLine();
            while (line != null) {
                if(line.contains(val))
                    food = line;
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return food;

    }

    public String findFoodName(String val){
        String food ="Not Found";
        int i = val.indexOf(',');
        String word = val.substring(0, i);


        return word;

    }

    public double findFoodCal(String val){
        String food ="";
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "food.csv"));
            String line = reader.readLine();
            while (line != null) {
                if(line.contains(val))
                    food = line;
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] tokens = food.split(",");
        double cal = Double.parseDouble(tokens[1]);

        return cal;

    }

    public double findFoodPro(String val){
        String food ="";
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "food.csv"));
            String line = reader.readLine();
            while (line != null) {
                if(line.contains(val))
                    food = line;
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] tokens = food.split(",");
        double pro = Double.parseDouble(tokens[2]);

        return pro;

    }

    public double findFoodCarbs(String val){
        String food ="";
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "food.csv"));
            String line = reader.readLine();
            while (line != null) {
                if(line.contains(val))
                    food = line;
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] tokens = food.split(",");
        double carbs = Double.parseDouble(tokens[3]);

        return carbs;

    }

    public double findFoodSug(String val){
        String food ="";
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "food.csv"));
            String line = reader.readLine();
            while (line != null) {
                if(line.contains(val))
                    food = line;
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] tokens = food.split(",");
        double sug = Double.parseDouble(tokens[4]);

        return sug;

    }

    public double findFoodFat(String val){
        String food ="";
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "food.csv"));
            String line = reader.readLine();
            while (line != null) {
                if(line.contains(val))
                    food = line;
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] tokens = food.split(",");
        double fat = Double.parseDouble(tokens[5]);

        return fat;

    }

    public String[] assembleArray(){
        int size = 0;
        BufferedReader reader1;
        try {
            reader1 = new BufferedReader(new FileReader(
                    "food.csv"));
            String line = reader1.readLine();
            while (line != null) {

                size++;
                line = reader1.readLine();
            }
            reader1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        String[] foodArray = new String[size];
        int i = 0;
        BufferedReader reader2;
        try {
            reader2 = new BufferedReader(new FileReader(
                    "food.csv"));
            String line = reader2.readLine();
            while (line != null) {
                foodArray[i] = line;
                i++;
                line = reader2.readLine();
            }
            reader2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return foodArray;
    }

}

