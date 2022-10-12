package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DriverBasic {

    /*

    SINGLETON DRIVER CLASS

    - We're using singleton driver because we need 1 driver for every class in our project

     */

    public static WebDriver driver;

    public static WebDriver getDriver() {


        if (driver == null) { // if the driver objecxt is equal to null (there is no active driver instance)
                              // then we'll create a new driver

            Locale.setDefault( new Locale("EN"));
            System.setProperty("user.language","EN");

            Logger.getLogger("").setLevel(Level.SEVERE);
            System.setProperty(org.slf4j.impl.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "Error");
            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

            // WebDriverManager.firefoxdriver().setup();
            // driver = new FirefoxDriver();
        }

        return driver;
    }

    public static void quitDriver() {

        if (driver != null) { // driver varsa quit yapsın.
            driver.quit();
            driver = null; // if we don't have this line next scenario will fail
                            // after driver.quit we need to set driver object to null
        }
    }
}

