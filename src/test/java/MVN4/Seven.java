 package MVN4;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Seven {
	@Test
	public void a3() {
		System.out.println("a3");
	}
	@Test
	public void b3() {
		System.out.println("b3");
	}
	@AfterTest
	public void c3() {
		System.out.println("AfterTest for module2");
	}
	@AfterClass
	public void last() {
		System.out.println("last");
	}
	@BeforeClass
	public void first() {
		System.out.println("first");
	}
}
