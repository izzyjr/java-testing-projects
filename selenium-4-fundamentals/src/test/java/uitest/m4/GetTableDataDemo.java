package uitest.m4;

import base.BaseTestClass;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Savings;

import java.util.List;

import static helper.Pages.SAVINGS;

public class GetTableDataDemo extends BaseTestClass {

    private Savings savingsPage;

    @BeforeMethod
    private void pageSetUp() {
        savingsPage = Savings.savingsPage(driver);
    }

    @Test
    private void getTableData() {
        savingsPage.goTo();

        System.out.println("Table Data:");
        System.out.println(savingsPage.getTableText());

        System.out.println("Single row data:");
        System.out.println(savingsPage.getRowText(1));

        System.out.println("single cell data:");
        System.out.println(savingsPage.getCellText(1));
    }

    // Using Google Guava's Object Called: Table
    @Test
    private void scrapeTableData() {
        driver.get(SAVINGS);

        Table<Integer, Integer, String> tableObj = HashBasedTable.create();
        WebElement table = driver.findElement(By.id("rates"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        int rowIndex = 0;
        int colIndex = 0;
        for (WebElement row : rows) {
            List<WebElement> cols = row.findElements(By.tagName("td"));
            for (WebElement col : cols) {
                tableObj.put(rowIndex, colIndex++, col.getText());
            }
            rowIndex++;
            colIndex = 0;
        }

        System.out.println(tableObj);
        System.out.println("Best rate: " + tableObj.get(1, 3));
    }
}
