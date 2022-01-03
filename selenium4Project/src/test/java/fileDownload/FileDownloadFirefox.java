package fileDownload;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.Test;

public class FileDownloadFirefox {

	@Test
	public void fileDownload() throws InterruptedException {

		System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");

		WebDriver driver;

		// Creating Browser Profile for firefox
		FirefoxProfile profile = new FirefoxProfile();

		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/plain");// setting MIME Types

		// profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
		// "application/zip");// for downloading zip type

		// profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
		// "application/pdf");// for downloading pdf type

		profile.setPreference("browser.download.manager.showWhenStarting", false);

		FirefoxOptions option = new FirefoxOptions();

		option.setProfile(profile);

		driver = new FirefoxDriver(option);

		driver.get("http://demo.automationtesting.in/FileDownload.html");

		driver.manage().window().maximize();

		driver.findElement(By.id("textbox")).sendKeys("Testing1");

		WebElement element = driver.findElement(By.id("createTxt"));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

		element.click();// generate the Text File

		driver.findElement(By.id("link-to-download")).click();// display download and click

		Thread.sleep(5000);

	}

}
