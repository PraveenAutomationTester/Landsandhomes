package testNGLaHAddProp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
	Thread.sleep(4000);
	driver.findElement(By.xpath("//button[text()='Sign up']")).click();
	Thread.sleep(6000);
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
