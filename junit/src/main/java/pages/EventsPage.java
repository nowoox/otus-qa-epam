package pages;

import base.BasePage;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EventsPage extends BasePage {

    @FindBy(css = "a.active:nth-child(1) > span:nth-child(1)")
    private WebElement upcomingEventsButton;

    @FindBy(css = "li.evnt-tab-item:nth-child(2) > a:nth-child(1) > span:nth-child(1)")
    private WebElement pastEventsButton;

    @FindBy(css = "a.active:nth-child(1) > span:nth-child(3)")
    private WebElement eventCounterSpan;

    @FindBy(css = "div.evnt-event-card")
    private WebElement upcomingEventPanel;

    @FindBy(xpath = "//div[contains(@class, 'evnt-cards-container')]")
    private WebElement cardsContainer;

    @FindBy(css = "#filter_location")
    private WebElement locationDropDown;

    @FindBy(xpath = "//*[@data-value='Canada']")
    private WebElement canadaItem;

    @FindBy(xpath = "//div[@class='evnt-card-heading']/div/div[1]")
    private WebElement eventLocation;

    @FindBy(xpath = "//div[@class='evnt-card-heading']/div/div[2]")
    private WebElement eventLanguage;

    @FindBy(xpath = "//div[@class='evnt-card-body']/div/div[1]")
    private WebElement eventName;

    @FindBy(xpath = "//div[@class='evnt-card-body']/div/div[2]")
    private WebElement eventDate;

    @FindBy(xpath = "//div[@class='evnt-card-footer']/div/div[1]")
    private WebElement eventSpeakers;

    public EventsPage(WebDriver webDriver) {
        super(webDriver);
    }

    /**
     * Метод выполняет переход на вкладку предстоящих мероприятий
     */
    @Step
    public void openUpcomingEvents() {

        waitVisibilityOfElement(upcomingEventsButton);
        logElementIsDisplayed(upcomingEventsButton);

        upcomingEventsButton.click();
        logElementIsClicked(upcomingEventsButton);
    }

    /**
     * Метод выполняет проверку соответствия счетчика на панели
     * и количества отображаемых карточек
     * @param event тип мероприятий: предстоящие или прошедшие
     */
    @Step
    public void checkIfCountersMatch(EventsType event) {

        switch (event) {

            case PAST:
                Assertions.assertEquals(
                        getNumberOfEventsOnLink(), getNumberOfPastEventsOnPanels());
                break;

            case UPCOMING:
                Assertions.assertEquals(
                        getNumberOfEventsOnLink(), getNumberOfUpcomingEventsOnPanels());
                break;
        }

        logger.info("Number of upcoming events is same on link and on panels");
    }

    /**
     * @return количество мероприятий на счетчике панели
     */
    private int getNumberOfEventsOnLink() {

        int number = Integer.parseInt(eventCounterSpan.getText());
        logger.info("Number of upcoming events on link is " + number);

        return number;
    }

    /**
     * @return количество карточек предстоящих мероприятий на странице
     */
    private int getNumberOfUpcomingEventsOnPanels() {

        int number = driver.findElements(By.cssSelector("div.evnt-event-card")).size();
        logger.info("Number of upcoming events on panels is " + number);

        return number;
    }

    /**
     * @return количество карточек прошедших мероприятий на странице
     */
    private int getNumberOfPastEventsOnPanels() {

        int number = driver.findElements(By.cssSelector("div.evnt-event-card")).size();
        logger.info("Number of past events on panels is " + number);

        return number;
    }

    /**
     * Метод выполняет переход на вкладку прошедших мероприятий
     */
    @Step
    public void openPastEvents() {

        waitVisibilityOfElement(pastEventsButton);
        logElementIsDisplayed(pastEventsButton);

        pastEventsButton.click();
        logElementIsClicked(pastEventsButton);

        waitVisibilityOfElement(cardsContainer);
        logElementIsDisplayed(cardsContainer);
    }

    /**
     * Метод выполняет настройку фильтра для поиска по
     * location: Canada
     */
    @Step
    public void adjustFilter() {

        locationDropDown.click();
        logElementIsClicked(locationDropDown);

        canadaItem.click();
        logElementIsClicked(canadaItem);

        webDriverWait.until(ExpectedConditions.
                invisibilityOf(driver.findElement(By.xpath("//*[contains(@class, 'evnt-global-loader')]"))));

    }

    /**
     * Метод выполняет проверку отображения полей на карточке мероприятия
     */
    @Step
    public void checkEventCardInfo() {

        waitVisibilityOfElement(eventLocation);

        Assertions.assertTrue(eventLocation.isDisplayed());
        logElementIsDisplayed(eventLocation);

        Assertions.assertTrue(eventLanguage.isDisplayed());
        logElementIsDisplayed(eventLanguage);

        Assertions.assertTrue(eventName.isDisplayed());
        logElementIsDisplayed(eventLocation);

        Assertions.assertTrue(eventDate.isDisplayed());
        logElementIsDisplayed(eventDate);

        Assertions.assertTrue(eventSpeakers.isDisplayed());
        logElementIsDisplayed(eventSpeakers);

    }
}
