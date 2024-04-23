package com.shopperStack.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressFormPage {

		public AddressFormPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		@FindBy(id = "Home")
		private WebElement addressType;
		
		@FindBy(id = "Name")
		private WebElement nameField;
		
		@FindBy(id = "House/Office Info")
		private WebElement officeInfoField;
		
		@FindBy(id = "Street Info")
		private WebElement streetInfoField;
		
		@FindBy(id = "Landmark")
		private WebElement landmarkField;
		
		@FindBy(id = "Country")
		private WebElement countryField;
		
		@FindBy(id = "State")
		private WebElement stateField;
		
		@FindBy(id = "City")
		private WebElement cityField;
		
		@FindBy(id = "Pincode")
		private WebElement pincodeField;
		
		@FindBy(id = "Phone Number")
		private WebElement phoneNumberField;
		
		@FindBy(id = "addAddress")
		private WebElement addAddressBtn;

		public WebElement getAddressType() {
			return addressType;
		}

		public WebElement getNameField() {
			return nameField;
		}

		public WebElement getOfficeInfoField() {
			return officeInfoField;
		}

		public WebElement getStreetInfoField() {
			return streetInfoField;
		}

		public WebElement getLandmarkField() {
			return landmarkField;
		}

		public WebElement getCountryField() {
			return countryField;
		}

		public WebElement getStateField() {
			return stateField;
		}

		public WebElement getCityField() {
			return cityField;
		}

		public WebElement getPincodeField() {
			return pincodeField;
		}

		public WebElement getPhoneNumberField() {
			return phoneNumberField;
		}

		public WebElement getAddAddressBtn() {
			return addAddressBtn;
		}
		
}