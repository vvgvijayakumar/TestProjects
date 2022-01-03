package fileUpload;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadFile {

	@Test
	public void uploadFile() throws AWTException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://monsterindia.com");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//span[contains(text(),'Upload Resume')]")).click();

		// driver.findElement(By.xpath("(//input[@id='file-upload'])[2]"))driver.findElement(By.xpath("(//input[@id='file-upload'])[2]")).sendKeys("C:\\Users\\vvijayak\\Downloads\\VinayResume.docx");

		WebElement element = driver.findElement(By.xpath("(//input[@id='file-upload'])[2]"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);

		Robot robot = new Robot();
		robot.delay(2000);

		StringSelection ss = new StringSelection("C:\\Users\\vvijayak\\Downloads\\VinayResume.docx");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		//Ctrl+V
		robot.keyPress(KeyEvent.VK_CONTROL); //Press on Control key
		robot.keyPress(KeyEvent.VK_V);
		
		robot.keyRelease(KeyEvent.VK_CONTROL);//Release key
		robot.keyRelease(KeyEvent.VK_V);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

}
