package MVN2;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class One {
	@Test
	public void a() {
		System.out.println("a");
	}
	@Test
	public void b() {
		System.out.println("b");
	}
	@Test
	public void c() {
		System.out.println("c");
	}
	@BeforeTest
	public void d() {
		System.out.println("BeforeTest for module1");
	}
	@BeforeSuite
	public void open() {
		System.out.println("open");
	}
	@AfterSuite
	public void close() {
		System.out.println("close");
	}
}
