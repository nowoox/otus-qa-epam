package pages;

import base.BasePage;
import io.qameta.allure.Step;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EventsPage extends BasePage {

    @FindBy(css = "a.active:nth-child(1) > span:nth-child(1)")
    private WebElement upcomingEventsButton;

    @FindBy(css = "a.active:nth-child(1) > span:nth-child(3)")
    private WebElement eventCounterSpan;

    @FindBy(css = "div.evnt-event-card")
    private WebElement upcomingEventPanel;

    public EventsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step
    public void openUpcomingEvents() {

        waitVisibilityOfElement(upcomingEventsButton);
        logElementIsDisplayed(upcomingEventsButton);

        upcomingEventsButton.click();
        logElementIsClicked(upcomingEventsButton);

    }

    @Step
    public void checkIfCountersMatch() {
        Assert.assertEquals("Number of upcoming events is not same",
                getNumberOfUpcomingEventsOnLink(), getNumberOfUpcomingEventsOnPanels());
        logger.info("Number of upcoming events is same on link and on panels");
    }

    private int getNumberOfUpcomingEventsOnLink() {

        int number = Integer.parseInt(eventCounterSpan.getText());
        logger.info("Number of upcoming events on link is " + number);

        return number;
    }

    private int getNumberOfUpcomingEventsOnPanels() {

        int number = driver.findElements(By.cssSelector("div.evnt-event-card")).size();
        logger.info("Number of upcoming events on panels is " + number);

        return number;
    }
}
