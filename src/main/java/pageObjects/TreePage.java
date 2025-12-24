package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TreePage {
    private WebDriver driver;

    By headerTree = By.xpath("//h4[normalize-space()='Tree']");
    By headerTopicsCoveredTree = By.xpath("//p[@class='bg-secondary text-white']");
    By lnkTreeLinks = By.xpath("//a[@class='list-group-item']");
    By headerTreeLink = By.xpath("//div[@class='col-sm']//strong//p");
    By btnTryHereTreeLinkPage = By.xpath("//a[normalize-space()='Try here>>>']");

    public TreePage(WebDriver driver) {

        this.driver = driver;
    }

    public boolean isTreeHeaderVisible() {

        return driver.findElement(headerTree).isDisplayed();
    }

    public boolean isTopicsCoveredHeaderTreeVisible() {

        return driver.findElement(headerTopicsCoveredTree).isDisplayed();
    }

    public List<String> treeLinksVisible() {

        List<String> a = new ArrayList<>();
        List<WebElement> treeLinks = driver.findElements(lnkTreeLinks);
        for (WebElement t : treeLinks) {
            a.add(t.getText().toLowerCase());
        }
        return a;
    }


    public boolean isTreeLinksVisible(String treeTopicLink) {
        List<WebElement> treeLinks = driver.findElements(lnkTreeLinks);
        for (WebElement t : treeLinks) {
            if (t.getText().equals(treeTopicLink))
                return true;
        }

        return false;
    }

    public void clickTreeTopicLink(String treeTopicLink) {
        By linkPath = By.xpath("//a[text() = '" + treeTopicLink + "']");
        driver.findElement(linkPath).click();
    }

    public String getTreePageURL() {
        return driver.getCurrentUrl();
    }

    public String getTreeLinkHeader() {

        return driver.findElement(headerTreeLink).getText();
    }

    public boolean isTryHereButtonOnTreeLinkPageVisible() {

        return driver.findElement(btnTryHereTreeLinkPage).isDisplayed();
    }

    public void clickTryHereInTreeLinkPage() {
        driver.findElement(btnTryHereTreeLinkPage).click();

    }


}
