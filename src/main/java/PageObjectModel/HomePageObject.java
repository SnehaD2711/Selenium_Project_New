package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageObject {

	private By myaccount = By.xpath("//i[@class='fa fa-user']");
	private By register = By.xpath("//a[contains(text(),'Register')]");
	private By login = By.xpath("//a[contains(text(),'Login')]");
	private WebDriver driver;

	// a[contains(text(),'Register')]

	public HomePageObject(WebDriver driver2) 
	{
		this.driver = driver2;
	}

	public WebElement clickonMyAccount() {

		return driver.findElement(myaccount);
	}

	public WebElement clickonregister() {

		return driver.findElement(register);
	}

	public WebElement clickonLogin() {

		return driver.findElement(login);
	}
}
