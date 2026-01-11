package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ArrayPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By headerArray = By.xpath("//h4[normalize-space()='Array']");
    private By headerTopicsCoveredArray = By.xpath("//p[@class='bg-secondary text-white']");
    private By headerArrayLinkTopic = By.xpath("//div[@class='col-sm']//strong//p");
    private By lnkArrayLinks = By.xpath("//a[@class='list-group-item']");
    private By btnTryHereArrayLinkPage = By.xpath("//a[normalize-space()='Try here>>>']");
    private By arrayInPythonTopicLink = By.xpath("//a[normalize-space()='Arrays in Python']");
    private By practiceQuestionsTopicLink = By.xpath("//a[normalize-space()='Practice Questions']");
    private By practiceQuestionsLinks = By.xpath("//a[@class='list-group-item']");
    private By codeEditor = By.xpath("//div[@class='CodeMirror-scroll']");
    private By searchArrayLink = By.xpath("//a[normalize-space(text())='Search the array']");
    private By maxConsecutiveOnes = By.xpath("//a[normalize-space(text())='Max Consecutive Ones']");
    private By findNumberwithEvenNumbereofDigits = By
            .xpath("//a[normalize-space(text())='Find Numbers with Even Number of Digits']");
    private By squaresofaSortedArray = By.xpath("//a[normalize-space(text())='Squares of a Sorted Array']");
    private By submitBtn = By.xpath("//input[@value='Submit']");

    public ArrayPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isArrayHeaderVisible() {
        return driver.findElement(headerArray).isDisplayed();
    }

    public boolean isTopicsCoveredHeaderForArrayVisible() {
        return driver.findElement(headerTopicsCoveredArray).isDisplayed();
    }

    public String getArrayLinksTopicHeader() {
        return driver.findElement(headerArrayLinkTopic).getText();
    }

    public boolean isTryHereButtonVisible() {
        return driver.findElement(btnTryHereArrayLinkPage).isDisplayed();
    }

    public boolean isArrayLinkVisible(String arrayTopicLink) {
        List<WebElement> arrayLinks = driver.findElements(lnkArrayLinks);

        for (WebElement a : arrayLinks) {
            if (a.getText().equals(arrayTopicLink))
                return true;
        }
        return false;
    }

    public void clickArrayTopicLink(String arrayTopicLink) {
        By linkPath = By.xpath("//a[text() = '" + arrayTopicLink + "']");
        driver.findElement(linkPath).click();
    }

    public String getArrayPageURL() {
        return driver.getCurrentUrl();
    }

    public void clickTryHereInArrayLinkPage() {
        driver.findElement(btnTryHereArrayLinkPage).click();
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

    public void clickSearchTheArray() {
        driver.getCurrentUrl().contains("array/practice");
        driver.findElement(searchArrayLink).click();
    }

    public void clickPracticeQuestions() {
        try {
            WebElement link = wait.until(ExpectedConditions.elementToBeClickable(practiceQuestionsLinks));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", link);
            link.click();
        } catch (TimeoutException e) {
            throw new NoSuchElementException("Practice Questions link not found or not clickable.");
        }
    }

    public void clickPracticeQuestionByName(String questionName) {
        By questionLink = By.xpath("//a[contains(text(),'" + questionName + "')]");
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(questionLink));
        link.click();
    }

    public void clearEditorText() {
        WebElement editor = wait.until(ExpectedConditions.visibilityOfElementLocated(codeEditor));
        editor.click();

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();
    }

    public void clickRunButton() {
        driver.findElement(By.xpath("//button[normalize-space()='Run']")).click();
    }

    public String getOutputText() {
        return driver.findElement(By.id("output")).getText(); // replace with actual output locator
    }

    public void clickArrayTopicLink1() {
        wait.until(ExpectedConditions.elementToBeClickable(arrayInPythonTopicLink)).click();
    }

    public void clickArraysInPythonLink() {
        driver.findElement(arrayInPythonTopicLink).click();
    }

    public void clickPracticeQuestionsFromArraysInPython() {
        clickArraysInPythonLink();
        driver.findElement(practiceQuestionsTopicLink).click();
    }

    public void navigateToArrayPractice() {
        driver.navigate().to("https://dsportalapp.herokuapp.com/array/practice");
    }

    public void clickSubmit() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        submit.click();
        System.out.println("SUBMIT CLICKED");
    }

    public void enterDataIntoEditor(String inputData) {
        WebElement txtDsCode = driver.findElement(codeEditor);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions act = new Actions(driver);
        act.moveToElement(txtDsCode).click();
        js.executeScript("document.querySelector('.CodeMirror').CodeMirror.setValue('');");
        js.executeScript("document.querySelector('.CodeMirror').CodeMirror.setValue(arguments[0]);", inputData);
    }

    public void clickMaxConsecutiveOnes() {
        driver.getCurrentUrl().contains("array/practice");
        driver.findElement(maxConsecutiveOnes).click();
    }

    public void clickFindNumberswithEvenNumberofDigits() {
        driver.getCurrentUrl().contains("array/practice");
        driver.findElement(findNumberwithEvenNumbereofDigits).click();
    }

    public void clickSquaresofaSortedArray() {
        driver.getCurrentUrl().contains("array/practice");
        driver.findElement(squaresofaSortedArray).click();
    }
}
