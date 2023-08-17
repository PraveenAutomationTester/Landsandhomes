package testNGLaHAddProp;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Add_Prop_Res_Sell_BuilderFloorProp 
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

	driver.get(url);
	Thread.sleep(10000);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
	driver.findElement(By.xpath("//a[contains(text(),\"Add\")]//i")).click();
	driver.findElement(By.xpath("//form[@method='POST']//input[@name='email_login']")).sendKeys(username);
	driver.findElement(By.xpath("//input[@id='login_password']")).sendKeys(password);
	driver.findElement(By.xpath("//button[@id='submit_button_id']")).click();
	driver.findElement(By.xpath("//span[text()='Post Property']")).click();
}
	@Test
	@Parameters({"PropertyTitle","Locality","List","ApartName","BuildUp","Carpet","Units","Expprice","curten","bedroom","tower","floor","Discrp"})
	public void Add_Prop(String PropertyTitle,String Locality,String List,String ApartName,String BuildUp,String Carpet,String Units,String Expprice,String curten,String bedroom,String tower,String floor,String Discrp) throws InterruptedException 
	{
		
		Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("scrollBy(0,400);");
		Thread.sleep(3000);
		CurrentURL1=driver.getCurrentUrl();
		driver.findElement(By.xpath("//div[@id='property_type_details']//label[normalize-space()='Flat/Apartment']")).click();
		driver.findElement(By.cssSelector("input[placeholder='Enter the Property Title']")).sendKeys(PropertyTitle);
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
		
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Locality");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input[placeholder='Enter Apartment Name']")).sendKeys(ApartName);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='next action-button mt-3']")).click();
		Thread.sleep(3000);
		
		WebElement AreaDropdown=driver.findElement(By.xpath("//select[@id='inputGroupSelect03']"));
		Select AreaDetails=new Select(AreaDropdown);
		AreaDetails.selectByVisibleText("Sq. feet");
		driver.findElement(By.cssSelector("input[name='built_up']")).sendKeys(BuildUp);
		driver.findElement(By.cssSelector("input[name='carpet']")).sendKeys(Carpet);
		driver.findElement(By.cssSelector("input[name='no_of_unit']")).sendKeys(Units);
		driver.findElement(By.cssSelector("input[placeholder='Expected price']")).sendKeys(Expprice);
		jse.executeScript("scrollBy(0,800);");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='furnish_type_toggle']//label[normalize-space()= 'Semi-furnished']")).click();
		
		driver.findElement(By.xpath("//input[@name='furnishing_details[Curtains]']")).clear();
		driver.findElement(By.xpath("//input[@name='furnishing_details[Curtains]']")).sendKeys(curten);
		
		//driver.findElement(By.xpath("(//input[@type='file'])[1]")).sendKeys("C:\\Users\\TECQNIO\\fp5.jpg");
		driver.findElement(By.xpath("//input[@name='furnishing_details[Fans]']")).clear();
		driver.findElement(By.xpath("//input[@name='furnishing_details[Fans]']")).sendKeys(curten);
		
		
		driver.findElement(By.xpath("//input[@name='furnishing_details[Lights]']")).clear();
		driver.findElement(By.xpath("//input[@name='furnishing_details[Lights]']")).sendKeys(curten);
	
		
		driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
		
		
		driver.findElement(By.xpath("//input[@name='no_of_bedroom']")).clear();
		driver.findElement(By.xpath("//input[@name='no_of_bedroom']")).sendKeys(bedroom);
		
		driver.findElement(By.xpath("//input[@name='no_of_bathroom']")).clear();
		driver.findElement(By.xpath("//input[@name='no_of_bathroom']")).sendKeys(bedroom);
		
		driver.findElement(By.xpath("//input[@name='no_of_balconies']")).clear();
		driver.findElement(By.xpath("//input[@name='no_of_balconies']")).sendKeys(bedroom);
		jse.executeScript("scrollBy(0,300);");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Load more']")).click();
		
		driver.findElement(By.xpath("//span[text()='Pooja Room']")).click();
		driver.findElement(By.xpath("//span[text()='Study Room']")).click();
		driver.findElement(By.xpath("//span[text()='Store Room']")).click();
		driver.findElement(By.xpath("//button[@class='closeRoom btn btn-primary']")).click();
		Thread.sleep(2000);
		jse.executeScript("scrollBy(0,500);");
		
		driver.findElement(By.xpath("//input[@name='tower']")).clear();
		driver.findElement(By.xpath("//input[@name='tower']")).sendKeys(tower);
		
		driver.findElement(By.xpath("//input[@id='total_floor']")).clear();
		driver.findElement(By.xpath("//input[@id='total_floor']")).sendKeys(floor);
		
		WebElement Sf=driver.findElement(By.xpath("//select[@id='property_on_floor']"));
		
		Select Sfloor=new Select(Sf);
		Sfloor.selectByVisibleText("5");
		Thread.sleep(4000);
		jse.executeScript("scrollBy(0,600);");
		driver.findElement(By.xpath("//input[@value='Ready to move']")).click();
		
