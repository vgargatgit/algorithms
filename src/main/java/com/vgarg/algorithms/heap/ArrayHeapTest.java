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
	
	@Test
	public void testBuiltMaxHeap() {
		Integer[] arr = new Integer[] {1, 4, 2, 3, 9, 7, 8, 10, 14, 16};
		ArrayHeap<Integer> ah = new ArrayHeap<>(arr);		
		ah.buildArrayHeap();
		assertArrayEquals(new Integer[] {16, 14, 8, 10, 9, 7, 2, 1, 3, 4}, ah.getArray());
	}
	
	@Test
	public void testHeapSort() {
		Integer[] arr = new Integer[] {1, 4, 2, 3, 9, 7, 8, 10, 14, 16};
		ArrayHeap<Integer> ah = new ArrayHeap<>(arr);		
		ah.buildArrayHeap();
		ah.heapSort();
		assertArrayEquals(new Integer[] {1, 2, 3, 4, 7, 8, 9, 10, 14, 16}, ah.getArray());
		
		arr = new Integer[] {0, 17, 3, 13, 16, 4, 1, 5, 12, 7, 10, 8, 9, 27};
		ah = new ArrayHeap<>(arr);		
		ah.buildArrayHeap();
		ah.heapSort();
		assertArrayEquals(new Integer[] {0, 1, 3, 4, 5, 7, 8, 9, 10, 12, 13, 16, 17, 27}, ah.getArray());
	}
}
