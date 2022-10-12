package StepDefinitions;

import Utilities.DriverClass;
import Utilities.ExcelUtility;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hooks {

    @Before
    public void before() {

        System.out.println("Scenario has started...");
    }

    @After
    public void after(Scenario scenario) {

        System.out.println("Scenario is done");
        System.out.println("Result of scenario = " + scenario.getStatus());
        System.out.println("Scenario isFailed? = " + scenario.isFailed());

        Date currentDate = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy | HH:mm:ss");

        ExcelUtility.writeExcel("src/test/java/ApachePOI/resource/ScenarioStatus.xlsx", scenario, DriverClass.threadBrowserName.get(), simpleDateFormat.format(currentDate));

        if (scenario.isFailed()) {

            TakesScreenshot screenshot = (TakesScreenshot) DriverClass.getDriver();
            File scrFile = screenshot.getScreenshotAs(OutputType.FILE);

            // Extend Reporta ekleniyor  EXTEND report olmadığında burası kaldırılmalı !!! yoksa browserlar KAPANMAZ
            // ExtentTestManager.getTest().addScreenCaptureFromBase64String(getBase64Screenshot());

            try {
                FileUtils.copyFile(scrFile, new File("target/FailedScreenshots/" + scenario.getName() +" " + simpleDateFormat.format(currentDate) + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        DriverClass.quitDriver();
    }

    public String getBase64Screenshot()
    {
        return ((TakesScreenshot) DriverClass.getDriver()).getScreenshotAs(OutputType.BASE64);
    }
}
