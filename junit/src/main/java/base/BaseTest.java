package base;

import driver.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.EventsPage;
import pages.MainPage;

import java.net.MalformedURLException;

public class BaseTest {

    //protected RemoteWebDriver driver;
    public Logger logger = LogManager.getLogger(BaseTest.class);
    public MainPage mainPage;
    public EventsPage eventsPage;
    protected WebDriver driver;

    @BeforeEach
    void setUp() throws MalformedURLException {
        DriverFactory driverFactory = new DriverFactory();
        WebDriverManager.chromedriver().setup();
        driver = driverFactory.createDriver();
        logger.info("Driver was started");

        mainPage = PageFactory.initElements(driver, MainPage.class);
        eventsPage = PageFactory.initElements(driver, EventsPage.class);
    }

    @AfterEach
    void setDown() {
        if (driver != null) {
            driver.quit();
            logger.info("Driver was stopped");
        }
    }

}
