package com.LandsandHomes.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandsandHomesLogin
{
	WebDriver driver;
	public LandsandHomesLogin(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[contains(text(),\"Add\")]//i")
	WebElement HomePageAddPropertyButton;
	
	public WebElement GetHomePageAddPropertyButton()
	{
		return HomePageAddPropertyButton;
	}

	@FindBy(xpath = "//form[@method='POST']//input[@name='email_login']")
    WebElement Username;
	
	public WebElement getUsername()
	{
		return Username;
	}
	@FindBy(xpath = "//input[@id='login_password']")
	WebElement Password;
	
	public WebElement GetPassword()
	{
		return Password;
	}
	
	@FindBy(xpath = "//button[@id='submit_button_id']")
	WebElement LoginButton;
	
	public WebElement GetLoginButton()
	{
		return LoginButton;
	}
	
	@FindBy(xpath = "//a[contains(text(),'Click here to Login')]")
	WebElement ClickHereToLogin;
	
	public WebElement GetClickHereToLogin()
	{
		return ClickHereToLogin;
	}
	
	@FindBy(xpath = "//span[text()='Post Property']")
	WebElement PostProperty;
	
	public WebElement GetPostProperty()
	{
		return PostProperty;
	}
	
	@FindBy(xpath = "//div[@id='property_type_details']//label[normalize-space()='Flat/Apartment']")
     WebElement SelectFlats;
	
	public WebElement GetSelectFlats()
	{
		return SelectFlats;
	}
	
	@FindBy(css = "input[placeholder='Enter the Property Title']")
	WebElement SelectPropertTitleField;
	
	public WebElement GetSelectPropertTitleField() 
	{
		return SelectPropertTitleField;
	}
	
	@FindBy(id = "locality")
	WebElement Locality;
	
	public WebElement GetLocality() 
	{
		return Locality;
	}
	
	@FindBy(xpath = "//input[@name='city']")
	WebElement cityTextfield;
	
	public WebElement GetcityTextfield()
	{
		return cityTextfield;
	}
	
	@FindBy(css = "input[placeholder='Enter Apartment Name']")
	WebElement ApartmentName;
	
	public WebElement GetApartmentName()
	{
		return ApartmentName;
	}
	
	@FindBy(xpath = "//button[@class='next action-button mt-3']")
	WebElement continueButton;
	
	public WebElement GetcontinueButton() 
	{
	return continueButton;	
	}
	
//	@FindBy(xpath = "//div[@class='pac-item']")
//	WebElement SearchList;
//	
//	public WebElement GetSearchList() 
//	{
//		return SearchList
//	}
	
	//div[@class='pac-item']
}
