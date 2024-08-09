package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;

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

    public void enterBorrowAmount(String value) {
        driver.findElement(By.id("borrow")).sendKeys(value);
    }

    public void selectTimePeriod(Period period) {
        Select dropdown = new Select(driver.findElement((By.id("period"))));
        dropdown.selectByVisibleText(period.toString());
    }

    public enum loansIDSs {
        RESULT("result");

        final String id;

        loansIDSs(String id) {
            this.id = id;
        }

        public String getId() {
            return this.id;
        }
    }

    public void verifyResultMessage(WebElement result, String expectedMessage) {
        Assert.assertEquals(result.getText(), expectedMessage);
    }

    public enum Period {
        ONE_MONTH("1 month"),
        TWO_MONTH("2 months"),
        ONE_YEAR("1 year");

        final String period;
        Period(String period) {
            this.period = period;
        }
        @Override
        public String toString() {
            return period;
        }
    }
}
