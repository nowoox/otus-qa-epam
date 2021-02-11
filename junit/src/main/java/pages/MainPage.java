package pages;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {

    @FindBy(xpath = "//a[contains(@href, '/events')]")
    private WebElement eventLink;

    @FindBy(xpath = "//a[contains(@href, '/video')]")
    private WebElement videoLink;

    @FindBy(css = "#onetrust-accept-btn-handler")
    private WebElement acceptCookiesButton;

    @FindBy(css = "#onetrust-banner-sdk")
    private WebElement cookiesBanner;


    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    /**
     * Метод выполняет нажатие кнопки на всплывающем баннере
     * для соглашения использования cookies
     *
     */
    @Step
    public void acceptCookies() {

        webDriverWait.until(ExpectedConditions.visibilityOf(cookiesBanner));
        logElementIsDisplayed(cookiesBanner);

        acceptCookiesButton.click();
        logElementIsClicked(acceptCookiesButton);

        waitInvisibilityOfElement(cookiesBanner);
        logElementIsNotDisplayed(cookiesBanner);

    }

    /**
     * Метод выполняет переход на вкладку Events
     */
    @Step
    public void openEvents() {

        acceptCookies();

        eventLink.click();
        logElementIsClicked(eventLink);
    }

    /**
     * Метод выполняет переход на вкладку Videos
     */
    @Step
    public void openVideos() {

        acceptCookies();

        videoLink.click();
        logElementIsClicked(videoLink);

    }

}
