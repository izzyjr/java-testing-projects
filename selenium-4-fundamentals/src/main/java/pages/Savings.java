package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Savings {

    private final WebDriver driver;
    private Select select;

    @FindBy(id = "rates")
    private WebElement table;

    @FindBy(tagName = "tr")
    private List<WebElement> rows;

    @FindBy(tagName = "td")
    private List<WebElement> cells;

    @FindBy(id = "deposit")
    private WebElement depositInput;

    @FindBy(id = "period")
    private WebElement periodDropdown;

    @FindBy(id = "result")
    private WebElement result;

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

    public void inputDeposit(String amount) {
        depositInput.sendKeys(amount);
    }

    public void selectPeriodDropdown(String period) {
        select = new Select(periodDropdown);
        select.selectByValue(period);
    }

    public void selectPeriodDropdownByIndex(int index) {
        select = new Select(periodDropdown);
        select.selectByIndex(index);
    }

    public String getResultText() {
        return result.getText();
    }
}
