package tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class case_dup {

	public static WebDriver driver;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://lkmdemoaut.accenture.com/TestMeApp/login.htm");

	}

	@Test(priority = 0, enabled = true)
	public void LoginTestme() throws InterruptedException {
		driver.findElement(By.id("userName")).sendKeys("Lalitha");
		driver.findElement(By.id("password")).sendKeys("Password123");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}

	@Test(priority = 1, enabled = true)
	public void selectProduct() {

		driver.findElement(By.xpath("//span[contains(text(),'Categories')]")).click();
		driver.findElement(By.xpath("//span[text()='Electronics']")).click();
		driver.findElement(By.xpath("//span[text()='Head Phone']")).click();
		driver.findElement(By.xpath("//a[@class='btn btn-success btn-product']")).click();

	}

	@Test(priority = 2, enabled = true)
	public void addToCart() throws InterruptedException {

		driver.findElement(By.xpath("//a[contains(text(),'Cart')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Checkout ')]")).click();
		String tx = driver.findElement(By.id("demo")).getText();
		if (tx.contains("Review")) {
			driver.findElement(By.xpath("//input[@id='choice-dollar']")).click();
			driver.findElement(By.id("add2")).sendKeys("Bengalore");
		} else {
			System.out.println("We are not in teh payment page, so please check on it error");
			signOut();
		}
	}

	@Test(priority = 3, enabled = true)
	public void payment() {
		driver.findElement(By.xpath("//input[@value='Proceed to Pay']")).click();
		driver.findElement(By.xpath("//input[@value='Andhra Bank']//following::i[1]")).click();
		driver.findElement(By.id("btn")).click();

		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Pass@456");
		driver.findElement(By.xpath("//input[@value='LOGIN']")).click();

		driver.findElement(By.xpath("//input[@name='transpwd']")).sendKeys("Trans@456");
		driver.findElement(By.xpath("//input[@value='PayNow']")).click();
	}

	@Test(priority = 4, enabled = true)
	public void getDataFromTable()

	{

		WebElement ordertable = driver.findElement(By.xpath("//table[@class='table']"));

		List<WebElement> rows = ordertable.findElements(By.tagName("tr"));

		System.out.println(rows.size());

		for (int i = 0; i < rows.size(); i++)

		{

			List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));

			for (int j = 0; j < cols.size(); j++)

			{

				System.out.println(cols.get(j).getText());

			}

		}

	}

	@Test(priority = 5, enabled = true)
	public void signOut() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//i[@class='fa fa-lock']")).click();
	}

	@AfterClass
	public void closeIt() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

}
