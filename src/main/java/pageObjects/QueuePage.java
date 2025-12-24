package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QueuePage {

    private WebDriver driver;

    private By headerQueue = By.xpath("//h4[normalize-space()='Queue']");
    private By headerTopicsCoveredQueue = By.xpath("//p[@class='bg-secondary text-white']");
    private By lnkQueueLinks = By.xpath("//a[@class='list-group-item']");
    private By headerQueueLinkTopic = By.xpath("//div[@class='col-sm']//strong//p");
    private By btnTryHereQueueLinkPage = By.xpath("//a[normalize-space()='Try here>>>']");

    public QueuePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isQueueHeaderVisible() {
        return driver.findElement(headerQueue).isDisplayed();
    }

    public boolean isTopicsCoveredHeaderForQueueVisible() {
        return driver.findElement(headerTopicsCoveredQueue).isDisplayed();
    }

    public boolean isQueueLinkVisible(String queueTopicLink) {
        List<WebElement> queueLinks = driver.findElements(lnkQueueLinks);

        for (WebElement q : queueLinks) {
            if (q.getText().equals(queueTopicLink))
                return true;
        }

        return false;
    }

    public void clickQueueTopicLink(String queueTopicLink) {
        By linkPath = By.xpath("//a[text() = '" + queueTopicLink + "']");
        driver.findElement(linkPath).click();
    }

    public String getQueueLinkTopicHeader() {
        return driver.findElement(headerQueueLinkTopic).getText();
    }

    public boolean isTryHereButtonOnQueueLinkPageVisible() {
        return driver.findElement(btnTryHereQueueLinkPage).isDisplayed();
    }

    public void clickTryHereInQueueLinkPage() {
        driver.findElement(btnTryHereQueueLinkPage).click();
    }

    public String getQueuePageURL() {
        return driver.getCurrentUrl();
    }
}
