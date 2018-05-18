package org.SeleniumAdvancve;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NewTest3 {
  @Test(dataProvider = "logindata")
  public void login(String uname, String pass) {
	  System.out.println("in test");  
	  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("before method");  
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("after method"); 
  }


  @DataProvider(name="logindata")
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "user1", "pass1" },
      new Object[] { "user2", "pass2" },
      new Object[] { "user3", "pass3" },
      
    };
  }
  @BeforeTest
  public void beforeTest() {
	  System.out.println("before test"); 
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("after test"); 
  }

}
