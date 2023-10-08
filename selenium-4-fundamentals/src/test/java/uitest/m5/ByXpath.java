package uitest.m5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static factory.DriverFactory.newChromeDriver;
import static helper.Pages.HOME;
import static helper.Pages.SAVINGS;

public class ByXpath {

    WebDriver driver;

    @BeforeMethod
    public void initDriver() {
        driver = newChromeDriver();
    }

    @Test
    public void byXpath() {
        driver.get(SAVINGS);

        var cell_1 = driver.findElement(By.xpath("/html/body/main/div/div/div/form/div/div[4]/table/tbody/tr[1]/td[4]"));
        System.out.println("Chrome full xpath: " + cell_1.getText());

        var cell_2 = driver.findElement(By.xpath("//*[@id='rates']/tbody/tr[1]/td[4]"));
        System.out.println("Chrome xpath: " + cell_2.getText());
    }

    @Test
    public void byXpath_2() {
        driver.get(HOME);

        var button =  driver.findElement(By.xpath("//form/button[contains(text(), 'Register')]"));
        System.out.println(button.getText());
    }

    @AfterMethod(alwaysRun = true)
    void closeDriver() {
        driver.quit();
    }
}
