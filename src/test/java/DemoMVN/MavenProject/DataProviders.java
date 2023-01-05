package DemoMVN.MavenProject;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(Listenerns.class)
public class DataProviders {
public WebDriver driver;
public Logger log;
	@DataProvider(name = "registration-data")
  	public Object[][] dataProvFunc(){
        	return new Object[][]{
              	{"shynaz","sulthana","1234567890","ssss123@gmail.com","madhapur","hyderabad","Telangana","531001","INDIA","Test@123","Test@123"},
              	{"mohammad","shynaz","1234567890","msss123@gmail.com","madhapur","hyderabad","Telangana","531001","INDIA","Test@123","Test@123"}
        	};
  	}
	@BeforeMethod

	public void setUp()
	{
	 log=(Logger) LogManager.getLogger(DataProviders.class.getName());
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		log.debug("chrome browser launched");
		driver.manage().window().maximize();
		log.debug("browser got maximized");
		
	}	
	
	@AfterMethod
	public void tearDown()
	{
	driver.close();
	log.debug("browser got closed");
	}
	
	@Test(dataProvider ="registration-data")
	public void registerTest(String fn,String ln,String ph,String email,String add1,String city,String state,String pincode,String country,String pwd,String cpwd) throws InterruptedException
	{
		log.info("enterd url");
		
		driver.get("https://demo.guru99.com/test/newtours/");
		log.debug("navigated to application");
	    Thread.sleep(3000);
	    driver.findElement(By.linkText("REGISTER")).click();
	    Thread.sleep(5000);
	    log.info("Entered first name");
	    driver.findElement(By.name("firstName")).sendKeys(fn);
	    log.info("Entered last name");
	    driver.findElement(By.name("lastName")).sendKeys(ln);
	    log.info("Entered phone number");
	    driver.findElement(By.name("phone")).sendKeys(ph);
	    driver.findElement(By.id("userame")).sendKeys(email);
	    Thread.sleep(2000);
	    driver.findElement(By.name("address1")).sendKeys(add1);
	    driver.findElement(By.name("city")).sendKeys(city); 
	    driver.findElement(By.name("state")).sendKeys(state);
	    driver.findElement(By.name("postalCode")).sendKeys(pincode);
	    driver.findElement(By.name("country")).sendKeys(country);
	    Thread.sleep(2000);
	    
	    driver.findElement(By.id("email")).sendKeys(email);
	    driver.findElement(By.name("password")).sendKeys(pwd);
	    driver.findElement(By.name("confirmPassword")).sendKeys(cpwd);
	    Thread.sleep(2000);
	    
	    driver.findElement(By.name("submit")).click();		
	    Thread.sleep(3000);
}
	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException {
		TakesScreenshot scrnshot=(TakesScreenshot)driver;
		File scrFile=scrnshot.getScreenshotAs(OutputType.FILE);
		File dstFile=new File("C:\\Users\\HP\\eclipse-workspace\\MavenProject\\screenshots\\" +testCaseName +".png");
		FileUtils.copyFile(scrFile, dstFile);
		return "C:\\Users\\HP\\eclipse-workspace\\MavenProject\\screenshots\\"+testCaseName +".png";
	}
}