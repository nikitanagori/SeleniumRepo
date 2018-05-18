
package org.SeleniumAdvancve;

import org.testng.annotations.Test;

import utility.ExcelUtility;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class LoginTestMeApp {
	public WebDriver driver;
  @Test
  public void testme_login() throws Exception {
	  ExcelUtility.setExcelPath("Sheet1", "C:\\Users\\A06438_P5.Training\\Downloads\\Drivers\\testdata.xlsx");
	  
	  driver.findElement(By.id("userName")).clear();
	  driver.findElement(By.id("userName")).sendKeys(ExcelUtility.getCellData(1, 1));
	  driver.findElement(By.id("password")).clear();
	  driver.findElement(By.id("password")).sendKeys(ExcelUtility.getCellData(1,2));
	  driver.findElement(By.name("Login")).click();
	  
	  
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\A06438_P5.Training\\Downloads\\Drivers\\chromedriver_win32\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get("http://localhost:8083/TestMeApp/login.htm");
	
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
