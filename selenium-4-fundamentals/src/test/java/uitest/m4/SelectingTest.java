package uitest.m4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import static factory.DriverFactory.newChromeDriver;
import static helper.Pages.SAVINGS;
import static wait.WaitingUtils.pause;

public class SelectingTest {

    @Test
    public void selectingTest() {
        WebDriver driver = newChromeDriver();
        driver.get(SAVINGS);

        WebElement input = driver.findElement(By.id("deposit"));
        input.sendKeys("100");

        WebElement period = driver.findElement(By.id("period"));
        Select select = new Select(period);
        select.selectByValue("6 months");
        pause();
        select.selectByVisibleText("1 Year");
        pause();
        select.selectByIndex(2);

        WebElement result = driver.findElement(By.id("result"));
        Assert.assertEquals(result.getText(), "After 2 Years you will earn $12.00 on your deposit");

        driver.quit();
    }
}
