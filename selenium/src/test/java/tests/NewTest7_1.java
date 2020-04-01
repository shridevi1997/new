package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NewTest7_1 {
	WebDriver driver;
	
	@BeforeTest
	public void beforeTest()
	{
		System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	@AfterTest
	public void afterTest()
	{
		//some cleaning closing browser,connections
		//driver.close();
	}
	@Test(dataProvider = "dp1",dataProviderClass = TestData.class)
	public void testLoginDDT(String email,String password)
	{
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.cssSelector("input[value='Log in']")).click();
		boolean flag=driver.findElement(By.linkText("Log out")).isDisplayed();
		Assert.assertTrue(flag);
		driver.findElement(By.linkText("Log out")).click();
	}
	
}

