package brokenlinks;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {

	@Test
	public void brokenLinks() throws InterruptedException, IOException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("http://newtours.demoaut.com");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.manage().window().maximize();

		Thread.sleep(5000);

		List<WebElement> links = driver.findElements(By.tagName("a"));

		System.out.println(links.size());

		for (int i = 0; i < links.size(); i++) {

			// By using href attribute we can get URL of required link
			WebElement element = links.get(i);
			String url = element.getAttribute("href");

			URL link = new URL(url);

			// create a connection using url object 'link'
			HttpURLConnection conn = (HttpURLConnection) link.openConnection();

			Thread.sleep(2000);
			// establish connection
			conn.connect();

			// If response code is greater than 400 then i.e is a broken link
			int response_code = conn.getResponseCode();

			if (response_code >= 400) {
				System.out.println("It is a broken link" + response_code);
			} else {
				System.out.println("It is not a broken link" + response_code);
			}

		}

	}

}
