package selenium4Project;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RelativeLocators {

	WebDriver driver;

	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://automationbookstore.dev/");
		driver.manage().window().maximize();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	// Test Book 5 which is left of Book 6 and below Book 1 in the URL

	@Test(description = "Test Book 5 which is left of Book 6 and below Book 1")
	public void test1() {

		WebElement book5 = driver
				.findElement(RelativeLocator.with(By.tagName("li")).toLeftOf(By.id("pid6")).below(By.id("pid1")));

		String id = book5.getAttribute("id");

		System.out.println(id);

	}

	@Test(description = "Test Book 2 which is right of Book 1 and above Book 6")
	public void test2() {

		WebElement book2 = driver
				.findElement(RelativeLocator.with(By.tagName("li")).toRightOf(By.id("pid1")).above(By.id("pid6")));

		String id = book2.getAttribute("id");

		System.out.println(id);

	}

}
