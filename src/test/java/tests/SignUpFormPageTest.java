package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.BasePage;
import pages.HomePage;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SignUpFormPage;



public class SignUpFormPageTest extends BaseTest {

    HomePage homepageObj;
    SignUpFormPage signupFormPageObj;
    String email;
    BasePage basePageObj;
    String language;

    @BeforeClass
    public void initializeObjects()
    {
        getDriver();
        basePageObj = new BasePage();
        basePageObj.readFile();
        basePageObj.randomNumberGenerator();
        homepageObj = new HomePage(driver);
        signupFormPageObj = new SignUpFormPage(driver);
        language= homepageObj.getLanguageText();
    }

    //reading data from file
    @Test
    @Description("Registration of new User")
    public void signUpNewUser() {
        String getEmailAd = basePageObj.prop.getProperty("setEmailAd");
        email=basePageObj.randomNum+getEmailAd;
        homepageObj.clickStartFreeTrialButton();
        homepageObj.enterTextInEmailField(email);
        homepageObj.clickRegisterButton();
        Assert.assertEquals(email, signupFormPageObj.getValueOfEmailField());
        signupFormPageObj.fillRegistrationForm();
        String successMessage = signupFormPageObj.getSuccessMessageFromBanner();
        if(language.equals("In English")) {
            Assert.assertTrue(successMessage.contains(basePageObj.prop.getProperty("registrationFormSuccessEesti")));
        }
        else {
        Assert.assertTrue(successMessage.contains(basePageObj.prop.getProperty("registrationFormSuccessEng")));}
    }

    @AfterClass
    public void tearDown() {
        homepageObj=null;
        signupFormPageObj=null;
        basePageObj=null;
        quitBrowser();
    }



}
