package Runners;

import Utilities.DriverClass;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

@CucumberOptions(
        tags = "@Regression",
        features = {"src/test/java/FeatureFiles"},
        glue = {"StepDefinitions"},
        plugin = {"html:target/cucumber-reports.html"}
)
public class _08_TestRunnerParallel extends AbstractTestNGCucumberTests {

    @BeforeClass(alwaysRun = true) // bazı java hataları cıkabiliyor o yuzden (alwaysRun = true) dedik.
    @Parameters("browser")
    public void beforeClass(String browser) {

        DriverClass.threadBrowserName.set(browser); // bu thread'e browserName set edildi.
    }
}
