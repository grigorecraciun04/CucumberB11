package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverHelper {
    private static WebDriver driver;

    //private constructor to make sure they do not create and object from this class
    private DriverHelper() {
    }

    public static WebDriver getDriver() {

        if (driver == null) {//I am checking driver whether it is null or not
            //if driver is null I am going to create a new one
            //if not, It is not going to create a new Driver, it will use the existing one.
            switch (ConfigReader.readProperty("browsers")) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
            }
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));// here your driver will wait 10 second
        }
        return driver;
    }

    public static void tearDown() {
        getDriver().quit();
        driver=null;
    }
}

