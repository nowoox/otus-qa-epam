package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {

    @FindBy(xpath = "//a[contains(@href, '/events')]")
    private WebElement eventLink;

    @FindBy(css = "#onetrust-accept-btn-handler")
    private WebElement acceptCookiesButton;

    @FindBy(css = "#onetrust-banner-sdk")
    private WebElement cookiesBanner;


    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openEvents() {

        webDriverWait.until(ExpectedConditions.visibilityOf(cookiesBanner));
        logElementIsDisplayed(cookiesBanner);

        acceptCookiesButton.click();
        logElementIsClicked(acceptCookiesButton);

        webDriverWait.until(ExpectedConditions.invisibilityOf(cookiesBanner));
        logger.info("Element is not displayed: " + cookiesBanner);

        eventLink.click();
        logElementIsClicked(eventLink);
    }


}
