package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest2 {
	
	WebDriver driver;
	
	@BeforeTest
	public void beforetest()
	{
		System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}

	@AfterTest
	public void aftertest()
	{
		driver.findElement(By.linkText("Log out")).click();
	//	driver.close();
		
	}
	@Test(priority=1)
	public void TestRegsitrationlink()
	{
		driver.findElement(By.linkText("Register")).click();
		String title=driver.getTitle();
		Assert.assertEquals(title,"Demo Web Shop. Register");	
	}
	@Test(priority=2)
	public void TestRegistrationButton()
	{
		driver.findElement(By.id("gender-male")).click();
		driver.findElement(By.id("FirstName")).sendKeys("akshata");
		driver.findElement(By.id("LastName")).sendKeys("gokak");
		driver.findElement(By.id("Email")).sendKeys("akshatagokak@yahoo.com");
		driver.findElement(By.id("Password")).sendKeys("aksh@123");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("aksh@123");
		driver.findElement(By.id("register-button")).click();
		String text=driver.findElement(By.className("result")).getText();
		Assert.assertEquals(text,"Your registration completed");
		//Assert.assertTrue(text.contains("completed"));
	}
}
	