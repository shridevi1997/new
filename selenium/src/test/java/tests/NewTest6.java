package tests;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest6 {
	WebDriver driver;
	@BeforeTest
	public void beforeTest()
	{
		System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://lkmdemoaut.accenture.com/TestMeApp/fetchcat.htm");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	@AfterTest
	public void afterTest()
	{

		//driver.close();//close the current window.
		driver.quit();//close all the windows
	}
	
	@Test
	public void testOurOffices() throws InterruptedException
	{
		WebElement about=driver.findElement(By.partialLinkText("AboutUs"));	
		Actions act=new Actions(driver);
		act.moveToElement(about).pause(2000).perform();
		act.moveToElement(driver.findElement(By.partialLinkText("Offices"))).perform();
		act.click(driver.findElement(By.partialLinkText("Bangalore"))).perform();
		
		String homewindow=driver.getWindowHandle();// the current window instance 
		Set<String> windows=driver.getWindowHandles();//all the window instances
		
		
		Object[] windowRef=windows.toArray();
		
		//driver.switchTo().window(homewindow);
		//driver.switchTo().window(windowRef[0].toString());
		driver.switchTo().window(windowRef[1].toString());
		
		
		driver.switchTo().frame(driver.findElement(By.name("main_page")));
		
		
		String address=driver.findElement(By.id("demo3")).getText();
		System.out.println(address);
		
		Assert.assertTrue(address.contains("Bangalore"));
		Thread.sleep(3000);
		driver.switchTo().window(homewindow);
		Thread.sleep(3000);
	}

}
