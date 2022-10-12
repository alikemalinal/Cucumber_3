package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/FeatureFiles/_01_Login.feature",
                    "src/test/java/FeatureFiles/_02_Country.feature"},
        glue = {"StepDefinitions"},
        dryRun = true // true oldugunda testi calıstırma, sadece featurelara ait steplerin varlıgını kontrol eder.
                        // false oldugunda ise testi calıstırır.
)
public class _02_TestRunnerBelirliFeaturelar extends AbstractTestNGCucumberTests {


}
