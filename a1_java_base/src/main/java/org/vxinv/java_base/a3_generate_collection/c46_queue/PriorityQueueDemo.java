package org.vxinv.java_base.a3_generate_collection.c46_queue;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueDemo {

	public static void basic() {
		Queue<Integer> pq = new PriorityQueue<>();
		pq.offer(10);
		pq.add(22);
		pq.addAll(Arrays.asList(11, 12, 34, 2, 7, 4, 15, 12, 8, 6, 19, 13));
		while (pq.peek() != null) {
			System.out.print(pq.poll() + " ");
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
