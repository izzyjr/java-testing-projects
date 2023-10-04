package uitest.m4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static factory.DriverFactory.newChromeDriver;
import static helper.Pages.HOME;
import static wait.WaitingUtils.pause;

public class ClickingTest {

    @Test
    public void clickingTest() {
        WebDriver driver = newChromeDriver();
        driver.get(HOME);

        WebElement first = driver.findElement(By.id("firstName"));
        WebElement checkbox = driver.findElement(By.id("heard-about"));
        WebElement registerBtn = driver.findElement(By.id("register"));

        checkbox.click();
        registerBtn.click();
        pause();

        driver.quit();
    }

    @Test
    public void moreClicking() {
        WebDriver driver = newChromeDriver();
        driver.get(HOME);

        WebElement checkbox = driver.findElement(By.id("heard-about"));
        Actions actions = new Actions(driver);

        actions.doubleClick(checkbox).perform();

        pause();
        actions.contextClick();
        pause();

        driver.quit();
    }
}
