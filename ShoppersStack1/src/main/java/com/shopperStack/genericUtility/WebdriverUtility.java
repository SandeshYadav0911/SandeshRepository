package com.shopperStack.genericUtility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class WebdriverUtility {
	
	Select sel;
	File temp;
	File dest;
	JavaUtility javaUtility=new JavaUtility();
	
	public void selectByValue(WebElement element,String value) {
		sel=new Select(element);
		sel.selectByValue(value);
	}
	
	public void selectByIndex(WebElement element,int index) {
		sel=new Select(element);
		sel.selectByIndex(index);
	}
	
	public void selectByVisibleText(WebElement element,String text) {
		sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	
	public void deselectByValue(WebElement element,String value) {
		sel=new Select(element);
		sel.deselectByValue(value);
	}
	
	public void deselectByIndex(WebElement element,int index) {
		sel=new Select(element);
		sel.deselectByIndex(index);
	}
	
	public void deselectByVisibleText(WebElement element,String text) {
		sel=new Select(element);
		sel.deselectByVisibleText(text);
	}
	
	public void deselectall(WebElement element) {
		sel=new Select(element);
		sel.deselectAll();
	}

	public void screenshotWebpage(WebDriver driver) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
		temp=ts.getScreenshotAs(OutputType.FILE);
		dest=new File(FrameworkConstants.screenshotPath+javaUtility.localDateTime()+".png");
		FileHandler.copy(temp, dest);
	}
	
	public void screenshotWebelement(WebElement element) throws IOException {
		temp=element.getScreenshotAs(OutputType.FILE);
		dest=new File(FrameworkConstants.screenshotPath+javaUtility.localDateTime()+".png");
		FileHandler.copy(temp, dest);
	}
}
