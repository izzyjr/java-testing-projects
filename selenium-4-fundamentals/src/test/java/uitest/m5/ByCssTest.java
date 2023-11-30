package uitest.m5;

import base.BaseTestClass;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static helper.Pages.HOME;
import static wait.WaitingUtils.pause;

public class ByCssTest extends BaseTestClass {

    @Test
    public void byCssSelector() {
        driver.get(HOME);
        var datePicker = driver.findElement(By.cssSelector("input[type=date]"));
        datePicker.sendKeys("06/14/2023");
    }

    @Test
    public void byCssSelector_2() {
        driver.get(HOME);
        var checkbox = driver.findElement(By.cssSelector("[type=checkbox]:not(:checked)"));
        checkbox.click();

        pause();
    }
}
