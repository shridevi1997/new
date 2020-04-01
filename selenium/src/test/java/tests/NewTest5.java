package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest5 {
	WebDriver driver;
	@BeforeTest
	public void beforeTest()
	{
		System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.cleartrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	@AfterTest
	public void afterTest()
	{

		//driver.close();
	}
	
	@Test
	public void testCities() throws InterruptedException
	{
		Thread.sleep(5000);
		
		WebElement fromCity=driver.findElement(By.id("FromTag"));
		
		Actions act=new Actions(driver);
		act.keyDown(fromCity, Keys.SHIFT).sendKeys(fromCity, "hyd").pause(7000).sendKeys(Keys.ENTER).perform();
		
		
		
		WebElement toCity=driver.findElement(By.id("ToTag"));
		
		//try to select bangkok city when you type ban in the to city
		Actions acts=new Actions(driver);
		act.keyDown(toCity, Keys.SHIFT).sendKeys(toCity, "bangk").pause(7000).sendKeys(Keys.ENTER).perform();
		
		
		
	}

}

