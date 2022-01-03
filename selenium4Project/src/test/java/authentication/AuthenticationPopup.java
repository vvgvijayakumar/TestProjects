package authentication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AuthenticationPopup {

	@Test
	public void authnPopup() {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("http:admin:admin@the-internet.herokuapp.com/basic_auth");

		// Injecting the username and password in the URL
		// http://username:password@test.com

		String text = driver.findElement(By.cssSelector("p")).getText();

		System.out.println(text);

	} 

}
