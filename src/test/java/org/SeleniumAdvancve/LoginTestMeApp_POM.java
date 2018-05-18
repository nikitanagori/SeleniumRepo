package org.SeleniumAdvancve;

import org.testng.annotations.Test;

import ObjectRepo.TestMeObject;
import utility.ExcelUtility;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;

public class LoginTestMeApp_POM {
	WebDriver driver;
  @Test
  public void loginTestMe() {
	//This is to get the values from Excel sheet, passing parameters (Row num &amp; Col num)to getCellData method
	  
	  TestMeObject.uname.sendKeys(ExcelUtility.getCellData(1, 1));
	  TestMeObject.pass.sendKeys(ExcelUtility.getCellData(1, 2));
	  TestMeObject.login.click();
	  TestMeObject.uname.sendKeys(ExcelUtility.getCellData(2, 1));
	  TestMeObject.pass.sendKeys(ExcelUtility.getCellData(2, 2));
	  TestMeObject.login.click();
	  
	  
	  
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\A06438_P5.Training\\Downloads\\Drivers\\chromedriver_win32\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get("http://localhost:8083/TestMeApp/login.htm");
	  PageFactory.initElements(driver, TestMeObject.class);
	
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
