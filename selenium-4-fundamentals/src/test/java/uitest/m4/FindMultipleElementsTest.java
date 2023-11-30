package uitest.m4;

import base.BaseTestClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static helper.Pages.HOME;

public class FindMultipleElementsTest extends BaseTestClass {

    @Test
    public void multipleElementsTest() {
        driver.get(HOME);

        List<WebElement> feedback = driver.findElements(By.className("invalid-feedback"));

        driver.findElement(By.id("register")).click();
        print(feedback.get(0).getText());
        print(feedback.get(1).getText());
    }

    private void print(String text) {
        System.out.println("Feedback:" + text);
    }
}
