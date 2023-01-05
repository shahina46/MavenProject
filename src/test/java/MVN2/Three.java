package MVN2;

import org.testng.annotations.Test;

public class Three {
	@Test(groups= {"smoke"})
	public void a11() {
		System.out.println("11");
	}
	@Test
	public void b22() {
		System.out.println("22");
	}
}
