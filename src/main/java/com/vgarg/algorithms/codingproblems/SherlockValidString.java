package com.vgarg.algorithms.codingproblems;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'isValid' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isValid(String s) {
    // Write your code here
        Map<String, Long> letterToFrequencyMap = new HashMap<>();
        
        String[] letters = s.split("");
        
        for (String letter : letters) {
            letterToFrequencyMap.put(letter, 
                letterToFrequencyMap.getOrDefault(letter, 0l) + 1);
        }
        
        Map<Long, Long> freqToFreqMap = new HashMap<>();
        
        for (Long freq : letterToFrequencyMap.values()) {
            freqToFreqMap.put(freq, 
                freqToFreqMap.getOrDefault(freq, 0l) + 1);
        }
        
        Set<Long> letterFrequencies = freqToFreqMap.keySet();
        
        if (letterFrequencies.size() != 2) return "NO";
        
        if ((Math.abs(letterFrequencies.toArray(new Long[0])[0] - 
                letterFrequencies.toArray(new Long[0])[1]) == 1)) {
                
            return "YES";
         }
         
         return "NO";
    
    }
    
    
}

public class SherlockValidString {
    public static void main(String[] args) throws IOException {


        String s = "";

        String result = Result.isValid(s);


    }
}

