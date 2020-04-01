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

public class casestudy1 {
WebDriver driver;

@BeforeTest
public void beforeTest()
{

System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
driver=new ChromeDriver();
driver.get("https://lkmdemoaut.accenture.com/TestMeApp/fetchcat.htm");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
}
@AfterTest
public void afterTest()
{

//driver.close();
}
@Test(priority=1)
public void testRegistration()
{

	driver.findElement(By.linkText("SignUp")).click();
	driver.findElement(By.id("userName")).sendKeys("pragnyapbiswal@gmail.com");
	driver.findElement(By.id("firstName")).sendKeys("pragnya");
	driver.findElement(By.id("lastName")).sendKeys("biswal");
	driver.findElement(By.id("password")).sendKeys("lori1234");
	driver.findElement(By.id("pass_confirmation")).sendKeys("lori1234");
	driver.findElement(By.xpath("//input[@value='Female']")).click();
	driver.findElement(By.id("emailAddress")).sendKeys("pragnyapbiswal@gmail.com");
	driver.findElement(By.id("mobileNumber")).sendKeys("9438177253");
	driver.findElement(By.id("dob")).sendKeys("12/04/1997");
	driver.findElement(By.id("address")).sendKeys("Rasulgarh,G.G.P Colony,Bhubaneswar");
	driver.findElement(By.id("securityQuestion")).sendKeys("411011");
	driver.findElement(By.id("answer")).sendKeys("black");
	driver.findElement(By.xpath("//input[@name='Submit']")).click();
	String title1=driver.getTitle();
	Assert.assertEquals(title1, "Login");
	}

@Test(priority=2)
public void testLogin()
{
	driver.findElement(By.id("userName")).sendKeys("Lalitha");
	driver.findElement(By.id("password")).sendKeys("Password123");
	driver.findElement(By.xpath("//input[@name='Login']")).click();
	String title2=driver.getTitle();
	Assert.assertEquals(title2, "Home");
}
@Test(priority=3)
public void testItemSelection()
{
	
	driver.findElement(By.id("myInput")).sendKeys("Headphone");
	driver.findElement(By.xpath(".//Input[@Value='FIND DETAILS']")).click();
	driver.findElement(By.className("btn")).click();
}
@Test(priority=4)
public void testpayment() 
{
	
	
	
	
	
	
}




}
