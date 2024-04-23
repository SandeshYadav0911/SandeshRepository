package com.shopperstack.TestScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.shopperStack.genericUtility.BaseTest;
import com.shopperStack.pom.AddressFormPage;
import com.shopperStack.pom.HomePage;
import com.shopperStack.pom.LoginPage;
import com.shopperStack.pom.MyAddressPage;
import com.shopperStack.pom.MyProfilePage;
import com.shopperStack.pom.WelcomePage;

public class Verify_User_Can_Add_Address_Test extends BaseTest {
	
	@Test
	public void addAddress() throws IOException, InterruptedException {
		
//		WelcomePage welcomePage=new WelcomePage(driver);
//		Thread.sleep(3000);
//		welcomePage.getLoginButton().click();
//		
//		LoginPage loginPage=new LoginPage(driver);
//		loginPage.getEmailTextField().sendKeys(file.readPropertyData("username"));
//		loginPage.getPasswordTextField().sendKeys(file.readPropertyData("password"));
//		loginPage.getLoginButton().click();
//		
		
		Thread.sleep(3000);
		HomePage homePage=new HomePage(driver);
		homePage.getAccountButton().click();
		homePage.getMyProfileButton().click();
		
		MyProfilePage myProfilePage=new MyProfilePage(driver);
		myProfilePage.getMyAddressButton().click();
		
		MyAddressPage myAddressPage=new MyAddressPage(driver);
		myAddressPage.getAddAddressBtn().click();
		
		AddressFormPage addressFormPage=new AddressFormPage(driver);
		addressFormPage.getAddressType().click();
		addressFormPage.getNameField().sendKeys(file.readExcelData("sheet1", 1, 0));
		addressFormPage.getOfficeInfoField().sendKeys(file.readExcelData("sheet1", 1, 1));
		addressFormPage.getStreetInfoField().sendKeys(file.readExcelData("sheet1", 1, 2));
		addressFormPage.getLandmarkField().sendKeys(file.readExcelData("sheet1", 1, 3));
		
		webdriverUtility.selectByValue(addressFormPage.getCountryField(), file.readPropertyData("country"));
		webdriverUtility.selectByValue(addressFormPage.getStateField(), file.readPropertyData("state"));
		webdriverUtility.selectByValue(addressFormPage.getCityField(), file.readPropertyData("city"));
		
		addressFormPage.getPincodeField().sendKeys(file.readExcelData("sheet1", 1, 4));
		addressFormPage.getPhoneNumberField().sendKeys(file.readExcelData("sheet1", 1, 5));
		addressFormPage.getAddAddressBtn().click();
		
//		homePage.getAccountButton().click();
//		homePage.getLogoutButton().click();
	}

}
