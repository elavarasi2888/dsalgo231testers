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

   
    By pageHeader = By.xpath("//h4[text()='Array']"); 
	By tryHereButton=By.xpath ("//a[text()='Try here>>>']]");
	By topicsCoveredHeader = By.xpath("//p[contains(text(),'Topics Covered')]"); 
	 By arraysInPython = By.xpath("//a[contains(text(),'Arrays in Python')]");
	 By arraysUsingList = By.xpath("//a[contains(text(),'Arrays Using List')]");
	  By arraysBasicOperationInList = By.xpath("//a[contains(text(),'Basic Operations in Lists')]");
	  By arraysApplicationOfArray = By.xpath("//a[contains(text(),'Applications of Array')]");
	

    // ------------------- Practice Questions Locators -------------------

	  By practiceQuestionsInArray = By.xpath("//a[contains(text(),'Practice Questions')]");
	  By searchTheArrayLink = By.xpath("//a[contains(text(),'Search the array')]");
	  By maxConsecutiveOnesLink = By.xpath("//a[contains(text(),'Max Consecutive Ones')]");
	  By findNumbersWithEvenDigitsLink =
	         By.xpath("//a[contains(text(),'Find Numbers with Even Number of Digits')]");
	  By squaresOfSortedArrayLink =
	         By.xpath("//a[contains(text(),'Squares of  a Sorted Array')]");

    // Editor & buttons
	  By editorTextArea = By.id("editor");
	  By runButton = By.xpath("//button[contains(text(),'Run')]");
	  By submitButton = By.xpath("//button[contains(text(),'Submit')]");

	  // Output / error
	    By outputArea = By.id("output");
	    By errorMessage = By.id("error");

	    // Question text
	    By questionText = By.xpath("//div[contains(@class,'question')]");
   
    // ------------------- Array Page Actions -------------------

    public boolean isOnArrayPage() {
        return driver.getTitle().contains("Array");
    }

    public boolean isHeaderVisible() {
        return driver.findElement(pageHeader).isDisplayed();
    }

    public String getHeaderText() {
        return driver.findElement(pageHeader).getText();
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
        driver.findElement(arraysInPython).click();
    }

    public void clickArraysUsingList() {
        driver.findElement(arraysUsingList).click();
    }

    public void clickBasicOperationsInList() {
        driver.findElement(arraysBasicOperationInList).click();
    }

    public void clickApplicationsOfArray() {
        driver.findElement(arraysApplicationOfArray).click();
    }

    public boolean isArraysInPythonDisplayed() {
        return driver.findElement(arraysInPython).isDisplayed();
    }

    public boolean isArraysUsingListDisplayed() {
        return driver.findElement(arraysUsingList).isDisplayed();
    }

    public boolean isBasicOperationsInListDisplayed() {
        return driver.findElement(arraysBasicOperationInList).isDisplayed();
    }

    public boolean isApplicationsOfArrayDisplayed() {
        return driver.findElement(arraysApplicationOfArray).isDisplayed();
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
