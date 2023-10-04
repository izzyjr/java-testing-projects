package uitest.m4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static factory.DriverFactory.newChromeDriver;
import static helper.Pages.HOME;

public class FindMultipleElementsTest {

    @Test
    public void multipleElementsTest() {
        WebDriver driver = newChromeDriver();
        driver.get(HOME);

        List<WebElement> feedback = driver.findElements(By.className("invalid-feedback"));

        driver.findElement(By.id("register")).click();
        print(feedback.get(0).getText());
        print(feedback.get(1).getText());

        driver.quit();
    }

    private void print(String text) {
        System.out.println("Feedback:" + text);
    }
}
