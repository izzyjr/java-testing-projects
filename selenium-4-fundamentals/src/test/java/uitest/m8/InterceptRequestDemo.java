package uitest.m8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.Request;
import org.openqa.selenium.devtools.v85.network.model.Response;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static factory.DevToolsFactory.newChromeDevTool;
import static factory.DriverFactory.newChromeDriver;

public class InterceptRequestDemo {
    WebDriver driver;
    DevTools devTools;

    @Test(enabled = false)
    public void howToGetDevToolsObject() {
        // demo
        ChromeDriver chromeDriver = new ChromeDriver();
        DevTools tools = chromeDriver.getDevTools();

        WebDriver chromeDriver1 = new ChromeDriver();
        DevTools tools2 = ((ChromeDriver) chromeDriver1).getDevTools();
    }

    @Test
    public void captureRequestTraffic() {
        driver = newChromeDriver();
        devTools = newChromeDevTool(driver);
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
        driver = newChromeDriver();
        devTools = newChromeDevTool(driver);
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
        driver = newChromeDriver();
        devTools = newChromeDevTool(driver);
        devTools.send(Network.setBlockedURLs(List.of("*/footer.js")));

        driver.get("http://127.0.0.1:8000/index.html");
        WebElement location = driver.findElement(By.id("location"));
        Assert.assertFalse(location.getText().contains("You are visiting us from "));
    }

    @AfterMethod
    public void cleanup() {
        devTools.send(Network.disable());
        devTools.close();
        driver.quit();
    }
}
