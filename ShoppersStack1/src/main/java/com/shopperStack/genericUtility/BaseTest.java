package com.shopperStack.genericUtility;

import java.io.IOException;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.shopperStack.pom.HomePage;
import com.shopperStack.pom.LoginPage;
import com.shopperStack.pom.WelcomePage;

public class BaseTest {
	
	public WebDriver driver;
	public static WebDriver listenersDriver;
	public FileUtility file=new FileUtility();
	public WebdriverUtility webdriverUtility=new WebdriverUtility();
	public ExtentSparkReporter spark;
	public ExtentReports reports;
	public ExtentTest test;
	public JavaUtility java=new JavaUtility();
	public HomePage homePage;
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite");
		spark=new ExtentSparkReporter("./reports/"+java.localDateTime()+".html");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test");
		reports=new ExtentReports();
		reports.attachReporter(spark);
		test=reports.createTest("Demo");
	}
	
	@BeforeClass
	public void beforeClass() throws IOException {
		
		String url=file.readPropertyData("url");
		String browser=file.readPropertyData("browser");
		
		System.out.println("Before Class");
		
		if (browser.equals("chrome")) {
			driver=new ChromeDriver();
		}
		
		else if (browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		
		else if (browser.equals("edge")) {
			driver=new EdgeDriver();
		}
		
		else {
			System.out.println("Please Enter A Valid Browser Name");
		}
		
		listenersDriver=driver;
		homePage=new HomePage(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.get(url);
	}
	
	@BeforeMethod
	public void beforeMethod() throws IOException, InterruptedException {
		System.out.println("Before Method");
//		test.log(Status.INFO,"Navigated");
		WelcomePage welcomePage=new WelcomePage(driver);
		Thread.sleep(10000);
		welcomePage.getLoginButton().click();
//		test.log(Status.INFO,"In login page");
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.getEmailTextField().sendKeys(file.readPropertyData("username"));
		loginPage.getPasswordTextField().sendKeys(file.readPropertyData("password"));
		loginPage.getLoginButton().click();
//		test.log(Status.INFO,"In home page");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
		homePage.getAccountButton().click();
		homePage.getLogoutButton().click();
		test.log(Status.INFO, "Logout Successfully");
	}
	
	@AfterClass
	public void afterClass() throws InterruptedException {
		System.out.println("After Class");
		Thread.sleep(3000);
		driver.quit();
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("After Test");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite");
	}
}
