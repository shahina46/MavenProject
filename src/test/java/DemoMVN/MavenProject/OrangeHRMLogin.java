package DemoMVN.MavenProject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
@Listeners(Listenerns.class)
public class OrangeHRMLogin {
	ChromeDriver driver;
	@BeforeTest
	  public void open() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\SELENIUM WORKSPACE\\KareClouds\\Resources\\chromedriver.exe");
		  driver=new ChromeDriver();
		  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		  driver.manage().window().maximize();
		  Thread.sleep(4000);
	  }
  @Test(priority=1)
  public void login() {
	  driver.findElement(By.name("username")).sendKeys("Admin");
	  driver.findElement(By.name("password")).sendKeys("admin123");
	  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
  }
  @Test(priority=2)
  public void logout() throws InterruptedException {
	  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span/i")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.linkText("Logout")).click();
	  
  }
  
  
  @AfterTest
  public void close() {
	 driver.close(); 
	  
  }

}
