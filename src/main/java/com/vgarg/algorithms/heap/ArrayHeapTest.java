package com.vgarg.algorithms.heap;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class ArrayHeapTest {
	
	@Test
	public void testMaxHeapify() {
		Integer[] arr = new Integer[] {16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
		ArrayHeap<Integer> ah = new ArrayHeap<>(arr);		
		ah.maxHeapify(1);
		assertArrayEquals(new Integer[] {16, 14, 10, 8, 7, 9, 3, 2, 4, 1}, ah.getArray());
		
		arr = new Integer[] {27, 17, 3, 16, 13, 10, 1, 5, 7, 12, 4, 8, 9, 0};
		ah = new ArrayHeap<>(arr);		
		ah.maxHeapify(2);
		assertArrayEquals(new Integer[] {27, 17, 10, 16, 13, 9, 1, 5, 7, 12, 4, 8, 3, 0}, ah.getArray());
	}
	
	@Test
	public void testMaxHeapifyNonRecurssive() {
		Integer[] arr = new Integer[] {16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
		ArrayHeap<Integer> ah = new ArrayHeap<>(arr);		
		ah.maxHeapifyNonRecursive(1);
		assertArrayEquals(new Integer[] {16, 14, 10, 8, 7, 9, 3, 2, 4, 1}, ah.getArray());
		
		arr = new Integer[] {27, 17, 3, 16, 13, 10, 1, 5, 7, 12, 4, 8, 9, 0};
		ah = new ArrayHeap<>(arr);		
		ah.maxHeapifyNonRecursive(2);
		assertArrayEquals(new Integer[] {27, 17, 10, 16, 13, 9, 1, 5, 7, 12, 4, 8, 3, 0}, ah.getArray());
	}
}
