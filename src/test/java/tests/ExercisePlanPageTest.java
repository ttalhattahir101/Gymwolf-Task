package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.ExerciseAndPlanPage;
import pages.HomePage;

public class ExercisePlanPageTest extends BaseTest {
    HomePage homePageObj;
    ExerciseAndPlanPage exrciseObj;
    BasePage basePageObj;
    String language;

    @BeforeClass
    public void loginToWebsite() {
        getDriver();
        homePageObj = new HomePage(driver);
        exrciseObj = new ExerciseAndPlanPage(driver);
        basePageObj =new BasePage();
        basePageObj.readFile();
        language=homePageObj.getLanguageText();
        homePageObj.loginToWebsite(basePageObj.prop.getProperty("email"),basePageObj.prop.getProperty("password"));
    }

    //reading data from file
    @Test
    @Description("Create a new workout plan")
    public void addNewWorkoutPlan() {
        exrciseObj.fillNewWorkoutPlanForm();
        String successMessage = exrciseObj.getSuccessBannerText();
        if(language.equals("In English"))
            Assert.assertTrue(successMessage.contains(basePageObj.prop.getProperty("workoutPlanEesti")));
        else {
                successMessage.contains(basePageObj.prop.getProperty("workoutPlanEng"));}
        exrciseObj.clickWorkoutPlanTab();
        Assert.assertTrue(exrciseObj.getContentOfWorkoutPlanTable(basePageObj.prop.getProperty("workoutPlanName")));
    }

    @Test
    @Description("Add new exercise in the list")
    public void addNewExercise() {
        exrciseObj.fillExerciseForm();
        String successMessage = exrciseObj.getSuccessBannerText();
        if(language.equals("In English")) {
            Assert.assertTrue(successMessage.contains(basePageObj.prop.getProperty("exerciseAddedEesti")));}
        else {
                successMessage.contains(basePageObj.prop.getProperty("exerciseAddedEng"));}
        Assert.assertTrue(exrciseObj.getContentOfExerciseTable(basePageObj.prop.getProperty("exerciseName")));
    }

    @AfterClass
    public void tearDown() {
        homePageObj=null;
        exrciseObj=null;
        basePageObj=null;
        quitBrowser();
    }
}
