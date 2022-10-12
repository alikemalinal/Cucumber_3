package Pages;

import Utilities.DriverClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftNavigation extends Parent {

    public LeftNavigation() {
        PageFactory.initElements(DriverClass.getDriver(), this);
    }

    @FindBy(xpath = "(//span[text()='Setup'])[1]")
    private WebElement setupOne;

    @FindBy(xpath = "//span[text()='Parameters']")
    private WebElement parameters;

    @FindBy(xpath = "//span[text()='Countries']")
    private WebElement countries;

    @FindBy(xpath = "//span[text()='Citizenships']")
    private WebElement citizenship;

    @FindBy(xpath = "//span[text()='Nationalities']")
    private WebElement nationalities;

    @FindBy(xpath = "//span[text()='Fees']")
    private WebElement fees;

    @FindBy(xpath = "(//span[text()='Entrance Exams'])[1]")
    private WebElement entranceExamButton;

    @FindBy(xpath = "(//span[text()='Setup'])[2]")
    private WebElement setupTwo;

    @FindBy(xpath = "(//span[text()='Entrance Exams'])[2]")
    private WebElement entranceExamButton2;

    @FindBy(xpath = "//span[text()='Human Resources']")
    private WebElement humanResourcesButton;

    @FindBy(xpath = "//span[text()='Employees']")
    private WebElement employeesButton;

    WebElement myElement;

    public void findAndClick(String strElement) {

        switch (strElement) {
            case "setupOne": myElement = setupOne; break;
            case "parameters": myElement = parameters; break;
            case "countries": myElement = countries; break;
            case "citizenship": myElement = citizenship; break;
            case "nationalities": myElement = nationalities; break;
            case "fees": myElement = fees; break;
            case "entranceExamButton": myElement = entranceExamButton; break;
            case "setupTwo": myElement = setupTwo; break;
            case "entranceExamButton2": myElement = entranceExamButton2; break;
            case "humanResourcesButton": myElement = humanResourcesButton; break;
            case "employeesButton": myElement = employeesButton; break;

        }

        clickFunction(myElement);
    }
}
