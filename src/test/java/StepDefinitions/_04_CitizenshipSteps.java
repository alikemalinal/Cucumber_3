package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNavigation;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class _04_CitizenshipSteps {

    DialogContent dialogContent = new DialogContent();

    @And("Navigate to Citizenship page")
    public void navigateToCitizenshipPage() {

        LeftNavigation leftNavigation = new LeftNavigation();
        leftNavigation.findAndClick("setupOne");
        leftNavigation.findAndClick("parameters");
        leftNavigation.findAndClick("citizenship");
    }

    @When("User a Citizenship name as {string} short name as {string}")
    public void userACitizenshipNameAsShortNameAs(String name, String shortName) {

        dialogContent.findAndClick("addButton");
        dialogContent.findAndSendKeys("nameInput", name);
        dialogContent.findAndSendKeys("shortName", shortName);
        dialogContent.findAndClick("saveButton");
    }

    @Then("Already exist message should be displayed")
    public void alreadyExistMessageShouldBeDisplayed() {

        dialogContent.findAndContainsText("alreadyExist", "already exists");
    }

    @And("Click on close button")
    public void clickOnCloseButton() {

        dialogContent.findAndClick("closeDialog");
    }

    @When("User delete the {string}")
    public void userDeleteThe(String searchText) {

        dialogContent.searchAndDelete(searchText);
    }
}
