package encodedecode;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginEncodeTest {

	@Test
	public void loginTest() {

		WebDriver driver;

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.get("https://demo.nopcommerce.com");

		driver.findElement(By.linkText("Log in")).click();

		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("pavanoltraining@gmail.com");

		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(decodeString("dGVzdDEyMw=="));

		driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();

	}

	String decodeString(String password) {
		byte[] decdString = Base64.decodeBase64(password);
		return new String(decdString);

	}

}
