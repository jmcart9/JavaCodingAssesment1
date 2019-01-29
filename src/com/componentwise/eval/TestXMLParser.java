package com.componentwise.eval;

import static org.junit.Assert.assertTrue;
import java.io.FileNotFoundException;

import org.junit.Test;

public class TestXMLParser {
	
	@Test
	public void testIsValid() throws FileNotFoundException{
		XMLparser x = new XMLparser("test.xml");
		assertTrue(x.isValid());
	}

}
