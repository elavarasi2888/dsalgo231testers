package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class ArrayPage {
	WebDriver driver;
	//WebElement arrayPageHeading;
	//WebElement arrayHeader;
	
	// ================== By Locators ==================
   
    //By tryHereButton = By.xpath("//a[contains(text(),'Try here')]");
    //By allLinks = By.tagName("a");	    
   //	By arraylink=By.linkText("Array");
	
	By pageHeader = By.xpath("//h4[text()='Array']"); 
	By tryHereButton=By.xpath ("//a[text()='Try here>>>']]");
	By topicsCoveredHeader = By.xpath("//p[contains(text(),'Topics Covered')]"); 
	 By arraysInPython = By.xpath("//a[contains(text(),'Arrays in Python')]");
	 By arraysUsingList = By.xpath("//a[contains(text(),'Arrays Using List')]");
	  By arraysBasicOperationInList = By.xpath("//a[contains(text(),'Basic Operations in Lists')]");
	  By arraysApplicationOfArray = By.xpath("//a[contains(text(),'Applications of Array')]");
	
	     
	// Constructor
	public ArrayPage(WebDriver driver)
    {
        this.driver = driver;
    }
	
	// ================== Page Validations ==================

    public boolean isOnArrayPage() {
        return driver.getTitle().equalsIgnoreCase("Array");
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

    public boolean isTryHereButtonVisible() {
        return driver.findElement(tryHereButton).isDisplayed();
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
   
    public boolean isCurrentURLContains(String value) {
        return driver.getCurrentUrl().contains(value);
    }

 // ================== Actions ==================

   
   
    public void clickArraysInPython() {
        driver.findElement(arraysInPython).click();
        clickTryHereButton();
    }

    public void clickArraysUsingList() {
        driver.findElement(arraysUsingList).click();
        clickTryHereButton();
        
    }

    public void clickBasicOperationsInList() {
        driver.findElement(arraysBasicOperationInList).click();
        clickTryHereButton();
    }

    public void clickApplicationsOfArray() {
        driver.findElement(arraysApplicationOfArray).click();
        clickTryHereButton();
    }

    public void clickTryHereButton() {
        driver.findElement(tryHereButton).click();
    }

	public String getArrayPageURL() {
		return driver.getCurrentUrl();
	}

       
}	
	
	



