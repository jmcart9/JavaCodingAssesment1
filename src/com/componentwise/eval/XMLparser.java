package com.componentwise.eval;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Jorvon Carter carterjorvon@gmail.com
 *
 * This class contains methods for ascertaining whether
 * an XML file is well-formed. There are numerous
 * criteria which must be met for an XML file to be
 * well-formed. The criteria are listed official documentation for XML.
 * They are not all checked here. Rather,
 * this class is to demonstrate how a comprehensive XML
 * validity checker may be created. Generally, each 
 * criterion must be checked. Here, one criterion, well-nestedness, is checked.
 * However, the entire class is constructed so that other methods
 * can be added as desired.
 */
public class XMLparser {
	private List<String> list = new ArrayList<String>();
	
	/**
	 * When the XMLparser is instantiated, 
	 * add the lines of an XML file into an array.
	 * 
	 * @throws FileNotFoundException if file cannot be found
	 */
	XMLparser(String path) throws FileNotFoundException{
		Scanner inputFile = new Scanner(new FileReader(path));
		while(inputFile.hasNextLine()) {
			list.add(inputFile.nextLine());
		}
		inputFile.close();
	}
	
	/**
	 * Check whether the XML is well-nested.
	 * <p>
	 * An XML file is well-nested if all elements have a closing tag, 
	 * all respective tags match in case, 
	 * there is a root element,
	 * and if elements do not partially intersect.
	 * </p>
	 * 
	 * <p>
	 * As they are found, opening tags are pushed onto a stack. When a closing tag
	 * is encountered, it is compared to the opening tag at the top of the stack. 
	 * If they match, the opening tag is popped from the stack and the algorithm proceeds.
	 * If they do not match, then the XML is invalid and the algorithm terminates.
	 * If the stack is not empty at the end of the parse, then there are unmatched opening tags, 
	 * and the XML is invalid.
	 * </p>
	 * 
	 * @return true if xml is well-nested
	 */
	public boolean wellNested() {
		Stack<String> stack = new Stack<String>();
		 
		Pattern startTag = Pattern.compile("\\<\\w*\\>");
		Pattern endTag = Pattern.compile("\\</\\w*\\>");
		
		for(String s : list) { 
			Matcher matcher1 = startTag.matcher(s);
			Matcher matcher2 = endTag.matcher(s);
			 
			while (matcher1.find()){
				int i = 0;
				stack.push(matcher1.group(i));
				i++;
			}
			while (matcher2.find()){
				int i = 0;
				if(!stack.peek().equals(matcher2.group(i).replaceFirst("/", ""))) {
					System.out.println("XML invlalid! Unmatched closing tag?!");
					return false;
				}
				else {
					stack.pop();
				}
				i++;
			}
		 }
		if(!stack.isEmpty()) {
			System.out.println("XML invalid! Bad nesting or unmatched opening tag!");
			return false;
		}
		else {
			System.out.println("XML Valid!");
			return true;
		}	
	}
	
	/**
	 * For validity, tag attributes must be quoted.
	 * Method is for proof of concept only!
	 * 
	 * @return true if tag attribute is quoted
	 */
	public boolean attributesQuoted() {
		List<String> tags = new ArrayList<String>();
		Pattern startTag = Pattern.compile("\\<\\w*\\>");
		
		for(String s : list) {
			Matcher matcher = startTag.matcher(s);
			while (matcher.find()){
				int i = 0;
				tags.add(matcher.group(i));
				i++;
			}
		}
		
		for (String s : tags) {
			if(s.matches("\\<\\w*\\s*\\w*\\s*=\\s*([^\" >]+)\\>")) {
				System.out.println("XML invalid! Tag attribute not quoted");
				//return false;
			}
		}
		return true;
	}
	
	/**
	 * Check all criteria for XML well-formedness.
	 * 
	 * @return true if XML is well-formed
	 */
	public boolean isValid() {
		return wellNested() && attributesQuoted();
	}
	
}
