package com.shopperStack.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//div[text()='s']")
	private WebElement accountButton;
	
	@FindBy(xpath = "//li[text()='My Profile']")
	private WebElement myProfileButton;
	
	@FindBy(xpath = "//li[text()='Logout']")
	private WebElement logoutButton;

	public WebElement getAccountButton() {
		return accountButton;
	}

	public WebElement getMyProfileButton() {
		return myProfileButton;
	}

	public WebElement getLogoutButton() {
		return logoutButton;
	}

}
