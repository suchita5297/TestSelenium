package SauceDemoTests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import utils.ConfigReader;


public class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    @Parameters({"browser"})
    public void setUp(@Optional("chrome") String browserParam) {
        String env = System.getProperty("env", "uat");
        ConfigReader.loadProperties(env);  // Load config file

        String baseUrl = ConfigReader.get("baseUrl");

        if (browserParam.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browserParam.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(baseUrl);
    }
}
