package org.SeleniumAdvancve;

import org.testng.annotations.Test;

import utility.ExcelUtility;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class LoginTestMeApp1 {
	public WebDriver driver;
	public static int testcasenum=0;

	
	  @Test(dataProvider="logindata",priority=1)
	  public void testme_login(String username, String pass) throws Exception {
		  
		  try {
		  ExcelUtility.setExcelPath("Sheet1", "C:\\Users\\A06438_P5.Training\\Downloads\\Drivers\\testdata.xlsx");
		  
		  driver.findElement(By.id("userName")).clear();
		  driver.findElement(By.id("userName")).sendKeys(username);
		  driver.findElement(By.id("password")).clear();
		  driver.findElement(By.id("password")).sendKeys(pass);
		  driver.findElement(By.name("Login")).click();

		 Assert.assertEquals(driver.getTitle(), "Home");
		 ExcelUtility.setExcelCell(testcasenum, 2, "pass");
	  }catch(AssertionError e){
		  ExcelUtility.setExcelCell(testcasenum, 2, "fail");
	  }
		  finally {
			testcasenum++;
//			driver.navigate().to("http://localhost:8083/TestMeApp/login.htm");
		}
		  
}
	 
	  @Test(priority=2)
	  public void perform_actions() {
		  WebElement category=driver.findElement(By.xpath("//span[contains(text(),'All Categories')]"));
		  
		  Actions act=new Actions(driver);
		  act.moveToElement(category).click().build().perform();
		  
		  WebElement electonics=driver.findElement(By.xpath("//span[contains(text(),'Electronics')]")); 
		  act.moveToElement(electonics).click().build().perform();
		  
		  WebElement HeadPhone=driver.findElement(By.xpath("//span[contains(text(),'Head Phone')]")); 
		  act.moveToElement(HeadPhone).click().build().perform();
		  
		  WebElement addtocart=driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/div/div[2]/center/a")); 
		  act.moveToElement(addtocart).click().build().perform();
		  
		  WebElement cart1=driver.findElement(By.partialLinkText("Cart")); 
		  act.moveToElement(cart1).click().build().perform();
		  
		  WebElement checkout=driver.findElement(By.linkText("Checkout")); 
		  act.moveToElement(checkout).click().build().perform();
		  
		  WebElement proceedtoPay=driver.findElement(By.xpath("//input[@value='Proceed to Pay']")); 
		  act.moveToElement(proceedtoPay).click().build().perform();
		  
		  WebElement continuebutton = driver.findElement(By.xpath("//a[contains(text(),'Continue')]"));
		  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", continuebutton);
		  
		  act.moveToElement(continuebutton).click().build().perform();
		  
		  //WebElement login=driver.findElement(By.linkText("LOGIN")); 
		  //act.moveToElement(login).click().build().perform();
		   
		  
	  }
	  
	  @DataProvider(name="logindata")
	  public String[][] login_data() throws Exception{
	  ExcelUtility.setExcelPath("Sheet1", "C:\\Users\\A06438_P5.Training\\Downloads\\Drivers\\testdata.xlsx");
	  String[][]tabledata=ExcelUtility.getExcelTable();
	  return tabledata;
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
