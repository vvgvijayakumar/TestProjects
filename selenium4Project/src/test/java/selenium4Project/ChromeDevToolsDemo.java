package selenium4Project;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.devtools.DevTools;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDevToolsDemo {

	WebDriver driver;

	public void enableNetworkOffline() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		//DevTools devtools = ((ChromiumDriver) driver).getDevTools();

		//devtools.createSession();

	}

}
