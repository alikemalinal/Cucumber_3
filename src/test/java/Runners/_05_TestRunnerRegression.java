package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        // "or" oldugunda herhangi bir tanesi varsa calıstırılır.
        // "and" oldugunda her ikisininde senaryoda tag olarak olan senaryoları calıstırılır.
//      tags = "@Regression or @SmokeTest", -> böyle de yapabiliyoruz
        tags = "@Regression", // hangi senaryolarda bu etiket varsa onlar çalıstırılacak.
        features = {"src/test/java/FeatureFiles"}, // bütün testleri çalıştırır.
        glue = {"StepDefinitions"}
)
public class _05_TestRunnerRegression extends AbstractTestNGCucumberTests {

    // Browser tipi vermek için, rapora ek parametre eklemek icin kullanacagız.

}
