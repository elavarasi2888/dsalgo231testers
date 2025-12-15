package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class ArrayPage {
	WebDriver driver;
	By arraylink=By.linkText("Array");
	By arraysinpython=By.xpath("//a[contains(text(),'Arrays in Python')]");
	By arraysusinglist=By.xpath("//a[contains(text(),'Arrays Using List')]");
	By basicopeinlist=By.xpath("//a[contains(text(),'Basic Operations in Lists')]");
	By appofarray=By.xpath("//a[contains(text(),'Applications of Array')]");
	By pracquest=By.xpath("//a[contains(text(),'Practice Questions')]");
	By tryHereBtn=By.xpath ("//a[contains(text(),'Try Here')]");
	
	// Constructor
	public ArrayPage(WebDriver driver)
    {
        this.driver = driver;
    }
	void clickArray()
	{
		driver.findElement(arraylink).click();
	}
	void clickArraysinPython()
	{
		driver.findElement(arraysinpython).click();
		clickTryHere();
	}
	void clickArraysusingLists()
	{
		driver.findElement(arraysusinglist).click();
		clickTryHere();
	}
	void clickBasicOperationsLists()
	{
		driver.findElement(basicopeinlist).click();
		clickTryHere();
	}
	void clickApplicationsofArray()
	{
		driver.findElement(appofarray).click();
		clickTryHere();
	}
	

	public void clickTryHere() 
	{
		driver.findElement(tryHereBtn).click();
	}
}
