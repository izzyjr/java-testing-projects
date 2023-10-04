package uitest.m4;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static factory.DriverFactory.newChromeDriver;
import static helper.Pages.HOME;
import static helper.Pages.PREFIX;
import static helper.Pages.SAVINGS;
import static wait.WaitingUtils.pause;

public class NavigationTest {

    @Test
    public void basicNavigationTest() {
        WebDriver driver = newChromeDriver();

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
