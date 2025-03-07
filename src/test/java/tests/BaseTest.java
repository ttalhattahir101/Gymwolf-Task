package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {

    public static WebDriver driver;

    String url = "https://www.gymwolf.com/staging/"; //Url of webportal

    private void browserSetup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("enable-automation");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-browser-side-navigation");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-setuid-sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(url);
        System.out.println("BrowserStart");
    }

    public WebDriver getDriver()
    {
        if(driver ==null) {
            browserSetup();
        }
        return driver;
    }

    public void quitBrowser()
    {
        System.out.println("BrowserClose");
        driver.close();
        driver.quit();
        driver =null;
    }

}
