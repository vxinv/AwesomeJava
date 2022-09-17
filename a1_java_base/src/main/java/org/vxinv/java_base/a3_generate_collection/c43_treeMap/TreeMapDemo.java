package org.vxinv.java_base.a3_generate_collection.c43_treeMap;



import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;

public class TreeMapDemo {

    @Test
    public void basic() {
        Map<String, String> map = new TreeMap<>();
        map.put("a", "abstract");
        map.put("c", "call");
        map.put("b", "basic");
        map.put("T", "tree");

        for (Entry<String, String> kv : map.entrySet()) {
            System.out.print(kv.getKey() + "=" + kv.getValue() + " ");
        }
    }

    @Test
    public void comparator() {
        Map<String, String> map = new TreeMap<>((o1, o2) -> o2.compareTo(o1));

        map.put("a", "abstract");
        map.put("c", "call");
        map.put("b", "basic");
        map.put("T", "tree");

        for (Entry<String, String> kv : map.entrySet()) {
            System.out.print(kv.getKey() + "=" + kv.getValue() + " ");
        }
    }

    @Test
    public void reverse() {
        Map<String, String> map = new TreeMap<>(Collections.reverseOrder());
        map.put("a", "abstract");
        map.put("c", "call");
        map.put("b", "basic");
        map.put("T", "tree");

        for (Entry<String, String> kv : map.entrySet()) {
            System.out.print(kv.getKey() + "=" + kv.getValue() + " ");
        }
    }

    @Test
    public void date() {
        Map<String, Integer> map = new TreeMap<>();
        map.put("2016-7-3", 100);
        map.put("2016-7-10", 120);
        map.put("2016-8-1", 90);

        for (Entry<String, Integer> kv : map.entrySet()) {
            System.out.println(kv.getKey() + "," + kv.getValue());
        }



    }

    @Test
    public void dateComparator() {
        Map<String, Integer> map = new TreeMap<>(new Comparator<String>() {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            @Override
            public int compare(String o1, String o2) {
                try {
                    return sdf.parse(o1).compareTo(sdf.parse(o2));
                } catch (ParseException e) {
                    e.printStackTrace();
                    return 0;
                }
			}
		});

        map.put("2016-7-3", 100);
        map.put("2016-7-10", 120);
        map.put("2016-8-1", 90);

        for (Entry<String, Integer> kv : map.entrySet()) {
            System.out.println(kv.getKey() + "," + kv.getValue());
        }

    }

    @Test
    public void navigate() {
        NavigableMap<String, String> map = new TreeMap<>();
        map.put("a", "abstract");
        map.put("f", "final");
        map.put("c", "call");

        // 输出：a=abstract
        System.out.println(map.firstEntry());

        // 输出：f=final
        System.out.println(map.lastEntry());

		// 输出：c=call
		System.out.println(map.floorEntry("d"));

		// 输出：f=final
		System.out.println(map.ceilingEntry("d"));

		// 输出：{c=call, a=abstract}
		System.out.println(map.descendingMap().subMap("d", false, "a", true));

	}

}
