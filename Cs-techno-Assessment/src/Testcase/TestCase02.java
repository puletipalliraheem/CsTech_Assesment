package Testcase;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class TestCase02
{
	public static void main(String[] args) throws Throwable
	{
		System.setProperty("webdriver.gecko.driver","./software/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		TakesScreenshot ts = (TakesScreenshot)driver;
		driver.get("https://demo.dealsdray.com");
		WebElement usn = driver.findElement(By.xpath("//input[@name='username']"));
		usn.sendKeys("prexo.mis@dealsdray.com");
		Thread.sleep(1000);
		WebElement psw = driver.findElement(By.xpath("//input[@name='password']"));
		psw.sendKeys("prexo.mis@dealsdray.com");
		WebElement lgn_btn = driver.findElement(By.xpath("//button[@type='submit']"));
		lgn_btn.click();
		WebElement Order = driver.findElement(By.xpath("//span[text()='Order']"));
		Order.click();
		WebElement Orders = driver.findElement(By.xpath("//span[text()='Orders']"));
		Orders.click();
		WebElement Add_Order = driver.findElement(By.xpath("//button[text()='Add Bulk Orders']"));
		Add_Order.click();
		
		WebElement chooseFile = driver.findElement(By.xpath("//input[@type='file']"));
		chooseFile.sendKeys("C:\\Users\\User\\OneDrive\\Documents\\demo-data.xlsx");
		WebElement Import = driver.findElement(By.xpath("//button[text()='Import']"));
		Import.click();
		
		WebElement validate = driver.findElement(By.xpath("//button[text()='Validate Data']"));
		validate.click();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		WebElement ele = driver.findElement(By.xpath("//button[text()='Previous']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",ele);
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File perm = new File("./Testcase2/Image.png");
		FileHandler.copy(temp, perm);
		driver.quit();
		
	}
}
