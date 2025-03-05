package com.exemple.practiceautomation.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClickEventsPage extends PageObject {

	public ClickEventsPage(WebDriver driver) {
		super(driver);
		
		// TODO Auto-generated constructor stub
	}

@FindBy(xpath="//h1[contains(@itemprop,'headline')]")
	private WebElement headline;
	
public WebElement getHeadline() {
	return headline;
}

public void setHeadline(WebElement headline) {
	this.headline = headline;
}

@FindBy(xpath="//b[normalize-space()='Cat']")
private WebElement cat;

@FindBy(xpath="//b[normalize-space()='Dog']")
private WebElement dog;

@FindBy(xpath="//b[normalize-space()='Pig']")
private WebElement pig;

@FindBy(xpath="//b[normalize-space()='Cow']")
private WebElement cow;

@FindBy(id="demo") 
private WebElement textDemo;

public WebElement getCat() {
	return cat;
}

public void setCat(WebElement cat) {
	this.cat = cat;
}

public WebElement getDog() {
	return dog;
}

public void setDog(WebElement dog) {
	this.dog = dog;
}

public WebElement getPig() {
	return pig;
}

public void setPig(WebElement pig) {
	this.pig = pig;
}

public WebElement getCow() {
	return cow;
}

public void setCow(WebElement cow) {
	this.cow = cow;
}

public WebElement getTextDemo() {
	return textDemo;
}

public void setTextDemo(WebElement textDemo) {
	this.textDemo = textDemo;
}


}






