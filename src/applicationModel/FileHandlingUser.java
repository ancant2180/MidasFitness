package applicationModel;

import java.io.*;

public class FileHandlingUser {
    //Constructor (NEW)
    public FileHandlingUser(){ }

    public void createDefaultUserFile() throws IOException {
        File exFile = new File("userDataFile.csv");
        FileWriter printer = new FileWriter(exFile);

        printer.write("If you are reading this it means you are in your user file. Go away, do stuff in the application.\n");
        printer.write("Name\n");
        printer.write("Sex\n");
        printer.write("Weight\n");
        printer.write("Target Weight\n");
        printer.write("Lifestyle\n");
        printer.write("Is Weightlifting?\n");
        printer.write("ChangePerWeek\n");
        printer.write("0\n");
        printer.write("0\n");
        printer.write("0\n");
        printer.close();
    }

    public void writeUserToCSV(String name, char sex, double weight, double targetWeight, int lifestyle, char weightlifting, int changePerWeek, double height, int age, double cal, double pro, double fats,double carbs,double changeDouble) throws IOException {
        File exFile = new File("userDataFile.csv");
        FileWriter printer = new FileWriter(exFile);
        printer.write("If you are reading this it means you are in your user file. Go away, do stuff in the application.\n");
        printer.write(name+"\n");
        printer.write(sex+"\n");
        printer.write(weight+"\n");
        printer.write(targetWeight+"\n");
        printer.write(lifestyle+"\n");
        printer.write(weightlifting+"\n");
        printer.write(changePerWeek+"\n");
        printer.write((int) Math.round(cal)+"\n");
        printer.write((int) Math.round(pro)+"\n");
        printer.write((int) Math.round(fats)+"\n");
        printer.write((int) Math.round(carbs)+"\n");
        printer.write(height+"\n");
        printer.write(age+"\n");
        printer.write(changeDouble+"\n");
        printer.close();

    }

    public String readName(){
        String name = "";
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "userDataFile.csv"));
            String line = reader.readLine();
            for(int i = 0;i<1;i++){

                name = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print(name);
        return name;
    }

    public char readSex(){
        char sex;
        String line = "";
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "userDataFile.csv"));
            line = reader.readLine();
            for(int i = 0;i<2;i++){

                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        sex = line.charAt(0);
        System.out.print(sex);
        return sex;
    }

    public double readWeight(){
        double weight;
        String line = "";
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "userDataFile.csv"));
            line = reader.readLine();
            for(int i = 0;i<3;i++){

                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        weight = Double.parseDouble(line);
        System.out.print(weight);
        return weight;
    }

    public double readWeightTarget(){
        double weight;
        String line = "";
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "userDataFile.csv"));
            line = reader.readLine();
            for(int i = 0;i<4;i++){

                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        weight = Double.parseDouble(line);
        System.out.print(weight);
        return weight;
    }

    public int readLifestyle(){
        int lifestyle;
        String line = "";
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "userDataFile.csv"));
            line = reader.readLine();
            for(int i = 0;i<5;i++){

                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        lifestyle = Integer.parseInt(line);
        System.out.print(lifestyle);
        return lifestyle;
    }

    public boolean readIsWeightlifting(){
        boolean isWeightLifting = false;
        String line = "";
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "userDataFile.csv"));
            line = reader.readLine();
            for(int i = 0;i<6;i++){

                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(line.equals('Y'))
            isWeightLifting = true;
        if(line.equals('N'))
            isWeightLifting = false;
        System.out.print(isWeightLifting);
        return isWeightLifting;
    }

    public int readChange(){
        int change;
        String line = "";
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "userDataFile.csv"));
            line = reader.readLine();
            for(int i = 0;i<7;i++){

                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        change = Integer.parseInt(line);
        System.out.print(change);
        return change;
    }

    public String readDailyGoalsLine(){
        int cal = readDailyGoalsCal();
        int pro = readDailyGoalsPro();
        int fat = readDailyGoalsFats();
        String goals = "Calories: " + cal + " Protein: " + pro + " Fats: " + fat;
        System.out.println(goals);
        return goals;
    }

    public int readDailyGoalsCal(){
        int calories = 0;
        String line = "";
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "userDataFile.csv"));
            line = reader.readLine();
            for(int i = 0;i<8;i++){

                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        calories = Integer.parseInt(line);
        System.out.print(calories);
        return calories;
    }

    public int readDailyGoalsCarbs(){
        int calories = 0;
        String line = "";
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "userDataFile.csv"));
            line = reader.readLine();
            for(int i = 0;i<11;i++){

                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        calories = Integer.parseInt(line);
        System.out.print(calories);
        return calories;
    }

    public int readDailyGoalsPro(){
        int protein = 0;
        String line = "";
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "userDataFile.csv"));
            line = reader.readLine();
            for(int i = 0;i<9;i++){

                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



        protein = Integer.parseInt(line);
        System.out.print(protein);
        return protein;
    }

    public int readDailyGoalsFats(){
        int fats = 0;
        String line = "";
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "userDataFile.csv"));
            line = reader.readLine();
            for(int i = 0;i<10;i++){

                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        fats = Integer.parseInt(line);
        System.out.print(fats);
        return fats;
    }

    public double readHeight(){
        double height = 0.0;
        String line = "";
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "userDataFile.csv"));
            line = reader.readLine();
            for(int i = 0;i<12;i++){

                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        height = Double.parseDouble(line);
        System.out.print(height);
        return height;
    }

    public int readAge(){
        int age = 0;
        String line = "";
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "userDataFile.csv"));
            line = reader.readLine();
            for(int i = 0;i<13;i++){

                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        age = Integer.parseInt(line);
        System.out.print(age);
        return age;
    }

    public double readChangeDouble(){
        double change = 0;
        String line = "";
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "userDataFile.csv"));
            line = reader.readLine();
            for(int i = 0;i<14;i++){

                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        change = Double.parseDouble(line);
        System.out.print(change);
        return change;
    }

}
