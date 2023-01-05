package DemoMVN.MavenProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTables {
	WebDriver driver;
	 @BeforeTest
	  public void beforeTest() {
	     WebDriverManager.chromedriver().setup();
	     driver = new ChromeDriver();
		 driver.get("https://www.timeanddate.com/worldclock/");
		 driver.manage().window().maximize();
		// Thread.sleep(2000);
	  }

  @Test(priority=1,enabled=false)
  public void open() {
	  List<WebElement> tables = driver.findElements(By.tagName("table"));
	  System.out.println(tables.size());
  }
 @Test(priority=2,enabled=false)
 public void rowsAndColumns() {
	 WebElement table=driver.findElement(By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table"));
	 List<WebElement>rows=table.findElements(By.tagName("tr"));
	 System.out.println("no. of rows are"+" " +rows.size());
	 List<WebElement>columns=table.findElements(By.tagName("td"));
	 System.out.println("no. of columns are"+" " +columns.size());
 }
 @Test(priority=3,enabled=false)
 public void gettext() {
	 String text=driver.findElement(By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[5]/td[5]/a")).getText();
	 System.out.println(text);
 }
 @Test(priority=4,enabled=false)
 public void data() {
	 String part1="/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[";
	 String part2="]/td[1]/a";
	 for(int i=1;i<=36;i++) {
		 String text=driver.findElement(By.xpath(part1+i+part2)).getText();
		 System.out.println(text);
	 }
 }
 @Test(priority=5)
 public void allData() {
	 WebElement table=driver.findElement(By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table"));
	 List<WebElement>rows=table.findElements(By.tagName("tr"));
	 for(int i=0;i<rows.size();i++) {
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
