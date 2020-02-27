package ArrayAndString;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class URLify13Test {

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void checkAssert() {
		//URLify13 url = new URLify13();
		assertEquals("hello%20world", URLify13.urlIfy("hello world", 11));
	}

}
