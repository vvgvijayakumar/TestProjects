package selenium4Project;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Selenium4Features {

	@Test(priority = 1)
	public void ScreenShotTest() throws IOException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver;

		driver = new ChromeDriver();

		driver.get("https://www.facebook.com");

		driver.manage().window().maximize();

		WebElement element = driver.findElement(By.xpath("//img[@class='fb_logo _8ilh img']"));

		File file = element.getScreenshotAs(OutputType.FILE);

		File destFile = new File("logo.png");

		FileUtils.copyFile(file, destFile);

		driver.quit();

	}

	@Test(priority = 0)
	public void openNewTab() {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.com");

		driver.switchTo().newWindow(WindowType.TAB);

		driver.navigate().to("https://www.facebook.com");

		driver.quit();

	}

	@Test(priority = 2)
	public void openNewWindow() {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.com");

		driver.switchTo().newWindow(WindowType.WINDOW);

		driver.navigate().to("https://www.facebook.com");

		driver.quit();

	}

	@Test(priority = 4)
	public void Location() throws IOException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver;

		driver = new ChromeDriver();

		driver.get("https://www.facebook.com");

		driver.manage().window().maximize();

		WebElement element = driver.findElement(By.xpath("//img[@class='fb_logo _8ilh img']"));

		System.out.println(element.getRect().getDimension().getHeight());
		
		System.out.println(element.getRect().getDimension().getWidth());
		
		System.out.println(element.getRect().getX());
		
		System.out.println(element.getRect().getY());

		driver.quit();

	}

}
