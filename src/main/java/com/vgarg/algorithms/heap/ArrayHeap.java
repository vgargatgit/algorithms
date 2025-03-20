package com.vgarg.algorithms.heap;

public class ArrayHeap<T extends Comparable<T>> {
	
	private T[] array;
	
	private int heapSize;
	
	public ArrayHeap(T[] arr) {
		this.array = arr;
		this.heapSize = arr.length;
	}
	
	public T[] getArray() {
		return array;
	}
	
	public int getHeapSize() {
		return heapSize;
	}
	
	public int left(int i) {
		return 2 * i + 1;
	}
	
	public int right(int i) {
		return 2 * (i + 1);
	}
	
	public int parent(int i) {		
		if (i == 0) return -1;		
		return Math.floorDiv(i - 1, 2);
	}
	
	public void maxHeapify(int i) {
		int l = left(i);
		int r = right(i);
		int largest = -1;
		
		if (l < heapSize && array[l].compareTo(array[i]) > 0) { 
			largest = l;
		} else {
			largest = i;
		}
		
		if (r < heapSize && array[r].compareTo(array[largest]) > 0) {
			largest = r;
		}
		
		if (largest != i) {
			T temp = array[i];
			array[i] = array[largest];
			array[largest] = temp;
			maxHeapify(largest);
		}
		
	}

	public void maxHeapifyNonRecursive(int i) {
		
		int currIndex = i;
		
		while (currIndex != -1) {
			int l = left(currIndex);
			int r = right(currIndex);
			int largest = -1;
			
			if (l < heapSize && array[l].compareTo(array[currIndex]) > 0) { 
				largest = l;
			} else {
				largest = currIndex;
			}
			
			if (r < heapSize && array[r].compareTo(array[largest]) > 0) {
				largest = r;
			}
			
			if (largest != currIndex) {
				T temp = array[currIndex];
				array[currIndex] = array[largest];
				array[largest] = temp;
				currIndex = largest;
			} else {
				currIndex = -1;
			}
			
		}
		
	}
	
	public void buildArrayHeap() {
		
		int lastNonLeafIndex = Math.floorDiv(getHeapSize(), 2) - 1;
		
		for (int i=lastNonLeafIndex; i >=0; i--) 
			maxHeapifyNonRecursive(i);
		
	}
	
	public void heapSort() {
		int heapSizeStart = this.heapSize;
		
		for (int i=heapSizeStart - 1; i >= 1; i--) {
			T temp = this.array[i];
			this.array[i] = this.array[0];
			this.array[0] = temp;
			this.heapSize -= 1;
			maxHeapifyNonRecursive(0);
		}
	}

}


