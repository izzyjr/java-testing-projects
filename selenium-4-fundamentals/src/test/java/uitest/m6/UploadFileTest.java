package uitest.m6;

import base.BaseTestClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static helper.Pages.LOANS;
import static wait.WaitingUtils.pause;

public class UploadFileTest extends BaseTestClass {

    @Test
    void uploadFile() throws IOException {
        driver.get(LOANS);

        WebElement fileInput = driver.findElement(By.cssSelector("input[type=file]"));

        Path path = Files.createTempFile("file", ".txt");
        String fileName = path.toAbsolutePath().toString();
        System.out.println(fileName);

        fileInput.sendKeys(fileName);

        pause();
        path.toFile().deleteOnExit();
    }
}
