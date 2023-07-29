package uitest.m8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.Request;
import org.openqa.selenium.devtools.v85.network.model.Response;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class InterceptRequestDemo {
    WebDriver driver;
    DevTools devTools;

    @Test
    public void howToGetDevToolsObject() {
        ChromeDriver chromeDriver = new ChromeDriver();
        DevTools tools = chromeDriver.getDevTools();

        WebDriver chromeDriver1 = new ChromeDriver();
        DevTools tools2 = ((ChromeDriver) chromeDriver1).getDevTools();
    }

    @Test
    public void captureRequestTraffic() {
        driver = new ChromeDriver();
        devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();

        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        devTools.addListener(Network.requestWillBeSent(),
                requestEvent -> {
                    Request r = requestEvent.getRequest();
                    System.out.printf("URL: %s, Method: %s \n", r.getUrl(), r.getMethod());
                }
                );
        driver.get("http://127.0.0.1:8000/index.html");
    }

    @Test
    public void captureResponseTraffic() {
        driver = new ChromeDriver();
        devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();

        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        List<Integer> statuses = new ArrayList<>();
        devTools.addListener(Network.responseReceived(),
                responseReceived -> {
                    Response r = responseReceived.getResponse();
                    System.out.printf("Response status: %s \n", r.getStatus());
                    statuses.add(r.getStatus());
                });
        driver.get("http://127.0.0.1:8000/index.html");
        statuses.forEach(status -> Assert.assertTrue(status <= 400));
    }

    @Test
    public void manipulateTraffic() {
        driver = new ChromeDriver();
        devTools = getDevTool(driver);
        devTools.send(Network.setBlockedURLs(List.of("*.js")));

        driver.get("http://127.0.0.1:8000/index.html");
        WebElement location = new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(visibilityOfElementLocated(By.id("location")));
        Assert.assertTrue(location.getText().contains("You are visiting us from "));
    }

    private static DevTools getDevTool(WebDriver driver) {
        DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        return devTools;
    }

    @AfterMethod
    public void cleanup() {
        devTools.send(Network.disable());
        devTools.close();
        driver.quit();
    }
}
