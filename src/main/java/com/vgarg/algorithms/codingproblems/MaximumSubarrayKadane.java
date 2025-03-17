package com.vgarg.algorithms.codingproblems;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MaximumSubarrayKadane {

	   @Test
	    public void testMaxSubarray() {
		   MaximumSubarrayKadane ms = new MaximumSubarrayKadane();
	    	
	    	int[] nums = new int[] {2, 5, -8, 3, 10, -11, 5, 4};
	    	assertEquals(13, ms.maxSubArray(nums, 0, nums.length - 1)); 
	    	
	    	nums = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};
	    	assertEquals(6, ms.maxSubArray(nums, 0, nums.length - 1)); 
	    	
	    	nums = new int[]  {3, -1, 4, -2, -7, 8, 10, -5, 2, -1, 6, -3, 7, -4, 2, -6, 5, 3, -2, 4};
	    	assertEquals(26, ms.maxSubArray(nums, 0, nums.length - 1)); 
	    	
	    }
	    
		public int maxSubArray(int[] nums, int start, int end) {
			
			int currMaxSum = nums[0];
			int runningMax = 0;
			
			for (int i=1; i <= end; i++) {
				runningMax = Math.max(runningMax + nums[i-1], 0);
				currMaxSum = Math.max(currMaxSum, runningMax + nums[i]);
			}
			
			return currMaxSum;
		}
			
			
}
