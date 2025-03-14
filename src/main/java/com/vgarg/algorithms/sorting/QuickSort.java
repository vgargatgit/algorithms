package com.vgarg.algorithms.sorting;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class QuickSort {

	public static void main(String[] args) {
		
		
	}
	
	public static void quickSort(int[] arr, int start, int end) {
		
		if (start == end) return;
		
		int partitionIndex = partition(arr, start, end);
		
		if (partitionIndex >= 0) {
			quickSort(arr, start, partitionIndex);	
		}
		
		quickSort(arr, partitionIndex + 1, end);
	
	}
	
	public static int partition(int[] arr, int start, int end) {
		
		int i = start - 1;
		int pivot = arr[end];
		
		for (int j = start; j < end; j++) {
			if (arr[j] <= pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		
		swap(arr, i+1, end);
		return i;
	}
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}
	
	@Test
	public void testPartition() {
		
		int [] arr = new int[] {8, 19, 10, 2, 17, 9, 11};
		
		int i = partition(arr, 0, arr.length - 1);
		assertArrayEquals(Arrays.copyOfRange(arr, 0, i+1), new int[] {8, 10, 2, 9});
		assertArrayEquals(Arrays.copyOfRange(arr, i+1, arr.length), new int[] {11, 19, 17});
		
		arr = new int[] {8, 2};
		i = partition(arr, 0, arr.length - 1);
		assertArrayEquals(Arrays.copyOfRange(arr, 0, i+1), new int[] {});
		assertArrayEquals(Arrays.copyOfRange(arr, i+1, arr.length), new int[] {2, 8});
	}
	
	@Test
	public void testQuickSort() {
		
		int [] arr = new int[] {8, 19, 10, 2, 17, 9, 11};
		
		quickSort(arr, 0, arr.length -1);
		
		assertArrayEquals(new int[] {2, 8, 9, 10, 11, 17, 19}, arr);		
	}
}
