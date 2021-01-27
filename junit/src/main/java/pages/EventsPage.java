package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EventsPage extends BasePage {

    @FindBy(css = "a.active:nth-child(1) > span:nth-child(1)")
    private WebElement upcomingEventsButton;

    public EventsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openUpcomingEvents() {

        waitVisibilityOfElement(upcomingEventsButton);
        logElementIsDisplayed(upcomingEventsButton);

        upcomingEventsButton.click();
        logElementIsClicked(upcomingEventsButton);

    }
}
