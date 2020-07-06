package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ExerciseAndPlanPage extends BasePage{
    String exerciseName;
    String workoutPlanName;

    //////////***************PageObject Variables********************************

    By exrciseAndPlanOption = By.cssSelector("#main-menu > ul > li:nth-child(3) > a");
    By newWorkOutPlanButton = By.cssSelector("body > div.container > div.pull-right.hidden-xs.margin-vertical-10 > a");
    By workoutPlanNameField = By.id("new_workout_plan_name");
    By workoutPlanDesc = By.id("workout_plan_description");
    By lb = By.name("weight[0][]");
    By reps = By.name("reps[0][]");
    By saveButton = By.cssSelector("body > div.container > div:nth-child(4) > div > form:nth-child(2) > " +
            "div.form-actions > button");
    By selectExerciseName = By.name("exercise_name[]");
    By successBanner = By.cssSelector("body > div.container > div.alert-container > div");
    By repsValue = By.cssSelector("body > div.container > div:nth-child(4) > div > form:nth-child(2) > div.workout-data" +
            " > div:nth-child(2) > div:nth-child(3) > span");
    By totalWeight = By.cssSelector("body > div.container > div:nth-child(4) > div > form:nth-child(2) > div.workout-" +
            "data > div:nth-child(2) > div:nth-child(4) > span");
    By exerciseTab = By.cssSelector("body > div.container > ul > li:nth-child(2) > a");
    By exerciseNameField = By.id("exname");
    By muscleGroupDropDown = By.id("muscle_group_id");
    By moreButton = By.cssSelector("body > div.container > div:nth-child(4) > div > div > div.col-md-5 > div > div.panel-" +
            "body > form > div:nth-child(1) > div.col-md-8.col-sm-7 > div:nth-child(3) > a");
    By exrcisePlanDesc = By.cssSelector("body > div.container > div:nth-child(4) > div > div > div.col-md-5 > div" +
            " > div.panel-body > form > div:nth-child(1) > div.col-md-8.col-sm-7 > div.exercise-detailed > " +
            "div:nth-child(1) > textarea");
    By steps = By.name("steps");
    By tips = By.name("tips");
    By warning = By.name("warnings");
    By videoUrl = By.name("video_url");
    By addExercise = By.cssSelector("body > div.container > div:nth-child(4) > div > div > div.col-md-5 > div " +
            "> div.panel-body > form > div:nth-child(2) > div > div > button");
    By workoutTab = By.cssSelector("body > div.container > ul > li:nth-child(3) > a");
    By workoutTable = By.className("table-striped");
    By exerciseTable = By.className("table-bordered");

    //***********************Methods********************************************


    //***************Workout Plan*******************************
    @Step("Click on new workout plan button")
    public void clickNewWorkOutPlanButton() {
        driver.findElement(newWorkOutPlanButton).click();
    }

    @Step("Enter the name of workout plan")
    public void enterWorkoutName(String workoutInput) {
        driver.findElement(workoutPlanNameField).sendKeys(workoutInput);
    }

    @Step("Enter the description of workout plan")
    public void enterWorkoutDesc(String workoutDescInput) {
        driver.findElement(workoutPlanDesc).sendKeys(workoutDescInput);
    }

    @Step("Enter the name of exercise")
    public void fillExerciseName(String exrciseInput) {
        driver.findElement(selectExerciseName).sendKeys(exrciseInput);
    }

    @Step("Enter amount of lb's in the field")
    public void enterLb(String lbInput) {
        driver.findElement(lb).sendKeys(lbInput);
    }

    @Step("Enter number of reps")
    public void enterReps(String repsInput) {
        driver.findElement(reps).sendKeys(repsInput);
    }

    @Step("Click on save button")
    public void clickSaveButton() {
        driver.findElement(saveButton).click();
    }

    //********************New Exercise*****************************

    @Step("Enter text in exercise field")
    public void enterTextInExerciseField(String inputExercise) {
        driver.findElement(exerciseNameField).sendKeys(inputExercise);
    }

    @Step("Select value from muscle group dropdown")
    public void selectValueFromMuscleGroupDropdown(String selectValue) {
        Select drpMuscleGroup = new Select(driver.findElement(muscleGroupDropDown));
        drpMuscleGroup.selectByValue(selectValue);
    }

    @Step("Click on more button to view other fields")
    public void clickOnMoreButton() {
        driver.findElement(moreButton).click();
    }

    @Step("Enter exercise description in the field")
    public void enterTextInExercisePlanDesc(String inputExerciseDesc) {
        driver.findElement(exrcisePlanDesc).sendKeys(inputExerciseDesc);
    }

    @Step("Enter number of steps")
    public void enterTextInStepsField(String inputSteps) {
        driver.findElement(steps).sendKeys(inputSteps);
    }

    @Step("Enter tips for exercise")
    public void enterTextInTipsField(String inputTips) {
        driver.findElement(tips).sendKeys(inputTips);
    }

    @Step("Enter warning if any for exercise")
    public void enterTextInWarningField(String inputWarnings) {
        driver.findElement(warning).sendKeys(inputWarnings);
    }

    @Step("Enter the video url if any")
    public void enterUrlInVideoUrlField(String inputVideoUrl) {
        driver.findElement(videoUrl).sendKeys(inputVideoUrl);
    }

    @Step("Click on add exercise button to save exercise successfully")
    public void clickOnAddExerciseButton() {
        driver.findElement(addExercise).click();
    }

    public ExerciseAndPlanPage(WebDriver driver)
    {
        this.driver=driver;
    }

    public void clickOnExerciseTab() {
        driver.findElement(exerciseTab).click();
    }

    public String getSuccessBannerText() {
        String successText =  driver.findElement(successBanner).getText();
        return successText;
    }

    public void clickExrciseAndPlanOptionMenuBar() {
        explicitWait(exrciseAndPlanOption);
        driver.findElement(exrciseAndPlanOption).click();
    }

    public void clickWorkoutPlanTab() {
        driver.findElement(workoutTab).click();
    }

    public boolean getContentOfExerciseTable(String exerciseName) {
        WebElement exercise = driver.findElement(exerciseTable);
        if(exercise.getText().contains(exerciseName)) {
            return true;
        }
        return false;
    }

    public boolean getContentOfWorkoutPlanTable(String workoutPlanName) {
        WebElement workoutPlanTable = driver.findElement(workoutTable);
        if(workoutPlanTable.getText().contains(workoutPlanName)) {
            return true;
        }
        return false;
    }

    public void fillNewWorkoutPlanForm() {
        readFile();
        randomNumberGenerator();
        workoutPlanName=prop.getProperty("workoutPlanName")+randomNum;
        clickExrciseAndPlanOptionMenuBar();
        clickNewWorkOutPlanButton();
        enterWorkoutName(workoutPlanName);
        enterWorkoutDesc(prop.getProperty("workoutPlanDesc"));
        fillExerciseName(prop.getProperty("exerciseNameWorkOut"));
        enterLb(prop.getProperty("lbInput"));
        enterReps(prop.getProperty("repsInput"));
        clickSaveButton();
    }

    public void fillExerciseForm() {
        readFile();
        randomNumberGenerator();
        exerciseName=prop.getProperty("exerciseName")+randomNum;
        clickExrciseAndPlanOptionMenuBar();
        clickOnExerciseTab();
        enterTextInExerciseField(exerciseName);
        selectValueFromMuscleGroupDropdown(prop.getProperty("muscleGroupValue"));
        clickOnMoreButton();
        enterTextInExercisePlanDesc(prop.getProperty("exercisePlanDesc"));
        enterTextInStepsField(prop.getProperty("stepsData"));
        enterTextInTipsField(prop.getProperty("tipsData"));
        enterTextInWarningField(prop.getProperty("warning"));
        enterUrlInVideoUrlField(prop.getProperty("urlVideo"));
        clickOnAddExerciseButton();
    }

}
