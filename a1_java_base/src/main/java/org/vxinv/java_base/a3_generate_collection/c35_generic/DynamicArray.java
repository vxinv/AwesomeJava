package org.vxinv.java_base.a3_generate_collection.c35_generic;

import java.util.Arrays;
// 第8章 泛型  8.1 基本概念和原理
public class DynamicArray<E> {

	private static final int DEFAULT_CAPACITY = 10;

	private int size;
	private Object[] elementData;

	public DynamicArray() {
		this.elementData = new Object[DEFAULT_CAPACITY];
	}

	private void ensureCapacity(int minCapacity) {
		int oldCapacity = elementData.length;
		if (oldCapacity >= minCapacity) {
			return;
		}
		int newCapacity = oldCapacity * 2;
		if (newCapacity < minCapacity)
			newCapacity = minCapacity;
		elementData = Arrays.copyOf(elementData, newCapacity);
	}

	public void add(E e) {
		ensureCapacity(size + 1);
		elementData[size++] = e;
	}

	@SuppressWarnings("unchecked")
	public E get(int index) {
		return (E) elementData[index];
	}

	public int size() {
		return size;
	}

	public E set(int index, E element) {
		E oldValue = get(index);
		elementData[index] = element;
		return oldValue;
	}

	public <T extends E> void addAll(DynamicArray<T> c) {
	    for(int i=0; i<c.size; i++){
	        add(c.get(i));
	    }
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DynamicArray<Number> numbers = new DynamicArray<Number>();
		DynamicArray<Integer> ints = new DynamicArray<Integer>();
		ints.add(100);
		ints.add(34);
		numbers.addAll(ints);

	}

}
