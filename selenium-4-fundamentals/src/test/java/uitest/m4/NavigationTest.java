package uitest.m4;

import base.BaseTestClass;
import org.testng.annotations.Test;

import static helper.Pages.*;
import static wait.WaitingUtils.pause;

public class NavigationTest extends BaseTestClass {

    @Test
    public void basicNavigationTest() {

        driver.get(PREFIX + HOME);

        pause();
        driver.get(PREFIX + SAVINGS);

        pause();
        driver.navigate().back();

        pause();
        driver.navigate().forward();

        driver.navigate().refresh();
    }
}
