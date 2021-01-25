package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {

    private final ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    private final ThreadLocal<RemoteWebDriver> remoteDriver = new ThreadLocal<RemoteWebDriver>();

    public WebDriver createDriver() {

        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless", "--silent");
        options.addArguments("--start-maximized");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        driver.set(new ChromeDriver(options));

        return driver.get();
    }

    public RemoteWebDriver createRemoteDriver() {
        return remoteDriver.get();
    }

}
