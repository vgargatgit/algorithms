package com.vgarg.algorithms.codingproblems;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;



public class GeneString {
    public static void main(String[] args) throws IOException {
    	String filePath = "C:\\Users\\Vikas Garg\\OneDrive\\Desktop\\genestringtest02.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> genes = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .collect(toList());

        List<Integer> health = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int s = Integer.parseInt(bufferedReader.readLine().trim());
        List<Long> hlist = new ArrayList<>();
        
        Map<String, List<Integer>> geneToIndex = new HashMap<>();
        
        int i = 0;
        for (String gene : genes) {
        	List<Integer> list = geneToIndex.getOrDefault(gene, new ArrayList<>());
        	list.add(i);
        	geneToIndex.put(gene, list);
        	i++;
        }
        
        IntStream.range(0, s).forEach(sItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int first = Integer.parseInt(firstMultipleInput[0]);
                int last = Integer.parseInt(firstMultipleInput[1]);

                String d = firstMultipleInput[2];
                
                long h = getHealth(geneToIndex, 
                    health, first, last, d);
                hlist.add(h);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }); 

        bufferedReader.close();
        
        long minHealth  =  hlist.get(0);
        long maxHealth = hlist.get(0);
            
        for (long h : hlist) {
            if (minHealth > h) minHealth = h;
            if (maxHealth < h) maxHealth = h;    
        }            
            
        System.out.println(String.valueOf(minHealth) + " " + String.valueOf(maxHealth));
    }
    
    public static long getHealth(Map<String, List<Integer>> geneToIndex, 
                    List<Integer> health, int first, int last, String d) {
        
    	long result = 0;
    	// Get all substrings of d
    	List<String> genesToCheck =  getAllSubstrings(d);
    	
    	// Check index from geneToIndex map if exists
    	for (String geneToCheck : genesToCheck) {
    		if (geneToIndex.containsKey(geneToCheck)) {
    			for(int geneIndex : geneToIndex.get(geneToCheck)) {
    				if (geneIndex <= last && geneIndex >= first)
    				   result += health.get(geneIndex);
    			}
    			
    		}
    	}
   
        return result;
    }
    
    public static List<String> getAllSubstrings(String s) {
    	int len = s.length();
    	List<String> result = new ArrayList<>();
    	
    	for (int i=0; i < len; i++) {
    		for (int j=i+1; j <= len; j++) {
    			result.add(s.substring(i, j));
    		}
    	}
    	
    	return result;
    }
    
    @Test
    public void testGetAllSubstrings() {
    	String s = "caaab";
    	System.out.println(getAllSubstrings(s));
    }
    
    public static int getFrequency(String s, String ss) {
        
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
}

