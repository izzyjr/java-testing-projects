package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Savings {

    private final WebDriver driver;

    @FindBy(id = "rates")
    WebElement table;

    @FindBy(tagName = "tr")
    List<WebElement> rows;

    @FindBy(tagName = "td")
    List<WebElement> cells;

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

    public String getTableText() {
        return table.getText();
    }

    public String getRowText(int row) {
        return rows.get(row).getText();
    }

    public String getCellText(int cell) {
        return cells.get(cell).getText();
    }
}
