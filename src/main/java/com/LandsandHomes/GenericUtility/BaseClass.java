package com.LandsandHomes.GenericUtility;

//import java.io.IOException;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//
//public class BaseClass 
//{
//public WebDriver driver;
//public FileUtility fileutils=new FileUtility();
//public WebDriverUtility webdriverutility=new WebDriverUtility();
//
//@BeforeMethod
//public void configBeforemethod() throws IOException
//{
//	String Browsername=fileutils.ReadDataFromPropertyFile("Browser");
//	if(Browsername.equals("chrome"));
//	{
//		driver=new ChromeDriver();
//	}
//	driver.manage().window().maximize();
//	driver.get(fileutils.ReadDataFromPropertyFile("url"));
//		
//}
//
//@AfterMethod
//public void configAfterMethod() throws Throwable
//{
//	Thread.sleep(6000);
//	driver.manage().window().minimize();
//	driver.quit();
	
//}
//}
