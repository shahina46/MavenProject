package MVN4;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Six {
	@Test
	public void a2() {
		System.out.println("a2");
	}
	@Test
	public void b2() {
		System.out.println("b2");
	}
	@BeforeTest
	public void c2() {
		System.out.println("BeforeTest for module2");
	}
}
