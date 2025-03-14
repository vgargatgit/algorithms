package com.vgarg.algorithms.codingproblems;

import static org.junit.Assert.assertArrayEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class TwoSum {

	public static void main(String[] args) {
		
	}
	
	public int[] twoSumUsingHashMap(int[] arr, int target) {
		
		int[] result = new int[2];
		Map<Integer, Integer> valueToIndex = new HashMap<>();		
		
		for (int i=0; i < arr.length; i++) { 
			valueToIndex.put(arr[i], i);
		}
		
		for (int i=0; i < arr.length; i++) {
			int otherValue = target - arr[i];
			
			if (valueToIndex.containsKey(otherValue)) {
				result[0] = i;
				result[1] = valueToIndex.get(otherValue);
				break;
			}
		}
		
		if (result[1] == 0) throw new IllegalArgumentException("Array does not contain numbers that add to target");
		
		return result;
	}
	
	@Test
	public void testTwoSumUsingHashMap() {
		int[] result = twoSumUsingHashMap(new int[] {2, 7, 11, 15}, 9);
		assertArrayEquals(new int[] {0, 1}, result);
	}
}
