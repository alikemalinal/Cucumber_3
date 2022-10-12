package StepDefinitions;

import Pages.DialogContent;
import Utilities.ExcelUtility;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;

public class _06_ApachePOISteps {

    DialogContent dialogContent = new DialogContent();

    @When("User create citizenship with ApachePOI")
    public void userCreateCitizenshipWithApachePOI() {
        ArrayList<ArrayList<String>> table = ExcelUtility.getListData("src/test/java/ApachePOI/resource/ApacheExcel2.xlsx", "testCitizen", 2);

        for (ArrayList<String> row : table) {
            dialogContent.findAndClick("addButton");
            dialogContent.findAndSendKeys("nameInput", row.get(0));
            dialogContent.findAndSendKeys("shortName", row.get(1));
            dialogContent.findAndClick("saveButton");
            dialogContent.findAndContainsText("successMessage", "success");
        }
    }

    @Then("User delete citizenship with ApachePOI")
    public void userDeleteCitizenshipWithApachePOI() {

        ArrayList<ArrayList<String>> table = ExcelUtility.getListData("src/test/java/ApachePOI/resource/ApacheExcel2.xlsx", "testCitizen", 1);

        for (ArrayList<String> row : table) {
            dialogContent.searchAndDelete(row.get(0));
            dialogContent.findAndContainsText("successMessage", "success");

        }
    }
}
