package com.componentwise.eval;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import org.junit.Test;

public class TestUserKey {
	
	@Test
	public void testGetName() {
		UserKey uk = new UserKey("Jenny Test", "8675309");
		assertEquals("Jenny Test", uk.getName());
		assertNotNull(uk.getName());
		System.out.println("User name test passed!");
	}
	
	@Test
	public void testGetUserId() {
		UserKey uk = new UserKey("Jenny Test", "8675309");
		assertEquals("8675309", uk.getUserID());
		assertNotNull(uk.getUserID());
		System.out.println("UserID test passed!");
	}
	
	@Test
	public void testSerializable() {
		UserKey uk = new UserKey("Jenny Test", "8675309");
		try {
			new ObjectOutputStream(new ByteArrayOutputStream()).writeObject(uk);
		} 
		catch (IOException e) {
			fail("UserKey object not serializable!");
			e.printStackTrace();
		}
		System.out.println("UserKey is serializable!");
	}
	
	@Test
	public void testEquality() {
		UserKey b1 = new UserKey("Bill Smith", "BSMITH");
		UserKey b2 = new UserKey("Bill Smith", "BSMITH");
		UserKey b3 = new UserKey("Susan Smith", "SSMITH");
		UserKey b4 = new UserKey(null,null);
		
		assertEquals(b1, b1);
		assertEquals(b1, b2);
		assertNotEquals(b1, b3);
		assertNotEquals(b1, null);
		assertNotEquals(b1, "Some String");
		assertNotEquals(b4, b1);
		
		System.out.println("Equality tests for UserKey passed!");
	}
	
	@Test
	public void testHashTable() {
		UserKey b1 = new UserKey("Bill Smith", "BSMITH");
		UserKey b2 = new UserKey("Bill Smith", "BSMITH");
		java.util.Hashtable<UserKey, String> ht = new java.util.Hashtable<UserKey, String>();
		ht.put(b1,"Some Data");
		String s = ht.get(b2);
		assertEquals(s, "Some Data");
		System.out.println("The UserKey hash table works!");
	}

}
