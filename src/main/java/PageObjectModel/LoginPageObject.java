package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObject 
{
	public WebDriver driver;
	private By loginemail=By.xpath("//input[@id='input-email']");
	private By password=By.xpath("//input[@type='password']");
	private By loginbutton=By.xpath("//input[@type='submit']");

	public LoginPageObject(WebDriver driver3)
	{
		this.driver=driver3;
	}
	public WebElement enteremail1()
	{
		return driver.findElement(loginemail);
	}
	public WebElement enterpassword()
	{
		return driver.findElement(password);
	}
	public WebElement enterloginbutton()
	{
		return driver.findElement(loginbutton);
	}
}
