package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GraphPage {
	private WebDriver driver;
	By headerGraph = By.xpath("//h4[normalize-space()='Graph']");
	By headerTopics = By.xpath("//p[@class='bg-secondary text-white']");
	By topicsLink  = By.xpath("//a[@class='list-group-item']");
	By verifyLinksHeader = By.xpath("//div[@class='col-sm']//strong//p");
	By tryHereBtn = By.xpath("//a[normalize-space()='Try here>>>']");
	
	public GraphPage(WebDriver driver){
		this.driver = driver;
	}
	/*
	 * public void clickGetStarted(String dsType) {
	 * 
	 * String xpathDef = "//a[@href='" + dsType + "']";
	 * 
	 * By getStartedBtn = By.xpath(xpathDef);
	 * driver.findElement(getStartedBtn).click(); }
	 */
	
	public boolean HeaderTitleVisible() {
		return  driver.findElement(headerGraph).isDisplayed();
		
	}
	public boolean TopicHeaderVisible() {
		return  driver.findElement(headerTopics).isDisplayed();
		
	}
	public List<String> TopicsGraphVisible() {
		List<WebElement> topicsName = driver.findElements(topicsLink);
		ArrayList<String> topic = new ArrayList<>();
		for (WebElement link : topicsName) {
			topic.add(link.getText().trim());
		}
		return topic;

	}
	public void clickTopicLink(String linksName) {
		List<WebElement> topicsName = driver.findElements(topicsLink);

		for (WebElement link : topicsName) {
			if (link.getText().trim().equalsIgnoreCase(linksName)) {
				link.click();
				return;
			}
		}
	}
	public String getHeaderForLinks() {
		String timeComplexityH = driver.findElement(verifyLinksHeader).getText();
		return timeComplexityH;

	}
	public boolean tryHereBtn() {
		return driver.findElement(tryHereBtn).isDisplayed();
		
		
	}
	public void tryHereBtnForLinks() {
		 driver.findElement(tryHereBtn).click();
		
	}

	public String getGraphPageURL() {
		
		return driver.getCurrentUrl();
	}
}
