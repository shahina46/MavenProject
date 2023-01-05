package DemoMVN.MavenProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {
	WebDriver driver;
	@BeforeTest
	  public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.angelfire.com/super/badwebs/");
		driver.manage().window().maximize();
	  }
	@Test(enabled=false)
	public void frames() {
driver.switchTo().frame(1);
driver.findElement(By.xpath("/html/body/p[5]/b/a/font")).click();
}
@Test
public void finding_element_frames() {
	List<WebElement>frames=driver.findElements(By.tagName("frame"));
	for (int i=0;i<frames.size();i++) {
		driver.switchTo().frame(i);
		try {
			driver.findElement(By.xpath("/html/body/p[5]/b/a/font")).click();
			break;
		}
		catch(Exception x) {
			driver.switchTo().defaultContent();
			}
		}
}
	
}