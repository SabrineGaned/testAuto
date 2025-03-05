package com.exemple.practiceautomation.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BrokenLinksPage  extends PageObject {

	public BrokenLinksPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath = "//*[@id='header']/div/a/img")
	private WebElement logo;
	
	@FindBy(xpath = "//h1[@itemprop='headline']")
	private WebElement headLine;
	
	@FindBy(linkText = "HTTP response code")
	private WebElement responseCode;
	
	@FindBy(xpath = "//article[@id='post-1267']/div/p[2]")
	private WebElement idealScenarioText;
	
	@FindBy(xpath = "//td[@class='has-text-align-left'][1]")
	private WebElement missingPageText;
	
	@FindBy(xpath ="//*[@id=\"post-1267\"]/div/figure/table/tbody/tr/td[2]")
	private WebElement quatreQuatrePageText;
	
	@FindBy(xpath = "//th[@class='has-text-align-left'][1]")
	private WebElement nameText;
	
	@FindBy(xpath = "//th[@class='has-text-align-left'][2]")
	private WebElement statusText;
	
	@FindBy(xpath = "//a[normalize-space()='Home']")
	private WebElement homeText;
	
	@FindBy(xpath = "//a[normalize-space(='broken link']")
	private WebElement bokenLink;
	
	
	
	public WebElement getLogo() {
		return logo;
	}

	public void setLogo(WebElement logo) {
		this.logo = logo;
	}

	public WebElement getHeadLine() {
		return headLine;
	}

	public void setHeadLine(WebElement headLine) {
		this.headLine = headLine;
	}

	public WebElement getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(WebElement responseCode) {
		this.responseCode = responseCode;
	}

	public WebElement getIdealScenarioText() {
		return idealScenarioText;
	}

	public void setIdealScenarioText(WebElement idealScenarioText) {
		this.idealScenarioText = idealScenarioText;
	}

	public WebElement getMissingPageText() {
		return missingPageText;
	}

	public void setMissingPageText(WebElement missingPageText) {
		this.missingPageText = missingPageText;
	}

	public WebElement getQuatreQuatrePageText() {
		return quatreQuatrePageText;
	}

	public void setQuatreQuatrePageText(WebElement quatreQuatrePageText) {
		this.quatreQuatrePageText = quatreQuatrePageText;
	}

	public WebElement getNameText() {
		return nameText;
	}

	public void setNameText(WebElement nameText) {
		this.nameText = nameText;
	}

	public WebElement getStatusText() {
		return statusText;
	}

	public void setStatusText(WebElement statusText) {
		this.statusText = statusText;
	}

	public WebElement getHomeText() {
		return homeText;
	}

	public void setHomeText(WebElement homeText) {
		this.homeText = homeText;
	}

	public WebElement getBokenLink() {
		return bokenLink;
	}

	public void setBokenLink(WebElement bokenLink) {
		this.bokenLink = bokenLink;
	}

	
	
	
}
