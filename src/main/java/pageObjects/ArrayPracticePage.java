package pageObjects;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ArrayPracticePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By arrayTopicLink = By.xpath("//a[normalize-space()='Arrays in Python']");
    private By practiceQuestionsTopicLink = By.xpath("//a[normalize-space()='Practice Questions']");
    private By practiceQuestionsLinks = By.xpath("//a[@class='list-group-item']");


    // Constructor
    public ArrayPracticePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(1));
    }
    public boolean isPracticeQuestionLinkDisplayed(String expectedTopic) {

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(practiceQuestionsLinks));

        List<WebElement> links = driver.findElements(practiceQuestionsLinks);

        for (WebElement link : links) {
            String actualText = link.getText().trim();
            if (actualText.equalsIgnoreCase(expectedTopic.trim())) {
                return true;
            }
        }
        return false;
    }

    public void clickPracticeQuestionsTopicLink() {        
        wait.until(ExpectedConditions.elementToBeClickable(practiceQuestionsTopicLink)).click();
    }

    public void clickArrayTopicLink() {
        wait.until(ExpectedConditions.elementToBeClickable(arrayTopicLink)).click();
    }
}
