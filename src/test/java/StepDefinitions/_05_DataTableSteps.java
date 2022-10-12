package StepDefinitions;

import Pages.DialogContent;
import Pages.FormContent;
import Pages.LeftNavigation;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;

import java.util.List;

public class _05_DataTableSteps {

    LeftNavigation leftNavigation = new LeftNavigation();

    DialogContent dialogContent = new DialogContent();

    FormContent formContent = new FormContent();

    @And("Click on the element int the Left Navigation")
    public void clickOnTheElementIntTheLeftNavigation(DataTable elements) {

        List<String> listElement = elements.asList(String.class);

        for (int i = 0; i < listElement.size(); i++) {
            leftNavigation.findAndClick(listElement.get(i));
        }

    }

    @And("Click on the element in the Dialog")
    public void clickOnTheElementInTheDialog(DataTable elements) {

        List<String> listElement = elements.asList(String.class);

        for (int i = 0; i < listElement.size(); i++) {
            dialogContent.findAndClick(listElement.get(i));
        }
    }

    @And("User sending the keys in Dialog content")
    public void userSendingTheKeysInDialogContent(DataTable elements) {

        List<List<String>> listElement = elements.asLists(String.class);

        for (int i = 0; i < listElement.size(); i++) {
            dialogContent.findAndSendKeys(listElement.get(i).get(0), listElement.get(i).get(1));
            // List'in ilk elemanına(Webelement adı), ikinci elemanına yani değeri gönder dedik.
        }
    }

    @And("User delete item from Dialog")
    public void userDeleteItemFromDialog(DataTable elements) {

        List<String> listElement = elements.asList(String.class);

        for (int i = 0; i < listElement.size(); i++) {
            dialogContent.searchAndDelete(listElement.get(i));
        }
    }

    @And("Click on the element in the Form Content")
    public void clickOnTheElementInTheFormContent(DataTable elements) {

        List<String> listElement = elements.asList(String.class);

        for (int i = 0; i < listElement.size(); i++) {
            formContent.findAndClick(listElement.get(i));

        }
    }
}
