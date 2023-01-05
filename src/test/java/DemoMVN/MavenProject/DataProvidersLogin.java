package DemoMVN.MavenProject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProvidersLogin {
	Logger log=LogManager.getLogger(DataProvidersLogin.class);
	public WebDriver driver;
	 @DataProvider(name = "login-data")
	  	public Object[][] dataProvFunc(){
	        	return new Object[][]{
	              	{"ss123@gmail.com","Test@123"},{"ms123@gmail.com","Test@123"}
	        	};
	  	}
		@BeforeClass
		public void setUp()
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			log.info("chrome setup started");
			driver.manage().window().maximize();
			
		}	
		
		@AfterClass
		public void tearDown()
		{
			log.info("Driver closing");
		driver.close();
		}
	 @Test(dataProvider="login-data")
	
	  public void loginTest(String username,String password) throws InterruptedException {
		  
			driver.get("https://demo.guru99.com/test/newtours/");
		    Thread.sleep(3000);
		    driver.findElement(By.name("userName")).sendKeys(username);
		    driver.findElement(By.name("password")).sendKeys(password);
		    driver.findElement(By.name("submit")).click();
		    
		    Thread.sleep(3000); 
			
	  }
}
