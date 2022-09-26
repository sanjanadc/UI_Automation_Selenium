package Test_Scenarios;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.*;
import objects.GoogleSearchPage;


public class TestMethods_GoogleSearch {
	
	WebDriver driver;
	
	@BeforeTest
	public void beforetest()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		
		driver.get("https://www.google.com/");
		
	}
	
	@Test(priority = 0)
	public void searchOperations() {
		
		GoogleSearchPage page = new GoogleSearchPage(driver);
		page.serachgoogle("facebook");
		
	}
	
	@Test(priority = 1)
	public void clickFaceBook()
	{
		GoogleSearchPage fb = new GoogleSearchPage(driver);
		fb.clickFacebook();
	}
	
	@AfterTest
	public void afterTest()
	{
		driver.quit();
	}
	

}
