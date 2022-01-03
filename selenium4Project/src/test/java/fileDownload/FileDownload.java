package fileDownload;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileDownload {

	@Test
	public void fileDownload() throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver;

		driver = new ChromeDriver();

		driver.get("http://demo.automationtesting.in/FileDownload.html");

		driver.manage().window().maximize();

		driver.findElement(By.id("textbox")).sendKeys("Testing1");

		WebElement element = driver.findElement(By.id("createTxt"));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

		element.click();// generate the Text File

		driver.findElement(By.id("link-to-download")).click();// display download and click

		Thread.sleep(5000);

		driver.findElement(By.id("pdfbox")).sendKeys("Testing2");

		WebElement element1 = driver.findElement(By.id("createPdf"));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);

		element1.click();// generate the Text File

		driver.findElement(By.id("pdf-link-to-download")).click();// display download and click
		
		Thread.sleep(5000);

		driver.quit();

	}

}
