package DemoMVN.MavenProject;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Webtables2 {
	WebDriver driver;
	@BeforeTest
	  public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.timeanddate.com/worldclock/");
		driver.manage().window().maximize();
	  }

  @Test
  public void f() {
	  WebElement table=driver.findElement(By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table"));
	  List<WebElement>rows=table.findElements(By.tagName("tr"));
	  for (int i=0;i<rows.size();i++)
	  {
		  List<WebElement>columns=rows.get(i).findElements(By.tagName("td"));
		  for(int j=0;j<columns.size();j++)
		  {
			  System.out.print(columns.get(j).getText()+" ");
		  }
		  System.out.println();
	  }
  }
  
  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
