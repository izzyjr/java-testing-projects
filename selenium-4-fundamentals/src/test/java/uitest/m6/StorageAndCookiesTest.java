package uitest.m6;

import base.BaseTestClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.html5.SessionStorage;
import org.openqa.selenium.html5.WebStorage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static helper.Pages.HOME;
import static helper.Pages.SAVINGS;
import static wait.WaitingUtils.pause;

public class StorageAndCookiesTest extends BaseTestClass {

    @Test
    public void storageTest() {
        driver.get(HOME);

        var first = driver.findElement(By.id("firstName"));
        var last = driver.findElement(By.id("lastName"));
        var save = driver.findElement(By.id("save"));

        first.sendKeys("Maria");
        last.sendKeys("Diaz");
        save.click();

        WebStorage webStorage = (WebStorage) driver;
        SessionStorage storage = webStorage.getSessionStorage();
        storage.keySet()
                        .forEach(key -> System.out.println(key + "= " + storage.getItem(key)));
        pause();
        driver.get(SAVINGS);

        driver.navigate().back();

        pause();

        var first_1 = driver.findElement(By.id("firstName"));
        var last_1 = driver.findElement(By.id("lastName"));
        Assert.assertEquals(first_1.getAttribute("value"), "Maria");
        Assert.assertEquals(last_1.getAttribute("value"), "Diaz");

        storage.clear();
        driver.navigate().refresh();

        pause();
        var first_2 = driver.findElement(By.id("firstName"));
        var last_2 = driver.findElement(By.id("lastName"));
        Assert.assertEquals(first_2.getAttribute("value"), "");
        Assert.assertEquals(last_2.getAttribute("value"), "");

        driver.quit();
    }

    @Test
    public void cookiesTest() {
        WebDriver.Options options = driver.manage();

        options.getCookies().forEach(cookie -> System.out.println(cookie.getName()));
        Cookie thing = options.getCookieNamed("thing");
        options.deleteAllCookies();

        // etc
    }
}
