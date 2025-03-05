package com.example.practiceautomation;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
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
public class Popups {
	
	
	
	  private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  JavascriptExecutor js;
	private Alert alert;
	
	 
	 
	 
	  @Before
	  public void setUp() throws Exception {
		    System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
		    ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
		    baseUrl = "https://www.google.com/";
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		    js = (JavascriptExecutor) driver;
		  }
	  @Test
	  public void Popups() throws Exception {
		 
	    driver.get("https://practice-automation.com/popups/");
	   
	  
	    try {
	    	
	      WebElement element = driver.findElement(By.xpath("//div[@id='top-wrap']/section/div/h1"));
	      assertEquals("Popups", element.getText());
	  
	       element = driver.findElement(By.xpath("//a[normalize-space()='Home']"));
	      assertEquals("Home", element.getText());
	  
	   
	      element = driver.findElement(By.xpath("//a[normalize-space()='practice handling the different type of popups']"));
	      assertEquals("practice handling the different type of popups", element.getText());
	      
	    //popups alert
	      
	    element= driver.findElement(By.xpath("//button[@id='alert']/b"));
	    acceptNextAlert = true;
	    element.click();
	    String alertText = closeAlertAndGetItsText();
	    assertEquals("Hi there, pal!", alertText);
	   
	    //confirm popups
	    
	    element= driver.findElement(By.xpath("//b[normalize-space()='Confirm Popup']"));
	    element.click();
	    String confirmText = closeAlertAndGetItsText();
	    assertTrue(confirmText.matches("^OK or Cancel, which will it be[\\s\\S]$"));
	    
	    //message confirm popups
	    
	      element=driver.findElement(By.id("confirmResult"));
	      assertEquals("OK it is!", element.getText());
	   
	     
	    // prompt popups
	     
	    element= driver.findElement(By.xpath("//b[normalize-space()='Prompt Popup']"));
	    element.click();
	    alert = driver.switchTo().alert();
	    alert.sendKeys("hello sabrine");
	    alert.accept();
	    element =driver.findElement(By.id("promptResult"));
	 
	    assertEquals("Nice to meet you, hello sabrine!", element.getText());
	  
	  // clic me to see a tooltip
	      element = driver.findElement(By.xpath("//div[@onclick='showTooltip()']"));
	      assertEquals("<< click me to see a tooltip >>", element.getText());
	   
	    }
	    catch (Error e) {
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
	public String getBaseUrl() {
		return baseUrl;
	}
	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}
	}
