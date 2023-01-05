package MVN5;

import org.testng.annotations.Test;

public class Eight {
	@Test
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
