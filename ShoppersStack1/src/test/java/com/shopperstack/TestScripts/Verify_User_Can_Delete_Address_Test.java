package com.shopperstack.TestScripts;

import org.testng.annotations.Test;
import com.shopperStack.genericUtility.BaseTest;
import com.shopperStack.pom.MyAddressPage;
import com.shopperStack.pom.MyProfilePage;

public class Verify_User_Can_Delete_Address_Test extends BaseTest {

	@Test
	public void deleteAddress() throws InterruptedException {
		
		homePage.getAccountButton().click();
		homePage.getMyProfileButton().click();
		
		MyProfilePage profilePage=new MyProfilePage(driver);
		profilePage.getMyAddressButton().click();
		
		MyAddressPage addressPage=new MyAddressPage(driver);
		addressPage.getDeleteAddressBtn().click();
		
		Thread.sleep(2000);
		addressPage.getYesButton().click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
	}
	
}
