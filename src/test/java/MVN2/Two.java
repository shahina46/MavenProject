package MVN2;

import org.testng.annotations.Test;

public class Two {
	@Test
	public void e() {
		System.out.println("ee");
	}
	@Test
	public void f() {
		System.out.println("ff");
	}
	@Test(groups= {"smoke"})
	public void g() {
		System.out.println("gg");
	}
}
