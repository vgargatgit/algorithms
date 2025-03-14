package com.vgarg.algorithms.sorting;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class InsertionSort {
	
	public static void main(String[] args) {
		
	}
	
	public int[] insertionSort(int[] arr) {
		
		int size = arr.length;
		
		for (int i = 1; i < size; i++) {			
			for (int j = i - 1; j >= 0; j--) {
				if (arr[j+1] < arr[j]) {
					int temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
				} else {
					break;
				}
			}
		}
		
		return arr;
	}
	
	@Test
	public void testInsertionSort() {
		assertArrayEquals(new int[] {1, 3, 5, 6, 7, 8}, insertionSort(new int[] {8, 7, 5, 6, 3, 1}));
		assertArrayEquals(new int[] {1, 2, 3, 5, 8, 9}, insertionSort(new int[] {1, 2, 3, 5, 8, 9}));
		assertArrayEquals(new int[] {1, 2, 3, 5, 8, 9}, insertionSort(new int[] {9, 8, 5, 3, 2, 1}));
		assertArrayEquals(new int[] {1}, insertionSort(new int[] {1}));
		assertArrayEquals(new int[] {}, insertionSort(new int[] {}));
	}
}
