package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StackPage {
	WebDriver driver;

	
	
	By stackink=By.linkText("Stack");
	By operationstack=By.xpath("//a[contains(text(),'Operations in Stack')]");
	By implementation=By.xpath("//a[contains(text(),'Implementation')]");
	By applications=By.xpath("//a[contains(text(),'Applications')]");
	By pracquest=By.xpath("//a[contains(text(),'Practice Questions')]");
	By tryHereBtn=By.xpath ("//a[contains(text(),'Try Here')]");

	// Constructor
		public StackPage(WebDriver driver)
	    {
	        this.driver = driver;
	    }
		
		void clickStack()
		{
			driver.findElement(stackink).click();
		}	

		void clickOperations()
		{
			driver.findElement(operationstack).click();
			clickTryHere();
		}
		void clickImplementation()
		{
			driver.findElement(implementation).click();
			clickTryHere();
		}
		void clickApplications()
		{
			driver.findElement(applications).click();
			clickTryHere();
		}
		public void clickTryHere() 
		{
			driver.findElement(tryHereBtn).click();
		}
}
