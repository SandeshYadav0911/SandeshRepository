package com.shopperStack.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAddressPage {
	
	public MyAddressPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[text()='Add Address']")
	private WebElement addAddressBtn;

	public WebElement getAddAddressBtn() {
		return addAddressBtn;
	}
	
	@FindBy(xpath = "(//button[@type='button'])[4]")
	private WebElement deleteAddressBtn;

	public WebElement getDeleteAddressBtn() {
		return deleteAddressBtn;
	}
	
	@FindBy(xpath = "//div[contains(@class,'MuiModal-root MuiDialog-root css-126xj0f')]//button[contains(@type,'button')][normalize-space()='Yes']")
	private WebElement yesButton;

	public WebElement getYesButton() {
		return yesButton;
	}
}
