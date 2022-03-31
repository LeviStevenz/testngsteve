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
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {
	
	static WebDriver driver ;
	static long StartTime ;
	static long EndTime ;
	static WebElement ref ;
	static TakesScreenshot t;

	@BeforeClass
	public static void beforeClass() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
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
	
	@Ignore
	@After
	public void after() {
		EndTime = System.currentTimeMillis();
		System.out.println("Time Taken - " + ( EndTime - StartTime));
	}
	
	@Test
	public void Script1() {
		ref = driver.findElement(By.xpath("//select"));
		ref.click();
}
	@Test
	public void Script2() throws Exception {
		t = (TakesScreenshot)driver ;
		File source = t.getScreenshotAs(OutputType.FILE);
		File Target = new File("C:\\Users\\HP\\eclipse-workspace\\SteveFramework\\Screenshot\\Drop.png");
		FileUtils.copyFile(source, Target);
	}
	
	@Test
	public void Script3() {
		Select s = new Select(ref);
		s.selectByVisibleText("Austria");
	}
		
	@Test
	public void Script4() throws Exception {
		t = (TakesScreenshot)driver ;
		File source1 = t.getScreenshotAs(OutputType.FILE);
		File Target1 = new File("C:\\Users\\HP\\eclipse-workspace\\SteveFramework\\Screenshot\\DropSelected.png");
		FileUtils.copyFile(source1, Target1);
	}
	
	

}

	
