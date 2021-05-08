package applicationController;
import java.net.URL;
import java.util.ResourceBundle;

import applicationModel.FileHandlingFood;
import applicationModel.FileHandlingUser;
import applicationModel.FileHandlingWorkouts;
import applicationModel.User;
import applicationModel.buildProperties;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;
import applicationModel.*;

public class Controller implements Initializable {
    FileHandlingUser userCSV = new FileHandlingUser();
    FileHandlingWorkouts fuc = new FileHandlingWorkouts();
    User userData = new User();
    buildProperties userSettings = new buildProperties();
    FileHandlingFood userToCSVFoodFile = new FileHandlingFood();

    //String weight = Double.toString(userData.getWeight());
    @FXML
    private Button toMyProfile,backToSample,toAddMeal,toAddWorkout, saveMyProfile, addFoodToAct, addWorkoutButton,btnOpenNewWindow;
    @FXML
    private TextField currentWeight,targetWeight,height,nameInput,servings,minutesP,createFoodName,createFoodCal,createFoodPro,createFoodCarb,createFoodSug,createFoodFat;
    @FXML
    private ComboBox <String> userSex, lifestyleBox, weightliftingBox, weightChangePerWeek;
    @FXML
    private Label a2, foodsInOverview,workoutLabel,welcomeName,labelWeight,labelTargetWeight,nutGoals,myProfileGoals,recommendations;
    @FXML
    private ListView foodList, workoutList;
    FileHandlingFood foodsToChoose = new FileHandlingFood();

    ResourceBundle resources = ResourceBundle.getBundle("applicationView.heh");

    public Controller() throws IOException {
    }

