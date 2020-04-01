
	package tests;

	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.testng.Assert;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

	public class NewTest3 {
		WebDriver driver;
		@BeforeTest
		public void beforeTest()
		{
			System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
			driver=new ChromeDriver();
			driver.get("http://hdfcbank.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		}
		@AfterTest
		public void afterTest()
		{
			//driver.close();
		}
		
		@Test
		public void testLinks()
		{
			//driver.findElement(By.cssSelector("a[href='/personal/pay/cards/credit-cards']")).click();
			//driver.findElement(By.partialLinkText("Credit Cards")).click();
			Actions act=new Actions(driver);
			act.moveToElement(driver.findElement(By.partialLinkText("PAY"))).pause(3000).
			moveToElement(driver.findElement(By.xpath("//a[@href='/personal/pay/cards/credit-cards']"))).click().perform();
			String title=driver.getTitle();
			Assert.assertTrue(title.startsWith("Credit Card"));	
		}

	}

	
	

