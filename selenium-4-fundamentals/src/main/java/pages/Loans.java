package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loans {

    private final WebDriver driver;

    @FindBy(css = "input[type=file]")
    private WebElement fileInput;

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
}
