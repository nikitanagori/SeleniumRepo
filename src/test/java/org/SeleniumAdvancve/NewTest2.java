package org.SeleniumAdvancve;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class NewTest2 {
	@Test
	  public void f() {
		  System.out.println("in test method2");
	  }
	  @BeforeTest
	  public void beforeTest() {
		  System.out.println("In before test");
	  }

	  @AfterTest
	  public void afterTest() {
		  System.out.println("In aftertest");
	  } 
	  }