//		driver.findElement(By.xpath("//button[normalize-space()='Select age of property']")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//label[normalize-space()='1-5 years']  ")).click();
//		Thread.sleep(4000);
//		driver.findElement(By.xpath("//button[normalize-space()='Close' and @class='close closePropertyAge btn btn-secondary']"));
		
		
		
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//label[normalize-space()='Property facing']")).click();
		driver.findElement(By.cssSelector("label[for='East']")).click();
		driver.findElement(By.cssSelector("label[for='West']")).click();
		driver.findElement(By.cssSelector("label[for='North']")).click();
		driver.findElement(By.cssSelector("label[for='South']")).click();
		driver.findElement(By.cssSelector("button[class='closePropertyFacing btn btn-primary']")).click();
//		driver.findElement(By.xpath("//label[normalize-space()='Amenities']")).click();
		Thread.sleep(2000);
//		driver.findElement(By.cssSelector("label[for='Gymnasium']")).click();
//		driver.findElement(By.cssSelector("label[for='Pet area']")).click();
//		driver.findElement(By.cssSelector("label[for='High speed elevators']")).click();
//		driver.findElement(By.cssSelector("label[for='swimming pool']")).click();
//		driver.findElement(By.cssSelector("label[for='Kids play area']")).click();
//		driver.findElement(By.cssSelector("label[for='Central ac']")).click();
//		driver.findElement(By.cssSelector("label[for='Visitor's Parking']")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//button[contains(text(),'Save')])[1]")).click();
//		Thread.sleep(2000);
		jse.executeScript("scrollBy(0,300);");
		Thread.sleep(6000);
		
		driver.findElement(By.xpath("//label[text()='Near Hospital']")).click();
		driver.findElement(By.xpath("//label[text()='Near School & college']")).click();
		driver.findElement(By.xpath("//label[text()='Desperate sale']")).click();
		jse.executeScript("scrollBy(0,200);");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//label[text()='Reputed builder']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[text()='Well ventilated']")).click();
		Thread.sleep(2000);
		jse.executeScript("scrollBy(0,300);");
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//label[text()='Fully Renovated']")).click();
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//label[text()='Tasteful interiors']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[text()='Plenty of sunlight']")).click();
		jse.executeScript("scrollBy(0,200);");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[text()='Well maintained']")).click();
		//jse.executeScript("scrollBy(0,300);");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//label[normalize-space()='Available']")).click();
		jse.executeScript("scrollBy(0,400);");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[normalize-space()='Public Parking']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[normalize-space()='Self Owned']")).click();
		Thread.sleep(2000);
		jse.executeScript("scrollBy(0,-200);");
		driver.findElement(By.xpath("//label[normalize-space()='Yes']")).click();
		
		driver.findElement(By.cssSelector("textarea[name=description]")).sendKeys(Discrp);
		jse.executeScript("scrollBy(0,300);");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[@name='next' and @type='button'])[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='image_files']")).sendKeys("C:\\Users\\TECQNIO\\Downloads\\shops56.jpg");
		driver.findElement(By.xpath("//input[@id='image_files']")).sendKeys("C:\\Users\\TECQNIO\\Downloads\\thiet-ke-va-thi-cong-shop-jm-tttm-royal-city.jpg");
		driver.findElement(By.xpath("//input[@id='image_files']")).sendKeys("C:\\Users\\TECQNIO\\Downloads\\Shops-Establishments.jpg");
		driver.findElement(By.xpath("//input[@id='image_files']")).sendKeys("C:\\Users\\TECQNIO\\Downloads\\cow.jpg");
		Thread.sleep(2000);
		jse.executeScript("scrollBy(0,500);");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@id='video_file']")).sendKeys("C:\\Users\\TECQNIO\\Downloads\\stock-footage-home-interior-walk-through-from-living-room-into-kitchen-warehouse-conversion-empty-space-modern.webm");
		jse.executeScript("scrollBy(0,400);");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
		Thread.sleep(6000);
		CurrentURL2=driver.getCurrentUrl();
	
		
		
		
		
		
		
		
		
		
		
		
		
    
	}
	
	@AfterMethod
	public void Logout() throws InterruptedException 
	{
		String CurrentURL2=driver.getCurrentUrl();
		if (CurrentURL1.equals(CurrentURL2))
		{
			System.out.println("AddProperty:- Fail");
		}
		else {
			System.out.println("Add property:- pass");
		}
		
		driver.findElement(By.xpath("//li[@class='nav-item login-btn-list']//a[@data-bs-toggle='dropdown']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		driver.manage().window().minimize();
		driver.quit();
		
	}
	
}
	
	

