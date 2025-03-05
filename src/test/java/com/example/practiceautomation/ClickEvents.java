package com.example.practiceautomation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.exemple.practiceautomation.po.ClickEventsPage;

public class ClickEvents {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	JavascriptExecutor js;
	ClickEventsPage ClickEventsPage;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		ClickEventsPage = new ClickEventsPage(driver);
		baseUrl = "https://www.google.com/";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		js = (JavascriptExecutor) driver;
	}
	
         //Test Script Linaire
	//@Test
	  public void testClickEvents() throws Exception {
  
		driver.get("https://practice-automation.com/click-events/");
		  
 
		//driver.findElement(By.linkText("Click Events")).click();
		
		    try {
		    	 WebElement element=driver.findElement(By.xpath("//div[@id='top-wrap']/section/div/h1"));
		    	 assertEquals("Click Events",element.getText());
		    	
		    	element=driver.findElement(By.xpath("//a[normalize-space()='Home']"));
		        assertEquals("Home", driver.findElement(By.linkText("Home")).getText());
		        
		    driver.findElement(By.xpath("//article[@id='post-3145']/div/div[3]/div/div/div/div/button/b")).click();
		    element=driver.findElement(By.id("demo"));
		    assertEquals("Meow!", element.getText());
		    
		    driver.findElement(By.xpath("//button[@onclick='pigSound()']")).click();
		    element=driver.findElement(By.id("demo"));
		    assertEquals("Oink!", element.getText());
		    
		    driver.findElement(By.xpath("//article[@id='post-3145']/div/div[3]/div/div/div/div[2]/button/b")).click();
		    element=driver.findElement(By.id("demo"));
		    assertEquals("Woof!", element.getText());
		    
		   // driver.findElement(By.id("main")).click();
		    driver.findElement(By.xpath("//article[@id='post-3145']/div/div[5]/div[2]/button/b")).click();
		    element=driver.findElement(By.id("demo"));
		    assertEquals("Moo!",element.getText());
		    
		    } catch (Error e) {
		      verificationErrors.append(e.toString());
		    }
		  }
              
	

	 //TEST Script Structurel
	
	@Test
	public void testClickEvents1() throws Exception {

		driver.get("https://practice-automation.com/click-events/");
		try {
			
             ClickEventsPage.getCat().click();
             
			assertEquals("Meow!", ClickEventsPage.getTextDemo().getText());
			
			ClickEventsPage.getDog().click();
            
			assertEquals("Woof!", ClickEventsPage.getTextDemo().getText());
			
			ClickEventsPage.getPig().click();
            
			assertEquals("Oink!", ClickEventsPage.getTextDemo().getText());
			
			
			ClickEventsPage.getCow().click();
            
			assertEquals("Moo!", ClickEventsPage.getTextDemo().getText());
			
			ClickEventsPage.takeScreenShot("ClickEvents.jpg");
			
			ClickEventsPage.takeScreenShot("ClickEventstitle.jpg", ClickEventsPage.getHeadline());
			ClickEventsPage.takeScreenShot("imprimeEcran","ClickEventstitle.jpg", ClickEventsPage.getCow());

	
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}
