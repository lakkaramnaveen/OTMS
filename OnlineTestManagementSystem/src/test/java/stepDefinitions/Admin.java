package stepDefinitions;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Admin {
	
	WebDriver driver;
	
	@Given("^Admin is on user login page$")
	public void admin_is_on_user_login_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumCucumberSoftware\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:4200/login"); //open the website from url
		driver.manage().window().maximize();
		String expected_title = "OTMS";
		String actual_title = driver.getTitle();
		System.out.println(actual_title);
		assertEquals(expected_title,actual_title);
	}

	@When("^Admin enters username and password$")
	public void admin_enters_username_and_password() throws Throwable {
		driver.findElement(By.id("username")).sendKeys("rahul");//
		driver.findElement(By.name("password")).sendKeys("1234");//
	}

	@And("^Admin clicks on submit button and gets a alert$")
	public void admin_clicks_on_submit_button_and_gets_a_alert() throws Throwable {
		driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert(); //will switch 
		String actual = driver.switchTo().alert().getText();
		assertEquals("Login success", actual);
		alert.accept();
	}

	@Then("^Admin should see a message \"([^\"]*)\"$")
	public void admin_should_see_a_message(String arg1) throws Throwable {
			Thread.sleep(3000);
			String actual = driver.findElement(By.tagName("h1")).getText();
			assertEquals("Admin Login Successfull",actual);
			driver.findElement(By.xpath("//button[contains(text(),'Logout')]")).click();
			driver.close();
	}
}
