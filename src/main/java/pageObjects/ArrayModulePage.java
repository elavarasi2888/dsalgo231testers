package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ArrayModulePage {

    WebDriver driver;

    public ArrayModulePage(WebDriver driver) {
        this.driver = driver;
    }

    // ------------------- Array Page Locators -------------------

    private By arrayHeader = By.tagName("h1");
    private By topicsCoveredHeader = By.xpath("//h2[contains(text(),'Topics Covered')]");
    private By tryHereButton = By.xpath("//a[contains(text(),'Try here')]");

    // Array Topics Links
    private By arraysInPythonLink = By.linkText("Arrays in Python");
    private By arraysUsingListLink = By.linkText("Arrays Using List");
    private By basicOperationsInListLink = By.linkText("Basic Operations in Lists");
    private By applicationsOfArrayLink = By.linkText("Applications of Array");

    // ------------------- Practice Questions Locators -------------------

    private By searchTheArrayLink = By.linkText("Search the array");
    private By maxConsecutiveOnesLink = By.linkText("Max Consecutive Ones");
    private By findNumbersWithEvenDigitsLink = By.linkText("Find Numbers with Even Number of Digits");
    private By squaresOfSortedArrayLink = By.linkText("Squares of a sorted Array");

    // Editor & buttons
    private By editorTextArea = By.id("editor");
    private By runButton = By.xpath("//button[contains(text(),'Run')]");
    private By submitButton = By.xpath("//button[contains(text(),'Submit')]");
    private By questionText = By.xpath("//div[contains(@class,'question-title')]");
    private By outputArea = By.id("output");
    private By errorMessage = By.id("error"); // replace with actual id/class if different

    // ------------------- Array Page Actions -------------------

    public boolean isOnArrayPage() {
        return driver.getTitle().contains("Array");
    }

    public boolean isHeaderVisible() {
        return driver.findElement(arrayHeader).isDisplayed();
    }

    public String getHeaderText() {
        return driver.findElement(arrayHeader).getText();
    }

    public boolean isTopicsCoveredHeaderVisible() {
        return driver.findElement(topicsCoveredHeader).isDisplayed();
    }

    public String getTopicsCoveredHeaderText() {
        return driver.findElement(topicsCoveredHeader).getText();
    }

    public void clickTryHereButton() {
        driver.findElement(tryHereButton).click();
    }

    // ------------------- Array Topics Actions -------------------

    public void clickArraysInPython() {
        driver.findElement(arraysInPythonLink).click();
    }

    public void clickArraysUsingList() {
        driver.findElement(arraysUsingListLink).click();
    }

    public void clickBasicOperationsInList() {
        driver.findElement(basicOperationsInListLink).click();
    }

    public void clickApplicationsOfArray() {
        driver.findElement(applicationsOfArrayLink).click();
    }

    public boolean isArraysInPythonDisplayed() {
        return driver.findElement(arraysInPythonLink).isDisplayed();
    }

    public boolean isArraysUsingListDisplayed() {
        return driver.findElement(arraysUsingListLink).isDisplayed();
    }

    public boolean isBasicOperationsInListDisplayed() {
        return driver.findElement(basicOperationsInListLink).isDisplayed();
    }

    public boolean isApplicationsOfArrayDisplayed() {
        return driver.findElement(applicationsOfArrayLink).isDisplayed();
    }

    // ------------------- Practice Questions Actions -------------------

    public boolean isOnPracticeQuestionsPage() {
        return driver.getTitle().contains("Practice Questions");
    }

    public void clickSearchTheArray() {
        driver.findElement(searchTheArrayLink).click();
    }

    public void clickMaxConsecutiveOnes() {
        driver.findElement(maxConsecutiveOnesLink).click();
    }

    public void clickFindNumbersWithEvenNumberOfDigits() {
        driver.findElement(findNumbersWithEvenDigitsLink).click();
    }

    public void clickSquaresOfSortedArray() {
        driver.findElement(squaresOfSortedArrayLink).click();
    }

    public boolean isSearchTheArrayDisplayed() {
        return driver.findElement(searchTheArrayLink).isDisplayed();
    }

    public boolean isMaxConsecutiveOnesDisplayed() {
        return driver.findElement(maxConsecutiveOnesLink).isDisplayed();
    }

    public boolean isFindNumbersWithEvenNumberOfDigitsDisplayed() {
        return driver.findElement(findNumbersWithEvenDigitsLink).isDisplayed();
    }

    public boolean isSquaresOfSortedArrayDisplayed() {
        return driver.findElement(squaresOfSortedArrayLink).isDisplayed();
    }

    // ------------------- Editor & Buttons -------------------

    public boolean isEditorVisible() {
        return driver.findElement(editorTextArea).isDisplayed();
    }

    public void enterCode(String code) {
        driver.findElement(editorTextArea).clear();
        driver.findElement(editorTextArea).sendKeys(code);
    }

    public void clearEditor() {
        driver.findElement(editorTextArea).clear();
    }

    public void clickRunButton() {
        driver.findElement(runButton).click();
    }

    public boolean isRunButtonVisible() {
        return driver.findElement(runButton).isDisplayed();
    }

    public boolean isSubmitButtonVisible() {
        return driver.findElement(submitButton).isDisplayed();
    }

    public boolean isQuestionTextVisible() {
        return driver.findElement(questionText).isDisplayed();
    }

    public boolean isOutputVisible() {
        return driver.findElement(outputArea).isDisplayed();
    }

    public boolean isErrorMessageVisible() {
        return driver.findElement(errorMessage).isDisplayed();
    }

    public boolean isAlertPresent() {
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept(); // handle alert
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // ------------------- URL Validation -------------------

    public boolean isCurrentURLContains(String partialLink) {
        return driver.getCurrentUrl().contains(partialLink);
    }

    // ------------------- Sample Codes -------------------

    public String getValidCode() {
        return "print('Hello World')"; // example valid code
    }

    public String getInvalidCode() {
        return "print('Hello World'"; // example invalid code
    }
}
