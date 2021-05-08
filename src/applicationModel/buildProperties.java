package applicationModel;
import java.io.*;



public class buildProperties {

    public buildProperties(){}

    public void writeToheh(String name, String height,String weight, String targetWeight, String sex,int lifestyle, int age,boolean isWeightLifting,int change, String goals) throws IOException {

        File overWrite = new File("applicationView.heh.properties");
        FileWriter printer = new FileWriter("applicationView.heh.properties");

        String changeS = "";
        String isWeightLiftingS = null;
        if(isWeightLifting){
            isWeightLiftingS = "Yes";}
        else{
            isWeightLiftingS = "No";}
        String ageS = age+"";
        String lifestyleS = "";

        switch(change)
        {
            case 0:
                changeS=".25 kg";
                break;
            case 1:
                changeS=".50 kg";
                break;
            case 2:
                changeS=".75 kg";
                break;
            case 3:
                changeS="1 kg";
                break;
            default:
                System.out.println("Error: Lifestyle set from save to user not working. Please investigate.");
        }


        switch(lifestyle)
        {
            case 0:
                lifestyleS="Sedentary";
                break;
            case 1:
                lifestyleS="Lightly Active";
                break;
            case 2:
                lifestyleS="Moderately Active";
                break;
            case 3:
                lifestyleS="Very Active";
                break;
            case 4:
                lifestyleS="Super Active";
                break;
            default:
                System.out.println("Error: Lifestyle set from save to user not working. Please investigate.");
        }


        BufferedWriter bw = new BufferedWriter(printer);
        bw.write("a2 = Change Profile\n");
        bw.write("name = "+name);
        bw.write("\nheight = "+height);
        bw.write("\nweight = "+weight);
        bw.write("\ntWeight = "+targetWeight);
        bw.write("\nlifestyle = "+lifestyleS);
        if(sex.equals("M"))
            bw.write("\nsex = Male");
        if(sex.equals("F"))
            bw.write("\nsex = Female");
        bw.write("\ndoYouLiftBro = "+isWeightLiftingS);
        bw.write("\nchange = "+changeS);
        bw.write("\ndailyGoals = "+goals);
        bw.newLine();
        bw.close();


    }

    public void writeToHeh2(String name,String weight,String weightT,String goals) throws IOException {
        File overWrite = new File("applicationView.heh2.properties");
        FileWriter printer = new FileWriter("applicationView.heh2.properties");

        BufferedWriter bw = new BufferedWriter(printer);
        bw.write("name = Welcome "+name);
        bw.write("\nweight = Your current weight: "+weight);
        bw.write("\nweightT = Target weight: "+weightT);
        bw.write("\ndailyGoals = "+goals);
        bw.newLine();
        bw.close();

    }



}


