package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {

    @FindBy(id = "firstName")
    private WebElement firstName;

    @FindBy(id = "lastName")
    private WebElement lastName;

    @FindBy(id = "register")
    private WebElement register;

    @FindBy(id = "textarea")
    private WebElement textArea;

    @FindBy(className = "invalid-feedback")
    private WebElement invalidFeedback;

    private static final String URL = "file:///" + System.getProperty("user.home") + "/Desktop/java-testing-projects" +
            "/selenium-4-fundamentals/src/web/index.html";

    private final WebDriver driver;

    private Home(WebDriver driver) {
        this.driver = driver;
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

   public void clickOnRegister() {
        register.click();
   }
}
