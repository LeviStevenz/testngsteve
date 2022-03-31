package org.flipkart;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Hover {
	static WebDriver driver ;
	static long StartTime ;
	static long EndTime ;
	static String mobname ;
	
	@BeforeClass
	public static void beforeClass() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com");
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);	
	}
	
	@AfterClass
	public static void afterClass() {
		driver.close();
	}
	
	
	@Before
	public void before() {
		StartTime = System.currentTimeMillis();
	}
	

	@After
	public void after() {
		EndTime = System.currentTimeMillis();
		System.out.println("Time Taken - " + ( EndTime - StartTime));
	}
	
	@Test
	public void Script1() {
		driver.findElement(By.xpath("//button[text()='✕']")).click();
	}
	
	@Test
	public void Script2() {
		driver.findElement(By.xpath("//a[text()='Explore']")).click();
	}

	@Test
	public void Script3() {
		
		WebElement b = driver.findElement(By.xpath("//span[text()='TVs & Appliances']"));
		Actions a = new Actions(driver);
		a.moveToElement(b).perform();	
	}
	
	@Test
	public void Script4() {
		
		WebElement d = driver.findElement(By.xpath("//a[text()='Inverter AC']"));
		Actions c = new Actions(driver);
		c.moveToElement(d).perform();
		d.click();
	}
	
	@Test
	public void Script5() throws Exception {
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		TakesScreenshot t = (TakesScreenshot)driver;
		File source = t.getScreenshotAs(OutputType.FILE);
		File target = new File("C:\\Users\\HP\\eclipse-workspace\\Z.PracticeSelenium\\ScreenShot\\Hover_1.png");
		FileUtils.copyFile(source, target);
	} 
	











}
