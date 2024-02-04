package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class Loans {

    private final WebDriver driver;

    @FindBy(css = "input[type=file]")
    private WebElement fileInput;

    @FindBy(id = "borrow")
    private WebElement borrow;

    @FindBy(id = "result")
    private WebElement result;

    private static final String URL = "file:///" + System.getProperty("user.home") + "/Desktop/java-testing-projects" +
            "/selenium-4-fundamentals/src/web/loans.html";

    private Loans(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static Loans loansPage(WebDriver driver) {
        return new Loans(driver);
    }

    public void goTo() {
        driver.get(URL);
    }

    public void uploadFile(String file) {
        fileInput.sendKeys(file);
    }

    public void sendKeysBorrow(String text) {
        borrow.sendKeys(text);
    }

    public void clickOnResult() {
        result.click();
    }

    public void implicitlyWait(int seconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    public void isResultDisplayed() {
        result.isDisplayed();
    }

    public WebElement waitFor(int seconds, loansIDSs id) {
        return new WebDriverWait(driver, Duration.ofSeconds(seconds))
                .until(visibilityOfElementLocated(By.id(id.id)));
    }

    public enum loansIDSs {
        RESULT("result");

        final String id;
        loansIDSs(String id) {
            this.id = id;
        }
    }
}
