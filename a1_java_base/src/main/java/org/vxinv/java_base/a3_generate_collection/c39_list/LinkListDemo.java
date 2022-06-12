package org.vxinv.java_base.a3_generate_collection.c39_list;

import java.util.*;

public class LinkListDemo {

	public static void stack() {
		Deque<String> stack = new LinkedList<>();
		// c
		// b
		// a
		stack.push("a");
		stack.push("b");
		stack.push("c");

		while (stack.peek() != null) {
			System.out.println(stack.pop());
		}
	}

	public static void queue() {
		Queue<String> strings = new LinkedList<String>(Arrays.asList("a", "b", "c"));
		strings.offer("d");
		// d->c ->b ->a
		// FIFO
		while (strings.peek() != null) {
			System.out.println(strings.poll());
		}
	}

	public static void reverse() {
		Deque<String> deque = new LinkedList<>(
				Arrays.asList("a", "b", "c"));
		Iterator<String> it = deque.descendingIterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		stack();
		System.out.println("-----------");
		queue();
	}

}
