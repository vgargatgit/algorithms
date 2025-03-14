package com.vgarg.algorithms.sorting;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class MergeSort {
	
	public void mergeSort(int[] arr, int p, int r) {
		
		if (p < r) {
			int q = Math.floorDiv(p + r, 2);
			mergeSort(arr, p, q);
			mergeSort(arr, q+1, r);
			merge(arr, p, q, r);
		}
		
	}
	
	public void merge(int[] arr, int p, int q, int r) {
		int n1 = q - p + 1;
		int n2 = r - q;
		
		int[] lArr = new int[n1 + 1];
		int[] rArr = new int[n2 + 1];
		
		for (int i=0; i < n1; i++) 
			lArr[i] = arr[p + i];
		
		for (int i=0; i < n2; i++) 
			rArr[i] = arr[q + i + 1];
		
		lArr[n1] = Integer.MAX_VALUE;
		rArr[n2] = Integer.MAX_VALUE;
		
		int i = 0;
		int j = 0;
		for (int k=p; k <= r; k++) {
			if (lArr[i] <= rArr[j]) {
				arr[k] = lArr[i];
				i++;
			} else {
				arr[k] = rArr[j];
				j++;
			}
		}
	}
	
    
	@Test
 	public void testMerge() {
		int[] arr = new int[] {2, 10, 17, 3, 5, 99};
		
		merge(arr, 0, 2, 5);
		assertArrayEquals(new int[] {2, 3, 5, 10, 17, 99}, arr);
	}
	
	@Test
 	public void testMergeSort() {
		testMergeSort1();
		testMergeSort2();
		testMergeSort3();
	}
	
	public void testMergeSort1() {
		int[] arr = new int[] {2, 10, 17, 3, 5, 99};
		
		mergeSort(arr, 0, 5);
		assertArrayEquals(new int[] {2, 3, 5, 10, 17, 99}, arr);
	}
	
	public void testMergeSort2() {
		int[] arr = new int[] {2};
		
		mergeSort(arr, 0, 0);
		assertArrayEquals(new int[] {2}, arr);
	}
	
	public void testMergeSort3() {
		int[] arr = new int[] {99, 5, 11, 55, 0, 0, 9, 10};
		
		mergeSort(arr, 0, 7);
		assertArrayEquals(new int[] {0, 0, 5, 9, 10, 11, 55, 99}, arr);
	}
 	
}
