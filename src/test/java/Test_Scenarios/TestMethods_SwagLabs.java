package Test_Scenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import objects.SauceLab;


public class TestMethods_SwagLabs {
	
	WebDriver driver;
	
	@BeforeTest
	public void beforetest()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		
		driver.get("https://www.saucedemo.com/");
		
	}
	
	@Test(priority = 0)
	public void LoginToSwagLabs() {
		
		SauceLab lab = new SauceLab(driver);
		lab.swagLabsLogin();
		lab.filterbyvalue("Price (high to low)");
		lab.addBackPackToCart();
		lab.CheckOut();
		lab.AddressDetailsandPlaceOrder();
		
	}
	
	@AfterTest
	public void afterTest()
	{
		driver.quit();
	}

}
