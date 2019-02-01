import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.junit.*;

public class CacheTests {
	
	@Test(expected = NullPointerException.class) 
	public void testCacheGetFailsOnKeyNull() {
		Cache<String, String> c = new Cache<String, String>();
		c.get(null, s -> s);
	}

	@Test(expected = NullPointerException.class) 
	public void testCacheGetFailsOnConstructorNull() {
		Cache<String, String> c = new Cache<String, String>();
		c.get("Hello", null);
	}
	
	@Test
	public void testCacheGetNotCached() {
		Cache<String, String> c = new Cache<String, String>();
		assertEquals("World", c.get("Hello", s -> "World"));
	}

	@Test
	public void testCacheGetCached() {
		Cache<String, String> c = new Cache<String, String>();
		c.get("Hello", s -> "World");
		assertEquals("World", c.get("Hello", s -> "World"));
	}
}