package testNGLaHAddProp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class SignUP
{
	WebDriver driver;
	@BeforeMethod
	@Parameters("url")
	public void BeforeConf(String url)
	{
	    driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	
	
	@Parameters({"fullname","email","password","ConfPassword","mobileNumber"})
	@Test
public void SignUP(String fullname,String email,String mobileNumber,String ConfPassword,String password) throws InterruptedException 
{
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
	String CurrentURL1=driver.getCurrentUrl();
	driver.findElement(By.cssSelector("input[placeholder='Full Name...']")).sendKeys(fullname);
	driver.findElement(By.cssSelector("input[placeholder='Type Email here...']")).sendKeys(email);
	driver.findElement(By.cssSelector("input[placeholder='Password..")).sendKeys(password);
	driver.findElement(By.cssSelector("input[placeholder=' Confirm Password...']")).sendKeys(ConfPassword);
	driver.findElement(By.cssSelector("input[placeholder='Enter mobile number")).sendKeys(mobileNumber);
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	jse.executeScript("scrollBy(0,100)");
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10000));
	
	WebElement SignButton=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Sign')]")));
	SignButton.click();
	WebElement EmailError=driver.findElement(By.xpath("//p[@id='email-error']"));
	WebElement MobileError=driver.findElement(By.xpath("//span[contains(text(),'The phone number has already be')]"));
	
	if(EmailError.isDisplayed())
	{
		System.out.println("Email alredy registered please change email id");
	}
	else if (MobileError.isDisplayed()) 
	{
		System.out.println("Mobile number alredy registered please change email id");
	}
	
	else {
		System.out.println("Every thing is ok");
	}
	
	String CurrentURL2=driver.getCurrentUrl();
	
	if (CurrentURL1.equals(CurrentURL2))
	{
		System.out.println("SignUPTest:- Fail");
	}
	else {
		System.out.println("SignUPTest:- pass");
	}
	Thread.sleep(4000);
	driver.manage().window().minimize();
	driver.quit();
	
	
	
}
	
	@AfterMethod
	public void AfterConf()
	{
		driver.manage().window().minimize();
		driver.quit();
	}
}
