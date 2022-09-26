package objects;

import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;

public class GoogleSearchPage {
	
	WebDriver driver;
	public GoogleSearchPage(WebDriver driver)
	{
		this.driver=driver;
	}

	By searchBox = By.xpath("//input[@name='q']");
	By searchBtn = By.xpath("//input[@type='submit' and @name='btnK']");
	By facebook_Link = By.xpath("//a[contains(@href, 'https://www.facebook.com')][1]");
	
	
	public void serachgoogle(String searchText)
	{
		try 
		{
		driver.findElement(searchBox).sendKeys(searchText);
		Thread.sleep(5000);
		driver.findElement(searchBtn).click();
		Thread.sleep(5000);
		System.out.println("clicked on google search btn");
		}
		catch(Exception ex)
		{
			System.out.println("exception"+ ex.getMessage());
			
		}
	}
	
	public void clickFacebook()
	{
		try
		{
			driver.findElement(facebook_Link).click();
			System.out.println("clicked on facebook link");
			String title = driver.getTitle();
			assertEquals(title,"Facebook - log in or sign up");
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			System.out.println("exception"+ e.getMessage());
		}
	}
}
