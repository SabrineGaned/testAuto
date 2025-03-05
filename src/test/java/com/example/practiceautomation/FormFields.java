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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.exemple.practiceautomation.po.FormFieldsPage;
public class FormFields {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;
  FormFieldsPage formFieldsPage;
  @Before
  public void setUp() throws Exception {
	  System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
	  ChromeOptions options = new ChromeOptions();
	  options.addArguments("start-maximized");
	  options.addArguments("--remote-allow-origins=*");
	  driver = new ChromeDriver(options);
	  formFieldsPage=new FormFieldsPage(driver);
	  baseUrl = "https://practice-automation.com/";
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  js = (JavascriptExecutor) driver;
	  }
  
  /*@Test
  public void testFormFields() throws Exception {
    driver.get("https://practice-automation.com/form-fields/");
    
    try {
      driver.findElement(By.xpath("//div[@id='top-wrap']/section/div/h1")).click();
      assertEquals("Form Fields", driver.findElement(By.xpath("//div[@id='top-wrap']/section/div/h1")).getText());
      
    driver.findElement(By.id("name-input")).click();
    //driver.findElement(By.id("name-input")).clear();
    driver.findElement(By.id("name-input")).sendKeys("sabrine");
    
    driver.findElement(By.xpath("//form[@id='feedbackForm']/p")).click();
    assertTrue(driver.findElement(By.xpath("//form[@id='feedbackForm']/p")).getText().matches("^[\\s\\S]* Required$"));
    
    driver.findElement(By.xpath("//input[@type='password']")).click();
    driver.findElement(By.xpath("//input[@type='password']")).sendKeys("12345");
    
    
    driver.findElement(By.id("automation")).click();
    
    new Select(driver.findElement(By.id("automation"))).selectByVisibleText("Yes");
    driver.findElement(By.id("automation")).click();
    assertEquals("Yes",driver.findElement(By.id("automation")).getText());
    
    new Select(driver.findElement(By.id("automation"))).selectByVisibleText("No");
    driver.findElement(By.id("automation")).click();
    assertEquals("No",driver.findElement(By.id("automation")).getText());
    
    new Select(driver.findElement(By.id("automation"))).selectByVisibleText("Undecided");
    driver.findElement(By.xpath("//form[@id='feedbackForm']/ul/li")).click();
    assertEquals("Undecided",driver.findElement(By.id("automation")).getText());
    
    assertEquals("Selenium", driver.findElement(By.xpath("//form[@id='feedbackForm']/ul/li")).getText());
    driver.findElement(By.xpath("//form[@id='feedbackForm']/ul/li[2]")).click();
    assertEquals("Playwright", driver.findElement(By.xpath("//form[@id='feedbackForm']/ul/li[2]")).getText());
    
    driver.findElement(By.xpath("//form[@id='feedbackForm']/ul/li[3]")).click();
      assertEquals("Cypress", driver.findElement(By.xpath("//form[@id='feedbackForm']/ul/li[3]")).getText());
      
    driver.findElement(By.xpath("//form[@id='feedbackForm']/ul/li[4]")).click();
      assertEquals("Appium", driver.findElement(By.xpath("//form[@id='feedbackForm']/ul/li[4]")).getText());
      
    driver.findElement(By.xpath("//form[@id='feedbackForm']/ul/li[5]")).click();
      assertEquals("Katalon Studio", driver.findElement(By.xpath("//form[@id='feedbackForm']/ul/li[5]")).getText());
      
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("sabrine.ganed02@gmail.com");
    
    driver.findElement(By.id("message")).click();
    driver.findElement(By.id("message")).clear();
    driver.findElement(By.id("message")).sendKeys("hello");
    
    driver.findElement(By.id("submit-btn")).click();
    assertEquals("Message received!", closeAlertAndGetItsText());
    } catch (Error e) {
        verificationErrors.append(e.toString());
      }
  }

private Object closeAlertAndGetItsText() {
	// TODO Auto-generated method stube
	return null;
}
}*/

  @Test
  public void testFormFields() throws Exception {
      driver.get("https://practice-automation.com/form-fields/");
      try {
          // Verify page title
          assertEquals("Form Fields",formFieldsPage.getTitle().getText());
          
          // Fill Name field
           
          formFieldsPage.getNameInput().sendKeys("sabrine");
          Thread.sleep(1000);
          
          // Verify required field message
          
        assertEquals("* Required",formFieldsPage.getRequiredText().getText());
           
          // Fill Password field
        		 Thread.sleep(1000);
             formFieldsPage.getPasswordInput().sendKeys("12345");
             Thread.sleep(1000);

         
          
          // check Drinks
                    formFieldsPage.perform( formFieldsPage.getDrink1());
                    Thread.sleep(1000);
                    //  formFieldsPage.clickFavoritDrink(1);
                       
          
          //Check colors
                      
         formFieldsPage.perform(formFieldsPage.getColor1());
         // formFieldsPage.clickFavoriteColor(1);
           
       // Select "Yes"
       formFieldsPage.perform(formFieldsPage.getDropDown());  
    
       formFieldsPage.getSelect(formFieldsPage.getDropDown()).selectByVisibleText("Yes");
       
 
       // Select "No"
       formFieldsPage.getSelect(formFieldsPage.getDropDown()).selectByVisibleText("No");
       
    // Select "Undecided"
       
       formFieldsPage.perform(formFieldsPage.getDropDown());
       
       // Verify selectable list options
       
    
       assertEquals("Selenium", formFieldsPage.getSeleniumText().getText());
       
       
      
      
       
          // Fill email and message
        
          formFieldsPage.getEmailField().sendKeys("sabrine.ganed02@gmail.com");
          formFieldsPage.getMessageField().sendKeys("hello");
          
          // Submit form
          formFieldsPage.perform(formFieldsPage.getSubmitButton());
          assertEquals("Message received!", closeAlertAndGetItsText());
      
          
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