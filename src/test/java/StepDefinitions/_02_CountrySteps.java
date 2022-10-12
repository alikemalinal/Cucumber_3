package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNavigation;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;

public class _02_CountrySteps {

    LeftNavigation leftNavigation = new LeftNavigation();
    DialogContent dialogContent = new DialogContent();

    @And("Navigate to country page")
    public void navigateToCountryPage() {

        leftNavigation.findAndClick("setupOne"); // Setup Click
        leftNavigation.findAndClick("parameters"); // Parameters Click
        leftNavigation.findAndClick("countries"); // Countries Click
    }

    @When("Create a country")
    public void createACountry() {
        String randomGenerateName = RandomStringUtils.randomAlphabetic(8);
        String randomGenerateCode = RandomStringUtils.randomAlphanumeric(4);

        dialogContent.findAndClick("addButton");
        dialogContent.findAndSendKeys("nameInput", randomGenerateName);
        dialogContent.findAndSendKeys("codeInput", randomGenerateCode);
        dialogContent.findAndClick("saveButton");
    }

    @Then("Success message should be displayed")
    public void successMessageShouldBeDisplayed() {

        dialogContent.findAndContainsText("successMessage", "success");
    }

    @When("Create a country name as {string} code as {string}")
    public void createACountryNameAsCodeAs(String name, String code) {

        dialogContent.findAndClick("addButton");
        dialogContent.findAndSendKeys("nameInput", name);
        dialogContent.findAndSendKeys("codeInput", code);
        dialogContent.findAndClick("saveButton");
    }
}
