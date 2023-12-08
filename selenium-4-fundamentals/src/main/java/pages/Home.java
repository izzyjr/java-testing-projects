package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Home {

    private final WebDriver driver;
    private Actions actions;

    @FindBy(id = "firstName")
    private WebElement firstName;

    @FindBy(id = "lastName")
    private WebElement lastName;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "dob")
    private WebElement dob;

    @FindBy(id = "register")
    private WebElement register;

    @FindBy(id = "textarea")
    private WebElement textArea;

    @FindBy(id = "heard-about")
    private WebElement checkbox;

    @FindBy(className = "invalid-feedback")
    private WebElement invalidFeedback;

    @FindBy(className = "invalid-feedback")
    private List<WebElement> feedback;

    private static final String URL = "file:///" + System.getProperty("user.home") + "/Desktop/java-testing-projects" +
            "/selenium-4-fundamentals/src/web/index.html";

    private Home(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public static Home homePage(WebDriver driver) {
        return new Home(driver);
    }

    public void goTo() {
        driver.get(URL);
    }

    public Boolean textAreaEnabled() {
        return textArea.isEnabled();
    }

    public void sendKeysTextArea(String text) {
        textArea.sendKeys(text);
    }

    public Boolean isFeedbackDisplayed() {
        return invalidFeedback.isDisplayed();
   }

    public String getFeedbackText(int row) {
        return feedback.get(row).getText();
    }

    public void clickOnRegister() {
        register.click();
   }

    public void clickOnCheckbox() {
        checkbox.click();
    }

    public void doubleClickCheckbox() {
        actions.doubleClick(checkbox).perform();
    }

    public void rightClick() {
        actions.contextClick().perform();
    }

    public void sendKeysToFields(fields field, String text) {
        switch (field) {
            case DOB -> dob.sendKeys(text);
            case FIRST_NAME -> firstName.sendKeys(text);
            case LAST_NAME -> lastName.sendKeys(text);
            case EMAIL -> email.sendKeys(text);
        }
    }

    public void clearField(fields field) {
        switch (field) {
            case DOB -> dob.clear();
            case FIRST_NAME -> firstName.clear();
            case LAST_NAME -> lastName.clear();
            case EMAIL -> email.clear();
        }
    }

    public enum fields {
        FIRST_NAME,
        LAST_NAME,
        EMAIL,
        DOB
    }
}
