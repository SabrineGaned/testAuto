package com.exemple.practiceautomation.bdd;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.exemple.practiceautomation.po.ClickEventsPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	JavascriptExecutor js;
	ClickEventsPage ClickEventsPage;
	
	@Given("I am in page click events")
	public void i_am_in_page_click_events() {
		
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		ClickEventsPage = new ClickEventsPage(driver);
		driver.get("https://practice-automation.com/click-events/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		js = (JavascriptExecutor) driver;
	}

	@When("I click for the animal Cat")
	public void i_click_for_the_animal() {
		
		ClickEventsPage.getCat().click();   
	
	}

	@Then("I verify the sound of Cat")
	public void i_verify_the_sound_displayed() {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals("Meow!", ClickEventsPage.getTextDemo().getText());
	}
	
	@When("I click for the animal Dog")
	public void i_click_for_the_animal_dog() {
	    // Write code here that turns the phrase above into concrete actions
		ClickEventsPage.getDog().click();
	    
	}

	@Then("I verify the sound of the Dog")
	public void i_verify_the_sound_of_the_dog() {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals("Woof!", ClickEventsPage.getTextDemo().getText());
	    
	}
	@When("I click for the {string}")
	public void i_click_for_the(String animal) {
	    // Write code here that turns the phrase above into concrete actions
		
		driver.findElement(By.xpath("//button[@onclick='"+animal+"Sound()']")).click();
	}

	@Then("I verify the {string} displayed")
	public void i_verify_the_displayed(String sound) {
	    // Write code here that turns the phrase above into concrete actions
		
		assertEquals( sound,ClickEventsPage.getTextDemo().getText());
	    
		
	    
	}
	@When("I click for the cat")
	public void i_click_for_the_cat() {
	    // Write code here that turns the phrase above into concrete actions
		 ClickEventsPage.getCat().click();
	}

	@Then("I verify the Meow! displayed")
	public void i_verify_the_meow_displayed() {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals("Meow!", ClickEventsPage.getTextDemo().getText());
	}

	@When("I click for the dog")
	public void i_click_for_the_dog() {
	    // Write code here that turns the phrase above into concrete actions
		ClickEventsPage.getDog().click();
	}

	@Then("I verify the Woof! displayed")
	public void i_verify_the_woof_displayed() {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals("Woof!", ClickEventsPage.getTextDemo().getText());
	    
	}

	@When("I click for the pig")
	public void i_click_for_the_pig() {
	    // Write code here that turns the phrase above into concrete actions
		ClickEventsPage.getPig().click();
	    
	}

	@Then("I verify the Oink! displayed")
	public void i_verify_the_oink_displayed() {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals("Oink!", ClickEventsPage.getTextDemo().getText());
	    
	}

	@When("I click for the cow")
	public void i_click_for_the_cow() {
	    // Write code here that turns the phrase above into concrete actions
		ClickEventsPage.getCow().click();
	}

	@Then("I verify the Moo! displayed")
	public void i_verify_the_moo_displayed() {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals("Moo!", ClickEventsPage.getTextDemo().getText());
	   
	}

}
