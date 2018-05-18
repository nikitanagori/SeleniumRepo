package org.SeleniumAdvancve;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class NewTest5 {
	
	public WebDriver driver;
	
  @Test
  public void register() {
  }
  @BeforeTest
  public void beforeTest() {
	  //System.setProperty("webdriver.chrome.driver", "C:\\Users\\A06438_P5.Training\\Downloads\\Drivers\\chromedriver_win32\\chromedriver.exe");
	  //driver=new ChromeDriver();
	  
	  System.setProperty("webdriver.gecko.driver", "C:\\Users\\A06438_P5.Training\\Downloads\\Drivers\\geckodriver-v0.20.1-win64\\geckodriver.exe");
	  driver=new FirefoxDriver();
	  
	 //System.setProperty("webdriver.ie.driver","C:\\Users\\A06438_P5.Training\\Downloads\\Drivers\\IEDriverServer_Win32_3.12.0\\IEDriverServer.exe");
	 //driver=new InternetExplorerDriver();
	 
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 
	  
	  driver.get("http://newtours.demoaut.com/");
	  driver.findElement(By.xpath("//a[contains(text(),'REGISTER')]")).click();
	  
	  driver.findElement(By.name("firstName")).sendKeys("Nikita");
	  driver.findElement(By.name("lastName")).sendKeys("Nagori");
	  
	  driver.findElement(By.name("phone")).sendKeys("123456789");
	  driver.findElement(By.id("userName")).sendKeys("nikitanagori18@gmail.com");
	  driver.findElement(By.name("address1")).sendKeys("A17, SUPRIYA SANKUL");
	  driver.findElement(By.name("address2")).sendKeys("Pune");
	  driver.findElement(By.name("city")).sendKeys("Pune");
	  driver.findElement(By.name("state")).sendKeys("Maharashtra");
	  driver.findElement(By.name("postalCode")).sendKeys("411045");
	  
	  Select country=new Select(driver.findElement(By.name("country")));
	  country.selectByVisibleText("INDIA");
	  driver.findElement(By.cssSelector("input[name='email'][id='email']")).sendKeys("nikita");
	 
	  driver.findElement(By.name("password")).sendKeys("abc123");
	  driver.findElement(By.name("confirmPassword")).sendKeys("abc123");
	  
	 
	  driver.findElement(By.name("email")).submit();
	  
	  
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
