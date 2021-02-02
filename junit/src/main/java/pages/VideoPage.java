package pages;

import base.BasePage;
import io.qameta.allure.Step;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class VideoPage extends BasePage {

    @FindBy(css = "div.evnt-toogle-filters-text:nth-child(1) > span:nth-child(1)")
    private WebElement moreFilterButton;

    @FindBy(css = "#filter_location")
    private WebElement locationDropDown;

    @FindBy(css = "#filter_language")
    private WebElement languageDropDown;

    @FindBy(xpath = "//*[@data-value='Belarus']")
    private WebElement belarusItem;

    @FindBy(xpath = "//*[@data-value='ENGLISH']")
    private WebElement englishLanguageItem;

    @FindBy(xpath = "//input[contains(@class, 'evnt-search') and contains(@placeholder, 'Search by Talk Name')]")
    private WebElement searchField;

    @FindBy(xpath = "//div[contains(@class, 'evnt-talks-column')]")
    private List<WebElement> listOfCards;

    @FindBy(xpath = "//div[contains(@class, 'evnt-cards-container')]")
    private WebElement resultFound;

    String query = "QA";

    public VideoPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step
    public void adjustFilter() {

        waitVisibilityOfElement(moreFilterButton);
        logElementIsDisplayed(moreFilterButton);

        moreFilterButton.click();
        logElementIsClicked(moreFilterButton);

        waitVisibilityOfElement(locationDropDown);
        logElementIsDisplayed(locationDropDown);

        locationDropDown.click();
        logElementIsClicked(locationDropDown);

        belarusItem.click();
        logElementIsClicked(belarusItem);

    }

    @Step
    public void typeAndSearch() {

        waitVisibilityOfElement(searchField);
        logElementIsDisplayed(searchField);

        searchField.sendKeys(query);
        logger.info("Typed text " + query + " to " + searchField);

        waitVisibilityOfElement(resultFound);
        logElementIsDisplayed(resultFound);

        Assert.assertNotSame("List of found items is empty", listOfCards.size(), 0);
        logger.info("Found " + listOfCards.size() + " talks");
    }

    @Step
    public void checkFoundTalksTitle() {

        for (WebElement ele : listOfCards) {

           Assert.assertTrue("No query string in title", ele.findElement(By.xpath("//*[contains(@class, 'evnt-talk-name')]/h1/span"))
                   .getText()
                   .contains(query));
           logger.info("Title of card " + listOfCards.indexOf(ele) + " contains query string");
        }

    }
}
