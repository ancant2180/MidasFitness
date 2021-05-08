MidasFitness - To Build a Better Fitness App
There are many fitness apps availible at the moment that allow you to keep track of your training goals. However, there are not many that keep proper accountability, or direct people to healthy habits, the hardest to change being diet. Therefore, we believe that by suggesting a diet plan alongside required physical activity, our application will be easier to stick to, resulting in an increase in met goals.

MidasFitness is a JavaFX application using the Eclipse IDE. It is a fitness app that gathers user information, such as hight, weight, and activity level, and creates macronutrient and caloric goals for users to follow and meet their weight-loss or weight-gain goals. The application also provides meal plan and workout plan suggestions based on user information. These recommendations are intended to give users a guide to follow to make retention higher and easier to manage.

How to run the application
To run MidasFitness, you will need to import the files into your eclipse-workspace folder

Download the ZIP file, this will contain the Application and eclipse's hidden files
Locate your eclipse-workspace folder. You can typically find Under C:Users -> USERNAME - eclipse-workspace
Open the ZIP file and keep accessing subsequent folders until you reach a folder simply titled, MIDAS. Copy the MIDAS folder into your eclipse-workspace folder.
Boot up eclipse.
In eclipse, select File -> Import -> General -> Existing Projects into Workspace
Under select root directory, click browse, and select the MIDAS folder, now in your eclipse-workspace.
Click Finish
You should now see MIDAS in eclipse's Package explorer. Open MIDAS -> src -> application -> Main
Ensure you have JavaFX installed on eclipse
Click Run
Notes about Functionality
The application uses CSV files (included) to save and read information. This is helpful as the program will remember all user information given, meaning you will not have to re-input every time you open the program. The program also uses the computer's calandar instance to get the date. This is used to identify if a new day has begun, and if so, your daily goals will be reset so you can start the new day. You can add foods, create new foods, and add workouts. You do not have the ability to create new workouts, however all application funcitonality is availible. The only exception to this is the meal plan suggestions, which currently does not work as it was broken during an optimization attempt.