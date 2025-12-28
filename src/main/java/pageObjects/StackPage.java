package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StackPage {
	
	WebDriver driver;	
	
	By pageHeader=By.xpath("//h4[normalize-space()='Stack']");
	By topicsCoveredHeader = By.xpath("//p[@class='bg-secondary text-white']");
	By operationstack=By.xpath("//a[contains(text(),'Operations in Stack')]");
	By implementation=By.xpath("//a[contains(text(),'Implementation')]");
	By applications=By.xpath("//a[contains(text(),'Applications')]");
	By pracquest=By.xpath("//a[contains(text(),'Practice Questions')]");
	By tryHereBtn=By.xpath ("//a[text()='Try here>>>']");
	By btnTryHereStackLinkPage = By.xpath("//a[normalize-space()='Try here>>>']");
	
	// Constructor
		public StackPage(WebDriver driver)
	    {
	        this.driver = driver;
	    }
		 // ---------------- Actions ----------------

	    public boolean isOnStackPage() {
	       // return driver.getCurrentUrl().contains("stack");
	        return driver.getTitle().equalsIgnoreCase("stack");
	    }
	    
	    public boolean isStackHeaderVisible() {
			
			  return driver.findElement(pageHeader).isDisplayed();
		}
	    
	    public boolean isTopicsCoveredHeaderForStackVisible() {
	    	
	    	return driver.findElement(topicsCoveredHeader).isDisplayed();
		}
	   
	    public boolean isTryHereVisible() {
	        return driver.findElement(tryHereBtn).isDisplayed();
	    }

	    public String getTopicHeader() {
	        return driver.findElement(pageHeader).getText();
	    }

	    public boolean isUrlContains(String text) {
	        return driver.getCurrentUrl().contains(text.replace(" ", "").toLowerCase());
	    }
	    
	    public boolean isOperationsInStackDisplayed() {
	    	return driver.findElement(operationstack).isDisplayed();
		}

		public boolean isImplementationDisplayed() {
		 	return driver.findElement(implementation).isDisplayed();
		}

		public boolean IsApplicationsDisplayed() {
		 	return driver.findElement(applications).isDisplayed();
		}
	    

// ================== Actions ===========================================================

		void clickStack()
		{
			driver.findElement(pageHeader).click();
		}	

		public void clickOperations()
		{
			driver.findElement(operationstack).click();
			clickTryHere();
		}
		public void clickImplementation()
		{
			driver.findElement(implementation).click();
			clickTryHere();
		}
		public void clickApplications()
		{
			driver.findElement(applications).click();
			clickTryHere();
		}		
		 
		public void clickTryHere() 
		 {
		        driver.findElement(tryHereBtn).click();
		    }

		public String getStackPageURL() {
			return driver.getCurrentUrl();
		}

		public void clickTryHereInStackLinkPage() {
			driver.findElement(btnTryHereStackLinkPage).click();
		}

		

		
		
}

