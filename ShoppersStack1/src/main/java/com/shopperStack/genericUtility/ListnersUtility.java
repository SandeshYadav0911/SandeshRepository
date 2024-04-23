package com.shopperStack.genericUtility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnersUtility implements ITestListener,ISuiteListener{
	
	JavaUtility javaUtil=new JavaUtility();
	
	@Override
	public void onTestFailure(ITestResult result) {
		TakesScreenshot ts=(TakesScreenshot) BaseTest.listenersDriver;
		File temp=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(FrameworkConstants.screenshotPath+javaUtil.localDateTime()+".png");
		
		try {
			FileHandler.copy(temp, dest);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
