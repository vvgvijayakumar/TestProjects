package fileDownload;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PathSpecificFileDownload {

	@Test
	public void fileDownload() throws InterruptedException {

		String location = System.getProperty("user.dir") + "\\downloads\\";

		/*
		 * Chrome HashMap preferances = new HashMap();
		 * preferances.put("download.default_directory", location);
		 * 
		 * ChromeOptions options = new ChromeOptions();
		 * options.setExperimentalOption("prefs", preferances);
		 */

		//Edge
		  HashMap preferances = new HashMap();
		  preferances.put("download.default_directory", location);
		  
		EdgeOptions options = new EdgeOptions();
		options.setExperimentalOption("prefs", preferances);
		 

		//WebDriverManager.chromedriver().setup();
		
		WebDriverManager.edgedriver().setup();

		WebDriver driver;

		//driver = new ChromeDriver(options);
		
		driver = new EdgeDriver(options);

		driver.get("https://file-examples.com/index.php/sample-documents-download/sample-doc-download/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.manage().window().maximize();

		WebElement element = driver.findElement(By.xpath("//input[@type='search']"));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

		driver.findElement(By.xpath("//td[@class='text-right file-link']//a")).click();

	}
}
