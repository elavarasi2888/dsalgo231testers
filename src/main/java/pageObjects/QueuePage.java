package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QueuePage {

	private WebDriver driver;

	public QueuePage(WebDriver driver) {

		this.driver = driver;
	}

	By headerQueue = By.xpath("//h4[normalize-space()='Queue']");
	By headerTopicsCoveredQueue = By.xpath("//p[@class='bg-secondary text-white']");
	By lnkQueueLinks = By.xpath("//a[@class='list-group-item']");

	public boolean isQueueHeaderVisible() {
		return driver.findElement(headerQueue).isDisplayed();
	}

	public boolean isTopicsCoveredHeaderQueueVisible() {
		return driver.findElement(headerTopicsCoveredQueue).isDisplayed();
	}

	public List<String> queueLinksVisible() {
		List<String> a = new ArrayList<>();
		List<WebElement> queueLinks = driver.findElements(lnkQueueLinks);
		for (WebElement q : queueLinks) {
			a.add(q.getText().toLowerCase());
		}
		return a;
	}

	public String getQueuePageURL() {
		// TODO Auto-generated method stub
		return null;
	}

}
