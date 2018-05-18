package org.SeleniumAdvancve;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class NewTest4 {
  @Test(dataProvider = "Namedata")
  public void f(String s1, String s2) {
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("before method");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("after method");
  }


  @DataProvider(name="Namedata")
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "Nikita", "Nagori" },
      new Object[] { "Shweta", "Nagori" },
    };
  }
  @BeforeClass
  public void beforeClass() {
	  System.out.println("Before class");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("After Class");
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
