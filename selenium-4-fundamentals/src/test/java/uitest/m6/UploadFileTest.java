package uitest.m6;

import base.BaseTestClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Loans;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static wait.WaitingUtils.pause;

public class UploadFileTest extends BaseTestClass {

    private Loans loansPage;

    @BeforeMethod
    private void pageSetUp() {
        loansPage = Loans.loansPage(driver);
    }

    @Test
    private void uploadFile() throws IOException {
        loansPage.goTo();

        Path path = Files.createTempFile("file", ".txt");
        String fileName = path.toAbsolutePath().toString();
        System.out.println(fileName);

        loansPage.uploadFile(fileName);

        pause();
        path.toFile().deleteOnExit();
    }
}
