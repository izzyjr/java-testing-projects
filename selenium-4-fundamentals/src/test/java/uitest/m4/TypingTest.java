package uitest.m4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static factory.DriverFactory.newChromeDriver;
import static helper.Pages.HOME;
import static wait.WaitingUtils.pause;

public class TypingTest {

    @Test
    public void typingTest() {
        WebDriver driver = newChromeDriver();
        driver.get(HOME);

        WebElement first = driver.findElement(By.id("firstName"));
        WebElement last = driver.findElement(By.id("lastName"));
        WebElement email = driver.findElement(By.id("email"));
        WebElement dob = driver.findElement(By.id("dob"));

        first.sendKeys("Sofia");
        last.sendKeys("Diaz");
        email.sendKeys("sofia@gmail.com");
        pause();
        email.clear();
        email.sendKeys("sofia@gmail.com");
        dob.sendKeys("22/03/2022");

        pause();
        driver.quit();
    }
}
