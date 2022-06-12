package org.vxinv.java_base.a3_generate_collection.c49_linkHashMap;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LinkedHashMapDemo {

	@Test
	public void basic() {
		Map<String, Integer> seqMap = new LinkedHashMap<>();

		seqMap.put("c", 100);
		seqMap.put("d", 200);
		seqMap.put("a", 500);
		seqMap.put("d", 300);

		for (Entry<String, Integer> entry : seqMap.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}

	@Test
	public void byaccess() {
		Map<String, Integer> accessMap = new LinkedHashMap<>(16, 0.75f, true);

		accessMap.put("c", 100);
		accessMap.put("d", 200);
		accessMap.put("a", 500);
		accessMap.get("c");
		accessMap.put("d", 300);

		for (Entry<String, Integer> entry : accessMap.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}


}
