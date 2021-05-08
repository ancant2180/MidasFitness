package applicationModel;



import java.io.*;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class FileHandlingWorkouts {

    //Constructor (NEW)
    public FileHandlingWorkouts(){ }

    //Creates the default file contents (OLD)
    public void createDefaultExercises() throws IOException {
        File exFile = new File("exercises.csv");
        FileWriter printer = new FileWriter(exFile);

        printer.write("Name,Calories_Burned,Sets,Reps,isStrength,Weight,isTimed,Time(sec)");
        printer.write("\n");
        printer.write("Running(10_Min),154,0,0,F,0,T,600");
        printer.write("\n");
        printer.write("Walking(10_Min),43,0,0,F,0,T,600");
        printer.write("\n");
        printer.write("High-Knee(1_Min),8,0,0,F,0,T,60");
        printer.write("\n");
        printer.write("Butt_Kicks(1_Min),8,0,0,F,0,T,60");
        printer.write("\n");
        printer.write("Sprints(20m),100,1,10,F,0,F,0");
        printer.write("\n");
        printer.write("Bench_Press,30,4,10,T,115,F,0");
        printer.write("\n");
        printer.write("Bicep_Curl,26,4,10,T,20,F,0");
        printer.write("\n");
        printer.write("Pushup,7,6,10,T,0,F,0");
        printer.write("\n");
        printer.write("Situp,6,6,10,T,0,F,0");
        printer.write("\n");
        printer.write("Tricep_Extension,25,4,15,T,50,F,0");
        printer.write("\n");
        printer.close();
    }



    //Uses the filewriter and bufferedwriter to write to the .csv file without erasing the content already there. (NEW)


    //Reads the whole content. (NEW)
    public String readFromCSV(){
        String content = "";
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "exercises.csv"));
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
        System.out.println(content);
        return content;
    }

    //Reads the content of a line, searching for a string within a line. Meaning, we can search for names as well as nutrient content. (NEW)
    public String findExerciseItem(String val){
        String temp = "";
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "exercises.csv"));
            String line = reader.readLine();
            while (line != null) {
                if(line.contains(val))
                    temp = temp + line;
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return temp;

    }

    public String[] assembleArray(){
        int size = 0;
        BufferedReader reader1;
        try {
            reader1 = new BufferedReader(new FileReader(
                    "exercises.csv"));
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
                    "exercises.csv"));
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

    public String findWorkoutName(String val){
        String food ="Not Found";
        int i = val.indexOf(',');
        String word = val.substring(0, i);


        return word;

    }

    public double findWorkoutCal(String val){
        String food ="";
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "exercises.csv"));
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

}

