package uitest.m4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static factory.DriverFactory.newChromeDriver;
import static helper.Pages.HOME;

public class UnderstandingWebElement {

    @Test
    public void webElementTest() {
        WebDriver driver = newChromeDriver();
        driver.get(HOME);

        WebElement input = driver.findElement(By.id("firstName"));
        System.out.println(input.isDisplayed());

        WebElement button = driver.findElement(By.id("register"));
        System.out.println(button.getText());

        driver.quit();
    }
}
