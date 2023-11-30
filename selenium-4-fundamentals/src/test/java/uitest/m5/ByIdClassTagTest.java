package uitest.m5;

import base.BaseTestClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static helper.Pages.HOME;
import static helper.Pages.SAVINGS;

public class ByIdClassTagTest extends BaseTestClass {

    @Test
    public void byId() {
        driver.get(HOME);

        driver.findElement(By.id("register")).click();
        driver.quit();
    }

    @Test
    public void byClass() {
        driver.get(HOME);
        driver.findElement(By.id("register")).click();

        WebElement firstMatch = driver.findElement(By.className("invalid-feedback"));

        List<WebElement> feedbackList = driver.findElements(By.className("invalid-feedback"));

        Assert.assertEquals(feedbackList.get(0).getText(), "Valid first name is required");
        Assert.assertEquals(feedbackList.get(1).getText(), "Valid last name is required");
        Assert.assertEquals(feedbackList.get(2).getText(), "Please enter a valid email address");
    }

    @Test
    public void byTagName() {
        driver.get(SAVINGS);

        var table = driver.findElement(By.id("rates"));
        var sameTable = driver.findElement(By.tagName("table"));

        System.out.println(table.getText());
        System.out.println(sameTable.getText());
    }
}
