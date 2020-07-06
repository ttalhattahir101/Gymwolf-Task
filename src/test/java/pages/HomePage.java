package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage extends BasePage{

    //////////***************PageObject Variables********************************

    By startFreeTrialButton = By.id("landing-page-signup-form");
    By signInLinkText = By.cssSelector("#main-menu > ul > li:nth-child(2) > a");
    By registrationLinkText = By.cssSelector("#main-menu > ul > li:nth-child(1) > a");
    By registrationTextField = By.name("signup_email");
    By registerButton = By.cssSelector("#landing-page-signup-form > form > div:nth-child(2) > button");
    By loginEmailField = By.name("email");
    By loginPasswordField = By.name("password");
    By signInButton = By.cssSelector("#login-front > div > div > div > div > div > form > div:nth-child(4) " +
            "> div > div > button");
    By language = By.cssSelector("body > footer > div.footer-container > div > div:nth-child(1) > div:nth-child(5) " +
            "> p:nth-child(2) > a");

    //***********************Methods********************************************

    @Step("Click on registration link text")
    public void clickStartFreeTrialButton() {
        explicitWait(startFreeTrialButton);
        driver.findElement(startFreeTrialButton).click();
    }

    @Step("Enter text in email field")
    public void enterTextInEmailField(String email) {
        explicitWait(registrationTextField);
        driver.findElement(registrationTextField).sendKeys(email);
    }

    @Step("Click on register button")
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    @Step("Click on Sign In from homepage")
    public void clickOnSignInLinkText() {
        explicitWait(signInLinkText);
        driver.findElement(signInLinkText).click();
    }

    @Step("Enter text in email field of login form")
    public void enterTextInEmailFieldOfLoginForm(String email) {
        explicitWait(loginEmailField);
        driver.findElement(loginEmailField).sendKeys(email);
    }

    @Step("Enter text in password field of login form")
    public void enterTextInPasswordFieldOfLoginForm(String passwrd) {
        driver.findElement(loginPasswordField).sendKeys(passwrd);
    }

    @Step("Click on Sign In button to login to website")
    public void clickLoginButton() {
        driver.findElement(signInButton).click();
    }

    @Step("Signing to website with email and password")
    public void loginToWebsite(String email, String pswd) {
        clickOnSignInLinkText();
        explicitWait(loginEmailField);
        driver.findElement(loginEmailField).sendKeys(email);
        driver.findElement(loginPasswordField).sendKeys(pswd);
        driver.findElement(signInButton).click();
    }

    public HomePage(WebDriver driver)
    {
        this.driver=driver;
    }

    public String getLanguageText() {
        String text = driver.findElement(language).getText();
        return text;
    }
}
