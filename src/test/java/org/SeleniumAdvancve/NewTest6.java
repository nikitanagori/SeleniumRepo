package org.SeleniumAdvancve;

import org.testng.annotations.Test;

import ObjectRepo.LoginPageObject;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class NewTest6 {
	public WebDriver driver;
  @Test
  public void loginpage() {
	  
	  LoginPageObject.uname.sendKeys("nikitanagori18@gmail.com");
	  LoginPageObject.next.click();
	  WebDriverWait wait=new WebDriverWait(driver, 10);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
	  LoginPageObject.pass.sendKeys("1234");
	  LoginPageObject.next.click();
	  
	  
	  
  }
  @BeforeTest
  public void beforeTest() {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\A06438_P5.Training\\Downloads\\Drivers\\chromedriver_win32\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
	  PageFactory.initElements(driver, LoginPageObject.class);
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
