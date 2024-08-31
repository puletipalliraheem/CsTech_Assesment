package Testcase;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class TestCase01 
{
	@Test
	public void Test_In_Firefox1() throws Exception
	{
		System.setProperty("webdriver.gecko.driver","./software/geckodriver.exe");
		FirefoxOptions opt = new FirefoxOptions();
		opt.addArguments("--disable-notifications");
		WebDriver driver=new FirefoxDriver(opt);
		driver.manage().window().maximize();
		Dimension dim1=new Dimension(1366,768);
		driver.manage().window().setSize(dim1);
		String OS = System.getProperty("os.name");
		Capabilities cap=((RemoteWebDriver)driver).getCapabilities();
		String browserName=cap.getBrowserName();
		Date d=new Date();
		String d1=d.toString().replace(":","-");
		driver.get("https://www.getcalley.com/page-sitemap.xml");
		List<WebElement> links = driver.findElements(By.xpath("//a"));
		int count = links.size();
		System.out.println("Total count is "+count);
		ArrayList<String> list = new ArrayList<String>();
		for(int i =3;i<=7;i++)
		{
			WebElement link = links.get(i);
			String url = link.getAttribute("href");
		list.add(url);
		}
		System.out.println("Size of array created " +list.size());
		
		for(int i=0;i<=4;i++)
		{
		driver.navigate().to(list.get(i));
		System.out.println( driver.getCurrentUrl());
		Thread.sleep(2000);
		TakesScreenshot ts=(TakesScreenshot)driver;
		System.out.println("Captured the ss of "+i);
		Thread.sleep(2000);
		File temp=ts.getScreenshotAs(OutputType.FILE);
		File perm=new File("./Firefox-photos/"+OS+" "+browserName+" "+dim1+" "+i+" "+d1+".png");
		FileHandler.copy(temp, perm);
		}
		driver.quit();
	}
	@Test
	public void Test_In_Chrome() throws Exception
	{
		System.setProperty("webdriver.chrome.driver","./software/chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(opt);
		driver.manage().window().maximize();
		Dimension dim1=new Dimension(1536,864);
		driver.manage().window().setSize(dim1);
		String OS = System.getProperty("os.name");
		Capabilities cap=((RemoteWebDriver)driver).getCapabilities();
		String browserName=cap.getBrowserName();
		Date d=new Date();
		String d1=d.toString().replace(":","-");
		driver.get("https://www.getcalley.com/page-sitemap.xml");
		List<WebElement> links = driver.findElements(By.xpath("//a"));
		int count = links.size();
		System.out.println("Total count is "+count);
		ArrayList<String> list = new ArrayList<String>();
		for(int i =3;i<=7;i++)
		{
			WebElement link = links.get(i);
			String url = link.getAttribute("href");
		list.add(url);
		}
		System.out.println("Size of array created " +list.size());
		
		for(int i=0;i<=4;i++)
		{
		driver.navigate().to(list.get(i));
		System.out.println( driver.getCurrentUrl());
		Thread.sleep(2000);
		TakesScreenshot ts=(TakesScreenshot)driver;
		System.out.println("Captured the ss of "+i);
		Thread.sleep(2000);
		File temp=ts.getScreenshotAs(OutputType.FILE);
		File perm=new File("./Chrome--photos/"+OS+" "+browserName+" "+dim1+" "+i+" "+d1+".png");
		FileHandler.copy(temp, perm);
		}
		driver.quit();
	}



}
