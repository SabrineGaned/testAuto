package com.exemple.practiceautomation.po;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormFieldsPage extends PageObject {

	public FormFieldsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//div[@id='top-wrap']/section/div/h1")
	private WebElement title;
	
	@FindBy(id = "name-input")
	private WebElement nameInput;
	
	@FindBy(xpath = "//form[@id='feedbackForm']/p")
	private WebElement requiredText;
	
	@FindBy(xpath = "//input[@type='password']")
	private WebElement passwordInput;
	
	@FindBy(xpath = "//label[@for='drink1']")
	 private WebElement drink1;

	@FindBy(xpath = "//*[@id=\"color1\"]")
	 private WebElement color1;
	
	public WebElement getColor1() {
		return color1;
	}
	public void setColor1(WebElement color1) {
		this.color1 = color1;
	}
	public WebElement getDrink1() {
		return drink1;
	}
	public void setDrink1(WebElement drink1) {
		this.drink1 = drink1;
	}

	@FindBy(xpath = "//input[contains(@id, 'color')]")
	 private WebElement colors;
	
	@FindBy(id = "automation")
	private WebElement dropDown;
	
	@FindBy(xpath = "//li[normalize-space()='Selenium']")
	private WebElement seleniumText;
	
	@FindBy(id = "email")
	private WebElement emailField;
	
	@FindBy(id = "message")
	private WebElement messageField;
	
	@FindBy(id = "submit-btn")
	private WebElement submitButton;
	
	
	public WebElement getSubmitButton() {
		return submitButton;
	}
	public void setSubmitButton(WebElement submitButton) {
		this.submitButton = submitButton;
	}
	public WebElement getSeleniumText() {
		return seleniumText;
	}
	public void setSeleniumText(WebElement seleniumText) {
		this.seleniumText = seleniumText;
	}
	public WebElement getEmailField() {
		return emailField;
	}
	public void setEmailField(WebElement emailField) {
		this.emailField = emailField;
	}
	public WebElement getMessageField() {
		return messageField;
	}
	public void setMessageField(WebElement messageField) {
		this.messageField = messageField;
	}
	public WebElement getDropDown() {
		return dropDown;
	}
	public void setDropDown(WebElement dropDown) {
		this.dropDown = dropDown;
	}

	public WebElement getTitle() {
		return title;
	}
	public void setTitle(WebElement title) {
		this.title = title;
	}
	
	public WebElement getNameInput() {
		return nameInput;
	}
	public void setNameInput(WebElement nameInput) {
		this.nameInput = nameInput;
	}
	public WebElement getRequiredText() {
		return requiredText;
	}
	public void setRequiredText(WebElement requiredText) {
		this.requiredText = requiredText;
	}
	public WebElement getPasswordInput() {
		return passwordInput;
	}
	public void setPasswordInput(WebElement passwordInput) {
		this.passwordInput = passwordInput;
	}
	
	
	
	
	

	public void clickFavoritDrink(int index)
	{
		driver.findElement(By.xpath("//input[@id='drink"+index+"']")).click();
	}
	public void clickAllFavoritDrink()
	{
		for (int i = 0; i < 4; i++) {
			clickFavoritDrink(i+1);
		}
	}
	public void clickFavoriteColor(int index)
	{
		driver.findElement(By.xpath("//input[@id='color"+index+"']")).click();
	}
	public void clickAllFavoritColor()
	{
		for (int i = 0; i < 4; i++) {
			clickFavoriteColor(i+1);
		}
	
	}


}
