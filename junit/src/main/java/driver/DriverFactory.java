package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    public enum Browsers {
        CHROME,
        FIREFOX,
        OPERA
    }

    private final ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    private final ThreadLocal<RemoteWebDriver> remoteDriver = new ThreadLocal<RemoteWebDriver>();

    public WebDriver createDriver(Browsers browser) {

        switch (browser){

            case CHROME:
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                System.setProperty("webdriver.chrome.silentOutput", "true");
                driver.set(new ChromeDriver(options));
                break;

            case FIREFOX:
                driver.set(new FirefoxDriver());
                break;

            case OPERA:
                driver.set(new OperaDriver());
                break;
        }

        return driver.get();
    }

    public RemoteWebDriver createRemoteDriver() {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("86.0");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        try {
            remoteDriver.set(new RemoteWebDriver(
                    new URL("http://0.0.0.0:4444/wd/hub"), capabilities));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return remoteDriver.get();
    }

}
