package Pages;

import Utilities.DriverClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormContent extends Parent{

    public FormContent() {
        PageFactory.initElements(DriverClass.getDriver(), this);
    }

    @FindBy(xpath = "(//mat-select[@formcontrolname='id']/div/div)[1]")
    private WebElement academicPeriodInput;

    @FindBy(xpath = "(//mat-option[@role='option']/span)[1]")
    private WebElement academicPeriodInput2;

    @FindBy(xpath = "(//mat-select[@formcontrolname='id']/div/div)[3]")
    private WebElement gradeLevel;

    @FindBy(xpath = "(//mat-option[@role='option']/span)[1]")
    private WebElement gradeLevel2;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='firstName']//input")
    private WebElement firstName;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='lastName']//input")
    private WebElement lastName;

    @FindBy(xpath = "(//mat-select[@formcontrolname='gender']/div/div)[1]")
    private WebElement gender;

    @FindBy(css = "mat-select[formcontrolname='gender'] span > span")
    private WebElement gender2;

    @FindBy(xpath = "//span[text()='Employee Type']")
    private WebElement employeeType;

    @FindBy(xpath = "//span[text()=' Teacher ']")
    private WebElement employeeType2;

    @FindBy(css = "input[formcontrolname='employeeId']")
    private WebElement employeeIdInput;

    @FindBy(xpath = "//span[text()='Qualification']")
    private WebElement qualification;

    @FindBy(css = "mat-select[formcontrolname='qualification'] span > span")
    private WebElement qualification2;

    WebElement myElement;

    public void findAndClick(String strElement) {

        switch (strElement) {
            case "academicPeriodInput": myElement = academicPeriodInput; break;
            case "academicPeriodInput2": myElement = academicPeriodInput2; break;
            case "gradeLevel": myElement = gradeLevel; break;
            case "gradeLevel2": myElement = gradeLevel2; break;
            case "gender": myElement = gender; break;
            case "gender2": myElement = gender2; break;
            case "employeeType": myElement = employeeType; break;
            case "employeeType2": myElement = employeeType2; break;
            case "qualification": myElement = qualification; break;
            case "qualification2": myElement = qualification2; break;
        }

        clickFunction(myElement);
    }

    public void findAndSendKeys(String strElement, String value) {

        switch (strElement) {
            case "firstName": myElement = firstName; break;
            case "lastName": myElement = lastName; break;
            case "employeeIdInput": myElement = employeeIdInput; break;
        }

        sendKeysFunction(myElement, value);
    }
}
