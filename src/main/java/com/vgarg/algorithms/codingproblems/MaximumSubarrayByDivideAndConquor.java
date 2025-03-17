package com.vgarg.algorithms.codingproblems;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MaximumSubarrayByDivideAndConquor {

	
    @Test
    public void testMaxSubarray() {
    	MaximumSubarrayByDivideAndConquor ms = new MaximumSubarrayByDivideAndConquor();
    	
    	int[] nums = new int[] {2, 5, -8, 3, 10, -11, 5, 4};
    	assertEquals(13, ms.maxSubArray(nums, 0, nums.length - 1)); 
    	
    	nums = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    	assertEquals(6, ms.maxSubArray(nums, 0, nums.length - 1)); 
    	
    	nums = new int[]  {3, -1, 4, -2, -7, 8, 10, -5, 2, -1, 6, -3, 7, -4, 2, -6, 5, 3, -2, 4};
    	assertEquals(26, ms.maxSubArray(nums, 0, nums.length - 1)); 
    	
    }
    
    private int maxCrossingArray(int[] nums, int start, int mid, int end) {
    	
    	int maxLeftSum = Integer.MIN_VALUE;
    	int currLeftSum = 0;
    	
    	for (int i=mid; i>=start; i--) {
    		currLeftSum += nums[i];
    		
    		if (currLeftSum > maxLeftSum) {
    			maxLeftSum = currLeftSum;
    		}
    	}
    	
    	int maxRightSum = Integer.MIN_VALUE;
    	int currRightSum = 0;
    	
    	for (int i=mid+1; i <= end; i++) {
    		currRightSum += nums[i];
    		
    		if (currRightSum > maxRightSum) {
    			maxRightSum = currRightSum;
    		}
    	}
    	
    	return maxLeftSum + maxRightSum;
    }
    
	public int maxSubArray(int[] nums, int start, int end) {
		
		if (start == end) return nums[start];
		
		int leftSum = 0;
		int rightSum = 0;
		int crossingSum = 0;
		
		int mid = Math.floorDiv(start + end, 2);
		
		leftSum = maxSubArray(nums, start, mid);
		rightSum = maxSubArray(nums, mid+1, end);
		crossingSum = maxCrossingArray(nums, start, mid, end);
		
		if (leftSum > rightSum && leftSum > crossingSum) {
			return leftSum;
		} else if (rightSum > leftSum && rightSum > crossingSum) {
			return rightSum;
		} else {
			return crossingSum;
		}
		
	}
}
