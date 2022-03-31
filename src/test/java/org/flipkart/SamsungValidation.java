package org.flipkart;

import java.io.File;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SamsungValidation {
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
		WebElement search = driver.findElement(By.xpath("//input[@name='q']"));
		search.sendKeys("SAMSUNG",Keys.ENTER);
	}
	
	@Test
	public void Script3() {
		WebElement Model1 = driver.findElement(By.xpath("(//div[@class='_4rR01T'])[5]"));
	    mobname = Model1.getText();
	    System.out.println(mobname);
	    Model1.click();
	}
	
	@Test
	public void Script4() {
		String parent = driver.getWindowHandle();
		Set<String> child = driver.getWindowHandles();
		
		for (String x : child) {
			if(!parent.equals(child)) {
				driver.switchTo().window(x);
			}
			
		}
	}
	
	@Test
	public void Script5() throws Exception {
		TakesScreenshot t = (TakesScreenshot)driver ;
		File source = t.getScreenshotAs(OutputType.FILE);
		File Target = new File("C:\\Users\\HP\\eclipse-workspace\\SteveFramework\\Screenshot\\Samsung.png");
		FileUtils.copyFile(source, Target);
	   
}
	
	@Test
	public void Script6() {
		WebElement validatename = driver.findElement(By.xpath("(//span[contains(text(),'SAMSUNG')])[1]"));
		
		Assert.assertTrue(validatename.isDisplayed());
	    String txt = validatename.getText();
	    System.out.println(txt);
	    
	    if (mobname.equalsIgnoreCase(txt)) {
	    	System.out.println("VERFIED");
	    } else {
	    	System.out.println("VERIFICATION FAILED");
	    }
	    
	    Assert.assertEquals(mobname, txt);
	}
	
	
	
	
	
	
}

