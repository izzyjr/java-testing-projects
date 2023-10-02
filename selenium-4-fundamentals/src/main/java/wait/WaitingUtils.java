package wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class WaitingUtils {

    public static WebElement waitUntilClickable(WebDriver driver, By locator, long seconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(elementToBeClickable(locator));
    }

    public static WebElement waitUntilVisible(WebDriver driver, By locator, long seconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(visibilityOfElementLocated(locator));
    }

    /**
     * slow down execution
     */
    public static void pause() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
