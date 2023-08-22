//package com.LandsandHomesEndtoEnd;
//
//import java.io.IOException;
//import java.util.Iterator;
//import java.util.List;
//import java.util.NoSuchElementException;
//import java.util.Set;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebElement;
//import org.testng.annotations.Test;
//
//import com.LandsandHomes.GenericUtility.BaseClass;
//import com.LandsandHomes.GenericUtility.WebDriverUtility;
//import com.LandsandHomes.PomRepository.LandsandHomesLogin;
//
//public class EndToEndLogin extends BaseClass
//{
//	@Test
//public void LandsandHomesEndToEnd() throws IOException, Throwable
//{
//	WebDriverUtility.Implicitwait(driver);
//	LandsandHomesLogin logintoLandsandHomes=new LandsandHomesLogin(driver);
//	logintoLandsandHomes.GetHomePageAddPropertyButton().click();
//	
//	//logintoLandsandHomes.GetClickHereToLogin().click();
//	
//	Thread.sleep(6000);
//	//logintoLandsandHomes.getUsername().click();
//	logintoLandsandHomes.getUsername().sendKeys(fileutils.ReadDataFromPropertyFile("Username"));
//	logintoLandsandHomes.GetPassword().sendKeys(fileutils.ReadDataFromPropertyFile("Password"));
//	logintoLandsandHomes.GetLoginButton().click();
//	Thread.sleep(6000);
//	logintoLandsandHomes.GetPostProperty().click();
//	Thread.sleep(4000);
//	JavascriptExecutor jse=(JavascriptExecutor)driver;
//	jse.executeScript("scrollBy(0,500);");
//	Thread.sleep(4000);
//	logintoLandsandHomes.GetSelectFlats().click();
//	logintoLandsandHomes.GetSelectPropertTitleField().sendKeys(fileutils.ReadDataFromPropertyFile("title"));
//		
//	logintoLandsandHomes.GetLocality().sendKeys(fileutils.ReadDataFromPropertyFile("locality"));
//	
//	List<WebElement> eleList=driver.findElements(By.xpath("//div[@class='pac-item']"));
//	for (int i=0;i<eleList.size();i++)
//	{
//	String lists=eleList.get(i).getText();
//	System.out.println(lists);
//	Thread.sleep(4000);
//	jse.executeScript("scrollBy(0,400);");
//	if(lists.contains(fileutils.ReadDataFromPropertyFile("lists")))
//	{
//		eleList.get(i).click();
//	}
//	}
//	
//	logintoLandsandHomes.GetcityTextfield().sendKeys(fileutils.ReadDataFromPropertyFile("city"));
//	Thread.sleep(4000);
//	logintoLandsandHomes.GetApartmentName().sendKeys(fileutils.ReadDataFromPropertyFile("apartname"));
//	Thread.sleep(4000);
//	logintoLandsandHomes.GetcontinueButton().click();
//}
//}
//
//
//	
//	
//	
//	
//
//
//
