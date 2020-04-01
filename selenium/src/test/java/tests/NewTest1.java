package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest1 {
	
	WebDriver driver;
	
	@BeforeTest 
	public void beforetest()
	{
		//some initializations browser, url
				System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
				driver=new ChromeDriver();                                                   //2
				driver.get("http://demowebshop.tricentis.com/");
				driver.manage().window().maximize();
			    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);               //1
			  
	}
	
	@AfterTest 
	public void aftertest()
	{
		//driver.close();	
	}
	
	@Test(priority=1)
	public void testLoginlink()
	{
	   driver.findElement(By.linkText("Log in")).click();	
	   Assert.assertEquals(driver.getTitle(),"Demo Web Shop. Login");
	   
	}
	@Test(priority=2)
	public void testLoginbutton()
	{
	    driver.findElement(By.id("Email")).sendKeys("askmail@email.com");
	    driver.findElement(By.id("Password")).sendKeys("abc123");
	    driver.findElement(By.cssSelector("input[value='Log in']")).click();
		boolean flag=driver.findElement(By.linkText("Log out")).isDisplayed();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void testLogout()
	{
		driver.findElement(By.linkText("Log out")).click();
		boolean flag=driver.findElement(By.linkText("Log in")).isDisplayed();
		Assert.assertTrue(flag);
	}

}
