package com.componentwise.eval;

import java.io.FileNotFoundException;

public class Execute {

	public static void main(String[] args) throws FileNotFoundException {
		
		//XMLparser x = new XMLparser("test.xml");
		//x.isValid();
		
		UserKey b1 = new UserKey("Bill Smith", "BSMITH");
		UserKey b2 = new UserKey("Bill Smith", "BSMITH");
		UserKey b3 = new UserKey("Susan Smith", "SSMITH");
		UserKey b4 = new UserKey(null,null);

		System.out.println( b1.equals(b1) );  // prints true
		System.out.println( b1.equals(b2) );  // prints true
		System.out.println( b1.equals(b3) );  // prints false
		System.out.println( b1.equals(null) ); // prints false
		System.out.println( b1.equals("Some String") ); // prints false
		System.out.println( b4.equals(b1) ); // prints false

		java.util.Hashtable<UserKey, String> ht = new java.util.Hashtable<UserKey, String>();

		ht.put(b1,"Some Data");

		String s = ht.get(b2);

		System.out.println( s.equals("Some Data") );  // prints true


		
		
	}
}
