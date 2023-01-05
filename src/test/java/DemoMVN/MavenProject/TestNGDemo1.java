package DemoMVN.MavenProject;


import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGDemo1 {
	
	@Test(dependsOnMethods={"one"})
public void one() {
	System.out.println("one");
}
	@Test		
public void two() {
	System.out.println("two");
}
	@Test(enabled=false)
public void three() {
	System.out.println("three");
}
	@Test
public void four() {
	System.out.println("four");
}
	
}
