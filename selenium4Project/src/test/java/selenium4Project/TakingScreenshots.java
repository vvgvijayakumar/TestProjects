package selenium4Project;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakingScreenshots {

	WebDriver driver;

	@Test(description = "Taking screenshot of entire page")
	public void takesScreenshot() throws IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();

		TakesScreenshot ts = (TakesScreenshot) driver;

		File file = ts.getScreenshotAs(OutputType.FILE);

		File destFile = new File("homepage.png");

		FileUtils.copyFile(file, destFile);

		driver.quit();

	}

	@Test(description = "Taking screenshot of section of a page")
	public void takesScreenshotsectipn() throws IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();

		WebElement element = driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));

		File src = element.getScreenshotAs(OutputType.FILE);

		File destFile = new File("prodfeatures.png");

		FileUtils.copyFile(src, destFile);

		driver.quit();
	}

}
