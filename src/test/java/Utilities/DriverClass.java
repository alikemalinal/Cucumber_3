package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DriverClass {

    public static WebDriver driver;

    // Bana neler lazım:  1 browser tipi lazım burada ona göre oluşturucam
    // her bir paralel çalışan süreç için sadece o sürece özel static bir değişken lazım
    // çünkü runner classdaki işaret edilen tüm senaryolarda aynısını çalışması lazım.
    // demekki her pipeline için (Local) ve de ona özel static bir drivera ihtiyacım var
    // donanımdaki adı pipeline , yazılımdaki adı Thread , paralel çalışan her bir süreç

    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>(); // WebDriver 1, WebDriver 2
    public static ThreadLocal<String> threadBrowserName = new ThreadLocal<>(); // chrome, firefox...

    // threadDriver.get() -> ilgili threaddeki driver'ı verecek.
    // threadDriver.set(driver) -> ilgili thread'e driver set ediliyor.

    public static WebDriver getDriver() {

        Locale.setDefault(new Locale("EN"));
        System.setProperty("user.language", "EN");

        Logger.getLogger("").setLevel(Level.SEVERE);
        System.setProperty(org.slf4j.impl.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "Error");

        if (threadBrowserName.get() == null) { // boş ise varsayılan chrome olsun dedik. Basic arayanlar için...
            threadBrowserName.set("chrome");
        }

        if (threadDriver.get() == null) {

            String browserName = threadBrowserName.get(); // bu thread'deki browserName'i verdi.

            switch (browserName) {
                case "chrome":
                    System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
                    WebDriverManager.chromedriver().setup();
                    threadDriver.set(new ChromeDriver()); // bu thread e chrome istenmisse ve yoksa bir tane ekleniyor
                    break;

                case "firefox":
                    System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
                    WebDriverManager.firefoxdriver().setup();
                    threadDriver.set(new FirefoxDriver());  // bu thread e firefox istenmisse ve yoksa bir tane ekleniyor
                    break;

                case "safari":
                    WebDriverManager.safaridriver().setup();
                    threadDriver.set(new SafariDriver());
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    threadDriver.set(new EdgeDriver());
                    break;
            }
        }

        return threadDriver.get();
    }

    public static void quitDriver() {

        if (threadDriver.get() != null) { // driver varsa quit yapsın.
            threadDriver.get().quit();

            WebDriver driver = threadDriver.get();
            driver = null;
            threadDriver.set(driver); // tekrar gelirse içi boş olsun diye yaptık.
        }
    }
}
