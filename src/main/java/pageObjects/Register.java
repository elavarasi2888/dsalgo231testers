package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Register {
	  WebDriver driver = new ChromeDriver();
	    By userTxt = By.name("username");
	    By passwordTxt = By.name("password1");
	    By confirmPasswrdTxt = By.name("password2");
	    By registerBtn = By.xpath("//input[@type='submit']");
	    By loginLink = By.xpath("//a[normalize-space()='Login']");
	    By registerLink = By.xpath("//a[normalize-space()='Register']");
	    By signInLink = By.xpath("//a[normalize-space()='Sign in']");
	    
	    public void enterCredentials(String userName, String passWord,String passwordConfirmation) {
	    	  driver.findElement(userTxt).sendKeys(userName);
		      driver.findElement(passwordTxt).sendKeys(passWord);
		      driver.findElement(confirmPasswrdTxt).sendKeys(passwordConfirmation);
	    }

	    public void empty_Data(){
	     

	    }
	    
	    public void registerBtn() {
	    	driver.findElement(registerBtn).click();
	    }

}
