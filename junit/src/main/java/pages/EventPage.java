package pages;

import base.BasePage;
import junit.framework.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EventPage extends BasePage {

    public EventPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//label[contains(text(), 'QA')]")
    private WebElement searchLabel;

    public void checkIfLabelPresented() {

        waitVisibilityOfElement(searchLabel);
        Assert.assertTrue("Label is not presented", searchLabel.isDisplayed());
        logElementIsDisplayed(searchLabel);

    }
}
