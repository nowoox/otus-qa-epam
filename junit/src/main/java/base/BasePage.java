package base;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    public WebDriver driver;
    public WebDriverWait webDriverWait;
    public Logger logger = LogManager.getLogger(BaseTest.class);

    public BasePage(WebDriver webDriver) {
        this.driver = webDriver;
        webDriverWait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
    }

    public void click(By elementBy) {
        driver.findElement(elementBy).click();
    }


    public void moveAndClick(By elementBy) {

        Actions builder = new Actions(driver);

        builder.moveToElement(driver.findElement(elementBy))
                .click()
                .build()
                .perform();

        //logger.info("Выполнен клик по элементу: " + elementBy);
    }

    public void waitIsClickable(By elementBy) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementBy));
        logger.info("Элемент найден: " + elementBy);
    }

    public void waitVisibilityOfElement(WebElement ele) {
        webDriverWait.until(ExpectedConditions.visibilityOf(ele));
    }

    public void logElementIsDisplayed(WebElement ele) {
        logger.info("Element is displayed: " + ele);
    }

    public void logElementIsClicked(WebElement ele) {
        logger.info("Click completed on element: " + ele);
    }

}
