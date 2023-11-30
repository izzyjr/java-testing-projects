package uitest.m4;

import base.BaseTestClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static helper.Pages.HOME;

public class UnderstandingWebElement extends BaseTestClass {

    @Test
    public void webElementTest() {
        driver.get(HOME);

        WebElement input = driver.findElement(By.id("firstName"));
        System.out.println(input.isDisplayed());

        WebElement button = driver.findElement(By.id("register"));
        System.out.println(button.getText());
    }
}
