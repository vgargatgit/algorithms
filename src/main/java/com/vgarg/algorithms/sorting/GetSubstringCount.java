package com.vgarg.algorithms.sorting;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GetSubstringCount {
	public static void main(String[] args) {
		
	}
	
    public static int getFrequency1(String s, String ss) {
        
        int ssLength = ss.length();
        int count = 0;
        
        for (int i=0; i+ssLength <= s.length(); i++) {
        	if (s.substring(i, i+ssLength).equals(ss)) 
        		count++;
        }
        
        return count;
    }
    
    public static int getFrequency2(String s, String ss) {
        
        int ssLength = ss.length();
        int count = 0;
        
        for (int i=0; i+ssLength <= s.length(); i++) {
        	
        	int index = s.indexOf(ss, i);
        	if (index == -1) 
        		break;
        	
        	i += index;
        	count++;
        }
        
        return count;
    }
    
    @Test
    public void testGetFrequency() {
    	String s = "caaab";
    	String ss = "aa";
    	
    	assertEquals(2, getFrequency2(s, ss));
    }
}
