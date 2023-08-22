package testNGLaHAddProp;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Add_Prop_com_sell_induLand 
{
	WebDriver driver;
	String CurrentURL1;
	String CurrentURL2;
	
	@BeforeMethod
	@Parameters({"browsername","url","username","password"})
public void Login(String browsername ,String url,String username, String password) throws InterruptedException 
{
	if(browsername.equals("chrome"))
	{
		driver=new ChromeDriver();
	}
	else {
		driver=new EdgeDriver();
	}
	driver.manage().window().maximize();
	
//home page LOGIN-----------------
	
	driver.get(url);
	Thread.sleep(10000);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
	// In home Page Click On AddProp Button
	driver.findElement(By.xpath("//a[contains(text(),\"Add\")]//i")).click();
	driver.findElement(By.xpath("//form[@method='POST']//input[@name='email_login']")).sendKeys(username);
	driver.findElement(By.xpath("//input[@id='login_password']")).sendKeys(password);
	driver.findElement(By.xpath("//button[@id='submit_button_id']")).click();
	
	// After login click on Post property button
	
	driver.findElement(By.xpath("//span[text()='Post Property']")).click();
}
	
	@Test
	@Parameters({"PropertyTitle","Locality","List","Pincode","PlotNO","length","breadth","BuildUp","Expprice","PlotArea"/*,"ApartName",,"Carpet","Units","Expprice","curten","bedroom","tower","floor","Discrp"*/})
	public void Add_Prop(String PropertyTitle,String Locality,String List,String Pincode,String PlotNO,String length,String breadth,String BuildUp,String Expprice,String PlotArea/*,String ApartName,,String Carpet,String Units,String Expprice,String curten,String bedroom,String tower,String floor,String Discrp*/) throws InterruptedException 
	{
		Actions action=new Actions(driver);
		driver.findElement(By.xpath("(//div[@id='append_property_type']//label)[2]")).click();
		Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("scrollBy(0,400);");
		Thread.sleep(3000);
		CurrentURL1=driver.getCurrentUrl();
		// select Industrial land
		driver.findElement(By.xpath("//div[@id='property_type_details']//label[normalize-space()='Industrial Land/Plot']")).click();
		//Enter the prop title
		driver.findElement(By.cssSelector("input[placeholder='Enter the Property Title']")).sendKeys(PropertyTitle);
		//Enter Locality 
		driver.findElement(By.id("locality")).sendKeys(Locality);
		List<WebElement> SearchList=driver.findElements(By.xpath("//div[@class='pac-item']"));
		jse.executeScript("scrollBy(0,400);");
		Thread.sleep(3000);

		for(int i=0;i<SearchList.size();i++)
		{
			if(SearchList.contains(List))
			{
				SearchList.get(i).click();
			}
		}
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys(Locality);
		Thread.sleep(3000);
		
		
		WebElement Pincd=driver.findElement(By.name("pincode"));
		
		if(Pincd.getText().isEmpty())
		{
			driver.findElement(By.name("pincode")).sendKeys(Pincode);
		}
		else
			
		System.out.println("Pin code is Already filled");
		
		//Enter Apartment name
				driver.findElement(By.name("house_no")).sendKeys(PlotNO);
				Thread.sleep(3000);
		
		//click on Next button
		driver.findElement(By.xpath("//button[@class='next action-button mt-3']")).click();
		Thread.sleep(3000);
		
		// select Area drop down
				WebElement AreaDropdown=driver.findElement(By.xpath("//select[@id='inputGroupSelect03']"));
				Select AreaDetails=new Select(AreaDropdown);
				AreaDetails.selectByVisibleText("Sq. feet");
				
		// Select Length and Breadth of plot
				driver.findElement(By.cssSelector("input[placeholder='Enter length']")).sendKeys(length);
				driver.findElement(By.cssSelector("input[placeholder='Enter breadth']")).sendKeys(breadth);
				
		
//					
				
			
		
			//	jse.executeScript("scrollBy(0,400);");
				
		//Build Up Area
				//Enter Built UP area
				WebElement BUP=driver.findElement(By.cssSelector("input[name='built_up']"));
				BUP.sendKeys(BuildUp);
//				String PlotArea1=BUP.getText();
//				if(BUP.getText().isEmpty())
//				{
//					System.out.println("Nothing to Pass the Value");
//				}
//				else
				//	driver.findElement(By.name("plot_area")).sendKeys(PlotArea1);
				
				
				
	    //Plot Area
	
//				
//				//Enter Expect Price
//				driver.findElement(By.cssSelector("input[placeholder='Expected price']")).sendKeys(Expprice);
				
				
				
				
		
	
	
	
}
}
