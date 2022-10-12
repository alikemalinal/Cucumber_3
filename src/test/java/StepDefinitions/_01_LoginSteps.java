package StepDefinitions;

import Pages.DialogContent;
import Utilities.DriverClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class _01_LoginSteps {

    DialogContent dialogContent = new DialogContent();

    @Given("Navigate to basqar")
    public void navigateToBasqar() {

        DriverClass.getDriver().get("https://demo.mersys.io/");
        DriverClass.getDriver().manage().window().maximize();
        DriverClass.getDriver().manage().deleteAllCookies();
    }

    @When("Enter username and password and click login button")
    public void enterUsernameAndPasswordAndClickLoginButton() {

        dialogContent.findAndSendKeys("username", "richfield.edu");
        dialogContent.findAndSendKeys("password", "Richfield2020!");
        dialogContent.findAndClick("loginButton");
    }

    @Then("User should login successfully")
    public void userShouldLoginSuccessfully() {

        dialogContent.findAndContainsText("dashboard", "Dashboard");
        dialogContent.findAndClick("acceptCookies");
    }
}
