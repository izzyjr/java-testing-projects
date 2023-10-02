package uitest.m4;

import static wait.WaitingUtils.pause;
import helper.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static helper.Pages.HOME;
import static helper.Pages.PREFIX;
import static helper.Pages.SAVINGS;

public class NavigationTest {

    @Test
    public void basicNavigationTest() {
        WebDriver driver = DriverFactory.newDriver();

        driver.get(PREFIX + HOME);

        pause();
        driver.get(PREFIX + SAVINGS);

        pause();
        driver.navigate().back();

        pause();
        driver.navigate().forward();

        driver.navigate().refresh();

        driver.quit();
    }
}
