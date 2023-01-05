package MVN3;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Four {
	@Test
	public void a0() {
		System.out.println("3");
	}
	@Test
	public void b0() {
		System.out.println("4");
	}
	@AfterTest
	public void c0() {
		System.out.println("AfterTest for module1");
	}
}
