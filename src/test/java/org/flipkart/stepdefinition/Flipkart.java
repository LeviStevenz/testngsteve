package org.flipkart.stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkart {
	
	static WebDriver driver ;
	static long bef ;
	
	@BeforeClass (groups = "default")
	public static void beforeClass() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com");
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);	
	}
	
	
	@BeforeMethod (groups = "default")
	public void beforeTime() {
		bef = System.currentTimeMillis();
		System.out.println(bef);	
	}
	@AfterMethod (groups = "default")
	public void afterTime() {
	long aft = System.currentTimeMillis();
	System.out.println("TIME TAKEN :" + (aft - bef));
	}

	@Test (priority = 1 , groups = "sanity")
	public void button () {
		driver.findElement(By.xpath("//button[text()='✕']")).click();
	}
	
	@Test (priority = 2 , groups = "sanity")
	public void search () {
		WebElement find = driver.findElement(By.xpath("//input[@name='q']"));
		find.sendKeys("Maisto", Keys.ENTER);
	}
	
	@Test (priority = 3 , groups = "sanity")
	public void home () {
		driver.findElement(By.xpath("//div[@class='_3qX0zy']")).click();
	}
	
	@Test (priority = 4 , enabled = false)
	public void hover () {
	WebElement b = driver.findElement(By.xpath("//div[text()='Fashion']"));
	Actions a = new Actions(driver);
	a.moveToElement(b);
	}
	
	@Test(priority = 5 ,enabled = false )
	public void hover2 () {
	WebElement c = driver.findElement(By.xpath("//span[text()='more in Men's Bottom Wear']"));
	Actions v = new Actions(driver);
	v.moveToElement(c);
	}
	
	@Test (priority = 6 , enabled = false)
	public void fetch() {
		WebElement g = driver.findElement(By.xpath("text(),'Men's Jeans']"));
		Actions x = new Actions(driver);
		x.moveToElement(g);
		g.click();
	}
	
	
	
	
		
	
}

