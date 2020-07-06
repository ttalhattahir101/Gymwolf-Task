package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

public class SignUpFormPage extends BasePage{

    String name;

    //////////***************PageObject Variables********************************

    By emailField = By.cssSelector("#tabs-1 > div.col-xs-12 > div.form-group.error > div > p");
    By nameField = By.id("gwn");
    By radioBoxMale = By.id("gender_male");
    By monthDropDown = By.name("Date_Month");
    By dateDropDown = By.name("Date_Day");
    By yearDropDown = By.name("Date_Year");
    By passowrdField = By.id("gwp");
    By confirmPasswordField = By.id("gwp2");
    By unitDropDown = By.id("gwunits");
    By timeZoneDropDown = By.id("timezone");
    By myGymField = By.id("mygym");
    By profileURL = By.id("gwun");
    By saveButton = By.cssSelector("#tabs-1 > div.col-xs-12 > div.form-actions > input");
    By sucessBanner = By.className("alert-success");


    //***********************Methods********************************************
    @Step("Enter first name in the field")
    public void enterTextInNameField(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    @Step("Enter password in the field")
    public void enterPassword(String paswrd) {
        driver.findElement(passowrdField).sendKeys(paswrd);
    }

    @Step("Select value from radio button")
    public void selectValueFromRadioButton() {
        driver.findElement(radioBoxMale).click();
    }

    @Step("Enter confirm password in the field")
    public void enterConfirmPassword(String confirmPaswrd) {
        driver.findElement(confirmPasswordField).sendKeys(confirmPaswrd);
    }

    @Step("Select date of birth")
    public void selectValuesFromBirthDateDropDown(String month, String date, String year) {
        explicitWait(monthDropDown);
        Select drpMonth = new Select(driver.findElement(monthDropDown));
        drpMonth.selectByVisibleText(month);

        Select drpDate = new Select(driver.findElement(dateDropDown));
        drpDate.selectByVisibleText(date);

        Select drpYear = new Select(driver.findElement(yearDropDown));
        drpYear.selectByVisibleText(year);
    }

    @Step("Select unit value")
    public void selectUnitValue(String unit) {
        Select drpUnit = new Select(driver.findElement(unitDropDown));
        drpUnit.selectByValue(unit);
    }

    @Step("Select timezone from the list")
    public void selectTimeZoneValue(String timeZone) {
        Select drpTimeZone = new Select(driver.findElement(timeZoneDropDown));
        drpTimeZone.selectByVisibleText(timeZone);
    }

    @Step("Enter text in my gym field")
    public void enterTextInGymField(String text) {
        driver.findElement(myGymField).sendKeys(text);
    }

    @Step("Enter text for profile url")
    public void enterTextInProfileURL(String text) {
        driver.findElement(profileURL).sendKeys(text);
    }

    @Step("Click on save button to save form")
    public void clickSaveButton() {
        driver.findElement(saveButton).click();
    }

    public SignUpFormPage(WebDriver driver) {
        this.driver=driver;
    }

    public void readFile() {
        File file = new File("src/testdata.properties");

        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        prop = new Properties();

        //load properties file
        try {
            prop.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getValueOfEmailField() {
        String email = driver.findElement(emailField).getText();
        return email;
    }

    public String getSuccessMessageFromBanner() {
        String text = driver.findElement(sucessBanner).getText();
        return text;
    }

    //reading data from file
    public void fillRegistrationForm() {
        readFile();
        randomNumberGenerator();
        name = "Tester"+randomNum;
        enterTextInNameField(name);
        selectValueFromRadioButton();
        enterPassword(prop.getProperty("setPassword"));
        enterConfirmPassword(prop.getProperty("confirmPassword"));
        selectValuesFromBirthDateDropDown(prop.getProperty("month"), prop.getProperty("date"), prop.getProperty("year"));
        selectUnitValue(prop.getProperty("unit"));
        selectTimeZoneValue(prop.getProperty("timeZone"));
        enterTextInGymField(prop.getProperty("gymField"));
        enterTextInProfileURL(name);
        clickSaveButton();
    }
}
