package StepDefinitions;

import Pages.DialogContent;
import Utilities.DBUtility;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class _11_JDBCSteps {
    @Then("Send the query the database {string} and control match")
    public void sendTheQueryTheDatabaseAndControlMatch(String query) {

        // DB'den ekrandaki isimleri alicam
        List<List<String>> dbList = DBUtility.getListData(query);
        System.out.println("dbList = " + dbList);

        // Web'den ekrandaki isimleri alicam
        DialogContent dialogContent = new DialogContent();
        List<WebElement> uiList = dialogContent.waitVisibleListAllElement(dialogContent.nameList);
        for (WebElement e : uiList) {
            System.out.println("e.getText() = " + e.getText());
        }

        // karsilastirma yapiyorum
        for (int i = 0; i < dbList.size(); i++) {
            Assert.assertEquals("Error",dbList.get(i).get(1), uiList.get(i).getText());
        }

    }
}
