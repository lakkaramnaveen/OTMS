package stepDefinitions;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Login {

	WebDriver driver;

	@Given("^User is on user login page$")
	public void user_is_on_user_login_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumCucumberSoftware\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:4200/login"); //open the website from url
		driver.manage().window().maximize();
		String expected_title = "OTMS";
		String actual_title = driver.getTitle();
		System.out.println(actual_title);
		assertEquals(expected_title,actual_title);
	}

	@When("^User enters username and password$")
	public void user_enters_username_and_password() throws Throwable {
		driver.findElement(By.id("username")).sendKeys("tony");
		driver.findElement(By.name("password")).sendKeys("Tony@123");
	}

	@And("^User clicks on submit button$")
	public void user_clicks_on_submit_button() throws Throwable {
		driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
	}

	@Then("^User should see a message \"([^\"]*)\"$")
	public void user_should_see_a(String arg1) throws Throwable {
		Thread.sleep(3000);
		String actual = driver.findElement(By.tagName("h1")).getText();
		assertEquals("User Login Successfull",actual);
		driver.findElement(By.xpath("//button[contains(text(),'Logout')]")).click();
		driver.close();
	}
}
