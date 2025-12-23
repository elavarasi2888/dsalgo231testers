package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ArrayPracticePage 
{
	WebDriver driver;
	

    // ------------------- Locators ----------------------------------------------------
	// Practice Questions links
	  By practiceQuestionsInArray = By.xpath("//a[contains(text(),'Practice Questions')]");
	  By searchTheArrayLink = By.xpath("//a[contains(text(),'Search the array')]");
	  By maxConsecutiveOnesLink = By.xpath("//a[contains(text(),'Max Consecutive Ones')]");
	  By findNumbersWithEvenDigitsLink =
	         By.xpath("//a[contains(text(),'Find Numbers with Even Number of Digits')]");
	  By squaresOfSortedArrayLink =
	         By.xpath("//a[contains(text(),'Squares of  a Sorted Array')]");
	// Editor & buttons--------------------------------------------------------------------
	 
	  By editorTextArea = By.id("editor");
	  By runButton = By.xpath("//button[contains(text(),'Run')]");
	  By submitButton = By.xpath("//button[contains(text(),'Submit')]");

	  // Output / error
	    By outputArea = By.id("output");
	    By errorMessage = By.id("error");

	    // Question text
	    private By questionText = By.xpath("//div[contains(@class,'question')]");

	// Constructor
	public ArrayPracticePage(WebDriver driver)
    {
        this.driver = driver;
    }
	 // ------------------- Navigation------------------------------------

    public boolean isOnPracticeQuestionsPage() 
    {
        return driver.getTitle().contains("Practice Questions"); 
    }

    public boolean isCurrentURLContains(String partialLink) 
    {
        return driver.getCurrentUrl().contains(partialLink);
    }
    // ------------------- Link Display Checks -------------------

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

    // ------------------- Link Click Actions -------------------

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

    // ------------------- Output / Error Checks -------------------

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
    // ------------------- Sample Code for Testing -------------------

    public String getValidCode() {
        return "print('Hello World')"; // example valid code
    }

    public String getInvalidCode() {
        return "print('Hello World'"; // example invalid code
    }

}


  