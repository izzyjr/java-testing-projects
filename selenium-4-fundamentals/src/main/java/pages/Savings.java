package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Savings {

    private final WebDriver driver;

    private static final String URL = "file:///" + System.getProperty("user.home") + "/Desktop/java-testing-projects" +
            "/selenium-4-fundamentals/src/web/savings.html";

    private Savings(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static Savings savingsPage(WebDriver driver) {
        return new Savings(driver);
    }

    public void goTo() {
        driver.get(URL);
    }
}
