package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.*;


public class SauceLab {

	WebDriver driver;
	public SauceLab(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By username = By.id("user-name");
	By password = By.id("password");
	By loginbtn = By.id("login-button");
	By addbackpack = By.xpath("//*[text()='Sauce Labs Backpack']");
	By getbackpackprice = By.className("inventory_details_price");
	By addtocartbtn = By.id("add-to-cart-sauce-labs-backpack");
	By cart = By.className("shopping_cart_badge");
	By checkoutbtn = By.id("checkout");
	By firstname = By.id("first-name");
	By lastname = By.id("last-name");
	By zipcode = By.id("postal-code");
	By continuebtn = By.id("continue");
	By finishbtn = By.id("finish");
	By ordertextvalidation = By.xpath("//*[text()='THANK YOU FOR YOUR ORDER']");
	By filterdropdown = By.className("product_sort_container");
	
	
	public void swagLabsLogin()
	{
		try 
		{
		driver.findElement(username).sendKeys("standard_user");
		System.out.println("Entered username");
		driver.findElement(password).sendKeys("secret_sauce");
		System.out.println("Entered password");
		Thread.sleep(4000);
		driver.findElement(loginbtn).click();
		Thread.sleep(4000);
		System.out.println("Clicked on login button");
		}
		catch(Exception ex)
		{
			System.out.println("exception"+ ex.getMessage());
			throw new Error(ex);
			
		}
	}

	public void addBackPackToCart()
	{
		try
		{
			driver.findElement(addbackpack).click();
			Thread.sleep(4000);
			String price = driver.findElement(getbackpackprice).getText();
			assertEquals("$29.99",price);
			System.out.println("price matched successfully");
			driver.findElement(addtocartbtn).click();
			Thread.sleep(2000);
			System.out.println("clicked on add to cart button");
			
			
		}
		catch(Exception e)
		{
			System.out.println("exception"+ e.getMessage());
			throw new Error(e) ;
		}
	}
	
	public void CheckOut()

	{
		try
		{
			driver.findElement(cart).click();
			Thread.sleep(4000);
			System.out.println("clicked on cart button");
			driver.findElement(checkoutbtn).click();
			System.out.println("clicked on checkout button");
			
		}
		catch(Exception e)
		{
			System.out.println("exception"+ e.getMessage());
			throw new Error(e) ;
		}
	}
	
	public void AddressDetailsandPlaceOrder()

	{
		try
		{
			driver.findElement(firstname).sendKeys("John");
			Thread.sleep(2000);
			System.out.println("Entered first name");
			driver.findElement(lastname).sendKeys("Krisnski");
			System.out.println("Entered last name");
			driver.findElement(zipcode).sendKeys("95050");
			System.out.println("Entered Zip Code");
			Thread.sleep(2000);
			driver.findElement(continuebtn).click();			
			Thread.sleep(2000);
			driver.findElement(finishbtn).click();
			System.out.println("Clicked on finish button");
			String textmsg = driver.findElement(ordertextvalidation).getText();
			System.out.println(textmsg);
			assertEquals(textmsg,"THANK YOU FOR YOUR ORDER");
			Thread.sleep(4000);
			
			
		}
		catch(Exception e)
		{
			System.out.println("exception "+ e.getMessage());
			throw new Error(e) ;
		}
	}

	public void filterbyvalue(String value)
	{
		try {
		Select select =new Select(driver.findElement(filterdropdown));
		Thread.sleep(2000);
		select.selectByVisibleText(value);
		Thread.sleep(2000);
		}
		catch(Exception e)
		{
			System.out.println(e);
			throw new Error(e) ;
		}
	}
}
