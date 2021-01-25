package base;

import driver.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.MainPage;

public class BaseTest {

    protected WebDriver driver;
    public Logger logger = LogManager.getLogger(BaseTest.class);
    public MainPage mainPage;

    @BeforeEach
    void setUp() {
        DriverFactory driverFactory = new DriverFactory();
        WebDriverManager.chromedriver().setup();
        driver = driverFactory.createDriver();
        logger.info("Driver was started");
        mainPage = PageFactory.initElements(driver, MainPage.class);
    }

    @AfterEach
    void setDown() {
        if (driver != null) {
            driver.quit();
            logger.info("Driver was stopped");
        }
    }

}
