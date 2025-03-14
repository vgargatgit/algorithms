package com.vgarg.algorithms.codingproblems;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class CharacterCount {

	public static void main(String[] args) {
		
		// Check if an argument is provided, else show usage instructions
		if (args.length == 0) {
		    System.out.println("Please provide an input string as a command-line argument.");
		    return;
		}
	    
		CharacterCount counter = new CharacterCount();
		
	    // Use the first command-line argument as input
		String input = args[0];

		// Get and print the result
	    String result = counter.getNumberOfThrees(input);
	    System.out.println("Result: " + result);
	}

	public String getNumberOfThrees(String input) {
		
		if (input == null || input.isEmpty()) {
	        return "Input string must not be null or empty";
	    }
		
		// Keep the map of letter and counts
	    Map<Character, Integer> countMap = new LinkedHashMap<>();

	    char prevChar = input.charAt(0);
	    int count = 0;

	    for (char ch : input.toCharArray()) {
	        if (ch == prevChar) {
	            count++;
	        } else {
	            countMap.put(prevChar, countMap.getOrDefault(prevChar, 0) + count / 3);
	            prevChar = ch;
	            count = 1;
	        }
	    }
	    
	    countMap.put(prevChar, countMap.getOrDefault(prevChar, 0) + count / 3);

	    return buildResultString(countMap);

	}

	// Build result string from map
	private String buildResultString(Map<Character, Integer> countMap) {

	    StringBuilder result = new StringBuilder();
	    countMap.forEach((k, v) -> {
	        if (v > 0) result.append(k).append("-").append(v).append(",");
	    });

	    if (result.length() > 0) {
	        result.setLength(result.length() - 1); // Remove trailing comma
	    }
		return result.toString();
	}

	@Test
	public void testNumberOfThrees() {
        test("fffaabccccbdeeefffffff", "f-3,c-1,e-1");
        test("aaaabbbcc", "a-1,b-1");
        test("abcd", "");
        test("aaa", "a-1");
        test("aaabbbcccaaabb", "a-2,b-1,c-1");
        test("aa", "");
        test("", "Input string must not be null or empty");
        test(null, "Input string must not be null or empty");
	}

	private void test(String input, String expectedOuput) {
		
		String output = getNumberOfThrees(input);
		assertEquals(expectedOuput, output);
	}
}
