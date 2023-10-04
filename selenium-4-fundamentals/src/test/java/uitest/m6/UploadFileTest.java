package uitest.m6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static factory.DriverFactory.newChromeDriver;
import static helper.Pages.LOANS;
import static wait.WaitingUtils.pause;

public class UploadFileTest {

    @Test
    void uploadFile() throws IOException {
        WebDriver driver = newChromeDriver();
        driver.get(LOANS);

        WebElement fileInput = driver.findElement(By.cssSelector("input[type=file]"));

        Path path = Files.createTempFile("file", ".txt");
        String fileName = path.toAbsolutePath().toString();
        System.out.println(fileName);

        fileInput.sendKeys(fileName);

        pause();
        driver.quit();
        path.toFile().deleteOnExit();
    }
}
