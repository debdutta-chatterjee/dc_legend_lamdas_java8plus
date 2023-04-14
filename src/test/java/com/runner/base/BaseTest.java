package com.runner.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest 
{
	protected WebDriver driver;
	
	@BeforeTest
   public void setDriver()
	{
        this.driver = new ChromeDriver();
    }
	
	@AfterTest
    public void quitDriver()
	{
        this.driver.quit();
    }
}