    @FXML
    private void handleButtonAction (ActionEvent event) throws Exception {
        Stage stage = null;
        Parent root = null;

            if(event.getSource()==toAddWorkout){
                stage = (Stage) toAddWorkout.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("/applicationView/addWorkout.fxml"));
        }
            if(event.getSource()==toMyProfile){
                stage = (Stage) toMyProfile.getScene().getWindow();
                ResourceBundle.clearCache();
                ResourceBundle resources = ResourceBundle.getBundle("applicationView.heh");
                root = FXMLLoader.load(getClass().getResource("/applicationView/myProfile.fxml"),resources);
               

        } if(event.getSource()==toAddMeal){
            stage = (Stage) toAddMeal.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/applicationView/addMeal.fxml"));



        } if(event.getSource()==backToSample){
            stage = (Stage) backToSample.getScene().getWindow();
            ResourceBundle.clearCache();
            ResourceBundle resources = ResourceBundle.getBundle("applicationView.heh2");
            root = FXMLLoader.load(getClass().getResource("/applicationView/sample.fxml"),resources);
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void handleCreateMealWindow(ActionEvent event){

        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/applicationView/createFood.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Food Creation");
            stage.setScene(new Scene(root, 600, 450));
            stage.show();
            // Hide this current window (if this is what you want)
            //((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }



    //
    // Weight per week gained/loss goal
    // Add lifestyle button to my profile. ComboBox? Make it integer based.
    // Weightlifting? System.out.println(a2.getText());
    //

    @FXML
    private void handleSaveProfile (ActionEvent event) throws Exception {
        if(event.getSource()==saveMyProfile){

            try{
                userData.setWeight(currentWeight.getText());
            }catch (NullPointerException e){
                userData.setWeight(userCSV.readWeight()+"");
            }
            try{
                userData.setWeightTarget(targetWeight.getText());
            }catch (NullPointerException e){
                userData.setWeightTarget(userCSV.readWeightTarget()+"");
            }
                try {
                    if (userSex.getValue().equals("Male") )
                        userData.setSex('M');
                    if (userSex.getValue().equals("Female") )
                        userData.setSex('F');
                } catch(NullPointerException e){
                    if(userCSV.readSex() == 'M')
                        userData.setSex('M');
                    if(userCSV.readSex()=='F')
                        userData.setSex('F');
                }
            if(height.equals("")){userData.setHeight("0");}else{userData.setHeight(height.getText());}
            if(nameInput.equals(" ")){userData.setName(" ");}else{userData.setName(nameInput.getText());}


            try {
                String str = lifestyleBox.getValue();
                switch (str) {
                    case "Sedentary":
                        userData.setLifestyle(0);
                        break;
                    case "Lightly active":
                        userData.setLifestyle(1);
                        break;
                    case "Moderately active":
                        userData.setLifestyle(2);
                        break;
                    case "Very active":
                        userData.setLifestyle(3);
                        break;
                    case "Super active":
                        userData.setLifestyle(4);
                        break;
                    default:
                        System.out.println("Error: Lifestyle set from save to user not working. Please investigate.");
                }
            } catch(NullPointerException e){
                userData.setLifestyle(userCSV.readLifestyle());
            }
            try {
                String str2 = weightliftingBox.getValue();
                switch (str2) {
                    case "Yes":
                        userData.setWeightlifting('Y');
                        System.out.println("Yes weightlifte");
                        break;
                    case "No":
                        userData.setWeightlifting('N');
                        System.out.println("No weightlifte");
                        break;
                    default:
                        System.out.println("Error: Weightlifting from save to user not working. Please investigate.");
                }
            } catch (NullPointerException e){
                if(userCSV.readIsWeightlifting()){
                userData.setWeightlifting('N');}else{
                    userData.setWeightlifting('Y');
                }
            }
            try {
                String str3 = weightChangePerWeek.getValue();
                switch (str3) {
                    case ".25 kg":
                        userData.setWeightChangePerWeek(0);
                        userData.setChange(.25);
                        break;
                    case ".5 kg":
                        userData.setWeightChangePerWeek(1);
                        userData.setChange(.50);
                        break;
                    case ".75 kg":
                        userData.setWeightChangePerWeek(2);
                        userData.setChange(.75);
                        break;
                    case "1 kg":
                        userData.setWeightChangePerWeek(3);
                        userData.setChange(1.0);
                        break;
                    default:
                        System.out.println("Error: Weight change set from save to user not working. Please investigate.");
                }
            } catch (NullPointerException e){
                userData.setWeightChangePerWeek(userCSV.readChange());
                userData.setWeightChangePerWeekDouble(userCSV.readChangeDouble());
            }
            userData.setToCSV();
            System.out.print("\nUser Name: "+userData.getName()+"\nUser Sex: "+userData.getSex()+"\nUser Height: "+userData.getHeight());
            System.out.print(" cm.\nCurrent weight: "+userData.getWeight()+" kgs. User target weight: "+userData.getWeightTarget()+" kgs.");
            userSettings.writeToheh(userData.getName(),Double.toString(userData.getHeight()),Double.toString(userData.getWeight()),Double.toString(userData.getWeightTarget()), Character.toString(userData.getSex()),userCSV.readLifestyle(),userCSV.readAge(),userCSV.readIsWeightlifting(),userCSV.readChange(),userCSV.readDailyGoalsLine());
            userSettings.writeToHeh2(userCSV.readName(),userCSV.readWeight()+"",userCSV.readWeightTarget()+"",userCSV.readDailyGoalsLine());
        }
    }

    //Add refresh to the overiew with this! -> System.out.println(servings.getText() + " servings of "+foodList.getSelectionModel().getSelectedItem());
    @FXML
    private void refreshSampleAction (ActionEvent event) throws Exception {
        FileHandlingOverview overview = new FileHandlingOverview();
        //foodsToChoose.createDefault();
        foodsInOverview.setText("Foods\n"+overview.readFoodsFromCSV());
        //fuc.createDefaultExercises();
        workoutLabel.setText(overview.readWorkoutsFromCSV());
        welcomeName.setText("Welcome "+userCSV.readName());
        labelWeight.setText("Your weight is "+userCSV.readWeight());
        labelTargetWeight.setText("Your desired weight is "+userCSV.readWeightTarget());
        nutGoals.setText("Calories: "+(userCSV.readDailyGoalsCal()+(overview.calculateDailyExpenditure()))+" Protein: "+(userCSV.readDailyGoalsPro()-overview.calculateNutrientFoods(2)+"")+" Carbs: "+(userCSV.readDailyGoalsCarbs()-overview.calculateNutrientFoods(3)+" Fat: "+(userCSV.readDailyGoalsFats()-overview.calculateNutrientFoods(5)+"")));
        overview.calculateDailyExpenditure();

    }

    @FXML
    private void refreshMyProfileAction (ActionEvent event) throws Exception {
        nameInput.setText(userCSV.readName());
        height.setText(Double.toString(userCSV.readHeight()));
        currentWeight.setText(Double.toString(userCSV.readWeight()));
        targetWeight.setText(Double.toString(userCSV.readWeightTarget()));
        if((userCSV.readSex())=='M'){
            userSex.getSelectionModel().select("Male");}
        if(userCSV.readSex()=='F'){
            userSex.getSelectionModel().select("Female");}
        if(userCSV.readIsWeightlifting()){
            weightliftingBox.getSelectionModel().select(1);}else{
            weightliftingBox.getSelectionModel().select(0);}
        lifestyleBox.getSelectionModel().select(userCSV.readLifestyle());
        weightChangePerWeek.getSelectionModel().select(userCSV.readChange());
        //System.out.print("\n\n"+userCSV.readSex());
        myProfileGoals.setText(userCSV.readDailyGoalsLine());
    }



    @FXML
    private void handleButtonFood(ActionEvent event) throws Exception{
        FileHandlingOverview fileOver = new FileHandlingOverview();
        //System.out.println(servings.getText() + " servings of "+foodList.getSelectionModel().getSelectedItem());

        String name = (String) foodList.getSelectionModel().getSelectedItem();
        System.out.println(name);
        try{
            System.out.println(servings.getText() + " servings of "+foodList.getSelectionModel().getSelectedItem());
            fileOver.addFood(name,Integer.parseInt(servings.getText()));
        }catch (NullPointerException e){
            System.out.println("Error with food addition. Please review your command.");
        }

    }
        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    @FXML
    private void handleButtonWorkouts(ActionEvent event) throws Exception{
        FileHandlingOverview fileOver = new FileHandlingOverview();
        //System.out.println(minutesP.getText()+" minutes of "+workoutList.getSelectionModel().getSelectedItem());

        String name = (String) workoutList.getSelectionModel().getSelectedItem();
        System.out.println(name);
        try{
            System.out.println(minutesP.getText() + " minutes of "+workoutList.getSelectionModel().getSelectedItem());
            fileOver.addWorkout(name,Double.parseDouble(minutesP.getText()));
        }catch (NullPointerException e){
            System.out.println("Error with workout addition. Please review your command.");
        }

    }

    @FXML
    private void refreshWorkout(ActionEvent event) throws Exception{
        //System.out.println(minutesP.getText()+" minutes of "+workoutList.getSelectionModel().getSelectedItem());
        //fuc.createDefaultExercises();
        ListView<String> list = new ListView<String>();
        ObservableList<String> data = FXCollections.observableArrayList(fuc.assembleArray());

        workoutList.setItems(data);

    }

    @FXML
    private void handleMealRefresh(ActionEvent event) throws Exception{
        ListView<String> list = new ListView<String>();
        ObservableList<String> data = FXCollections.observableArrayList(userToCSVFoodFile.assembleArray());

        foodList.setItems(data);

    }



    @FXML
    private void handleFoodCreationEvent(ActionEvent event) throws Exception{
        String name;
        double cal,pro,carb,sug,fat;

        try {
            name = createFoodName.getText();
        } catch (NullPointerException e){
            name = "Default Food";
        }

        try {
            cal = Double.parseDouble(createFoodCal.getText());
        } catch (NullPointerException e){
            cal = 0;
        }

        try {
            carb = Double.parseDouble(createFoodCarb.getText());
        } catch (NullPointerException e){
            carb = 0;
        }

        try {
            pro = Double.parseDouble(createFoodPro.getText());
        } catch (NullPointerException e){
            pro = 0;
        }

        try {
            fat = Double.parseDouble(createFoodFat.getText());
        } catch (NullPointerException e){
            fat = 0;
        }

        try {
            sug = Double.parseDouble(createFoodSug.getText());
        } catch (NullPointerException e){
            sug = 0;
        }

        userToCSVFoodFile.writeToCSV(name,cal,pro,carb,fat,sug);
        ((Node)(event.getSource())).getScene().getWindow().hide();

    }



    @FXML
    private void doTheHelp(){


    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }



}
