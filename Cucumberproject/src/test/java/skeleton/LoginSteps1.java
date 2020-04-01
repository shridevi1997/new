package skeleton;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginSteps1 {
	WebDriver driver;
	public LoginSteps1() {
		// TODO Auto-generated constructor stub
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		PageFactory.initElements(driver,DemoWebShopObjects.class);
	}
	
	@Given("the url of the login for demo web shop {string}")
	public void the_url_of_the_login_for_demo_web_shop(String url) {
	    // Write code here that turns the phrase above into concrete actions
	    driver.get(url);
	}

	@When("user enters {string} as email")
	public void user_enters_as_email(String email) {
	    // Write code here that turns the phrase above into concrete actions
	    //driver.findElement(By.id("Email")).sendKeys(email);
		DemoWebShopObjects.email.sendKeys(email);
	}

	@When("user enters {string} as password")
	public void user_enters_as_password(String password) {
	    // Write code here that turns the phrase above into concrete actions
	  // driver.findElement(By.id("Password")).sendKeys(password);
		DemoWebShopObjects.password.sendKeys(password);
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
	    // Write code here that turns the phrase above into concrete actions
	    //driver.findElement(By.cssSelector("input[value='Log in']")).click();
		DemoWebShopObjects.login.click();
	}

	@Then("user is in shopping page")
	public void user_is_in_shopping_page() {
	    // Write code here that turns the phrase above into concrete actions
	  Assert.assertTrue(DemoWebShopObjects.logout.isDisplayed());
	 // driver.findElement(By.linkText("Log out")).click();
	}

	
	@Then("not in login page")
	public void not_in_login_page() {
		
		 Assert.assertFalse(DemoWebShopObjects.logout.isDisplayed());
	    // Write code here that turns the phrase above into concrete actions   
	}	

}
