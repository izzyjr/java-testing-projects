package uitest.m5;

import base.BaseTestClass;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static helper.Pages.HOME;
import static wait.WaitingUtils.pause;

public class ByLinkText extends BaseTestClass {

    @Test
    public void byLinkText() {
        driver.get(HOME);

        driver.findElement(By.linkText("Savings")).click();
        pause();

        driver.findElement(By.partialLinkText("Reg")).click();
        pause();
    }
}
