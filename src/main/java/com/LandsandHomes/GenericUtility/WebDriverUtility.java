package com.LandsandHomes.GenericUtility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility 
{
public static void Implicitwait(WebDriver driver) 
{
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
}

public static void explicitWait(WebDriver driver) 
{
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofMinutes(2));
}

}
