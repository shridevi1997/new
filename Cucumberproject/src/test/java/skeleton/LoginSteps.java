package skeleton;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginSteps {
	WebDriver driver;
	public LoginSteps() {
		// TODO Auto-generated constructor stub
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	
	@Given("the url of the login for demo web shop {string}")
	public void the_url_of_the_login_for_demo_web_shop(String url) {
	    // Write code here that turns the phrase above into concrete actions
	    driver.get(url);
	}

	@When("user enters {string} as email")
	public void user_enters_as_email(String email) {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(By.id("Email")).sendKeys(email);
	}

	@When("user enters {string} as password")
	public void user_enters_as_password(String password) {
	    // Write code here that turns the phrase above into concrete actions
	   driver.findElement(By.id("Password")).sendKeys(password);
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(By.cssSelector("input[value='Log in']")).click();
	}

	@Then("user is in shopping page")
	public void user_is_in_shopping_page() {
	    // Write code here that turns the phrase above into concrete actions
	  Assert.assertTrue(driver.findElement(By.linkText("Log out")).isDisplayed());
	  driver.findElement(By.linkText("Log out")).click();
	}

	
	@Then("not in login page")
	public void not_in_login_page() {
		
		 Assert.assertFalse(driver.findElement(By.linkText("Log out")).isDisplayed());
	    // Write code here that turns the phrase above into concrete actions   
	}	

}
