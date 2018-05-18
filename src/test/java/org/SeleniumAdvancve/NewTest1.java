package org.SeleniumAdvancve;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class NewTest1 {
  @Test
  public void test1() {
	  System.out.println("in test method1");
  }
  @Test
  public void test2() {
	  System.out.println("in test method2");
  }
  @Test
  public void test3() {
	  System.out.println("in test method3");
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


